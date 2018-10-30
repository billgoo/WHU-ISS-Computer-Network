import java.io.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import ListFile.*;
import CreatorFile.*;


public class CorbaClient {

	static int argSum[] = { 0, 3, 5, 3, 2, 4, 0, 0 };

	/**
	 * Connect with the servant and do operations which the user input.
	 */
	public static void main(String[] args) {

		try {

			// connect with the servant
			ORB orb = ORB.init(args, null);
			NameComponent component;
			org.omg.CORBA.Object remoteListRef, remoteCreatorRef;

			Creator creator;
			List list;

			org.omg.CORBA.Object object = orb
					.resolve_initial_references("NameService");
			NamingContext namingContext = NamingContextHelper.narrow(object);

			component = new NameComponent("Creator", "");
			NameComponent[] creators = { component };
			remoteCreatorRef = namingContext.resolve(creators);
			creator = CreatorHelper.narrow(remoteCreatorRef);

			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));

			/* initialize the variables */
			String cmd = "";
			int choice;

			// get the register or login operation
			while (true) {

				displayMenu();

				cmd = input.readLine();
				try {
					choice = Integer.parseInt(cmd);
					if (choice < 0 || choice > 7)
						choice = 7;
				} catch (Exception e) {
					choice = 7;
				}

				String[] arg = getArgs(argSum[choice], input);

				if (choice == 0)
					return;

				if (choice == 6) {

					displayHelp();
					continue;
				}

				if (choice == 7) {

					System.err.println("Input Error!");
					continue;
				}

				if (choice == 1) {

					if (!arg[0].equals("") && arg[1].equals(arg[2]))
						if (creator.register(arg[0], arg[1])) {

							System.out.println("Success!");
							continue;
						}

					System.err.println("Fail!");
					continue;
				}

				try {
					component = new NameComponent(arg[0], "");
					NameComponent[] lists = { component };
					remoteListRef = namingContext.resolve(lists);
					list = ListHelper.narrow(remoteListRef);
				} catch (Exception e) {
					System.err.println("Fail!");
					continue;
				}

				if (choice == 2) {

					if (list.add(arg[0], arg[1], arg[2], arg[3], arg[4]))
						System.out.println("Success!");
					else
						System.err.println("Fail!");
				}

				if (choice == 3) {

					if (list.delete(arg[0], arg[1], Integer.parseInt(arg[2])))
						System.out.println("Success!");
					else
						System.err.println("Fail!");
				}

				if (choice == 4) {

					if (list.clear(arg[0], arg[1]))
						System.out.println("Success!");
					else
						System.err.println("Fail!");
				}

				if (choice == 5) {

					String q = list.query(arg[0], arg[1], arg[2], arg[3]);
					if (q != null)
						System.out.println(q);
					else
						System.err.println("Fail!");
				}
			}
		} catch (Exception e) {

			System.err.println(e.toString());
		}

	}

	/**
	 * Get the arguments which the operation needs.
	 */
	public static String[] getArgs(int s, BufferedReader input)
			throws Exception {

		String[] a = new String[s];
		for (int i = 0; i < s; i++) {

			System.out.println("Please input the No." + (i + 1) + " argument");
			do
				a[i] = input.readLine();
			while (a[i].equals(""));
		}

		return a;
	}

	/**
	 * Display the help documents to guide the user.
	 */
	public static void displayHelp() {

		System.out.println("Help:\n"
				+ "\t 1. You need to input the number "
				+ "that the operation you want.\n"
				+ "\t 2. The program will do nothing "
				+ "if you input a wrong number.\n"
				+ "\t 3. The date should be \"YYYY_M_D_h_m_s\"\n");
	}

	/**
	 * Display the menu to guide the user to do deeper operations.
	 */
	public static void displayMenu() {

		System.out.println("Corba Menu:");
		System.out.println("\t 0. quit\n" + "\t\targuments: no args\n");
		System.out.println("\t 1. register\n"
				+ "\t\targuments: <username&gt; <password&gt; <password&gt;");
		System.out.println("\t 2. add\n"
				+ "\t\targuments: <username&gt; <password&gt; <start&gt; <end&gt; <label&gt;");
		System.out.println("\t 3. delete\n"
				+ "\t\targuments: <username&gt; <password&gt; <itemid&gt;");
		System.out.println("\t 4. clear\n"
				+ "\t\targuments: <username&gt; <password&gt;");
		System.out.println("\t 5. query\n"
				+ "\t\targuments: <username&gt; <password&gt; <start&gt; <end>");
		System.out.println("\t 6. help\n" + "\t\targuments: no args");
		
	}
}

