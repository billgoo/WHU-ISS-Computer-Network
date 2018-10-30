import java.util.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.POA;
import CreatorFile.*;


public class CorbaCreator extends CreatorPOA {

	ORB orb;

	org.omg.CORBA.Object obj, remoteRef;

	NamingContext namingContext;

	NameComponent component;

	Vector<String> users = new Vector<String>();

	public CorbaCreator(String args[]) {

		try {
			orb = ORB.init(args, null);
		} catch (Exception e) {
		}
	}

	/**
	 * Do the register operation.
	 */
	public boolean register(String username, String password) {

		if (username.equals("") || password.equals(""))
			return false;

		if (users.contains(username))
			return false;

		try {

			POA rootpoa = (POA) orb.resolve_initial_references("RootPOA");
			rootpoa.the_POAManager().activate();

			CorbaList list = new CorbaList(username, password);
			remoteRef = rootpoa.servant_to_reference(list);

			obj = orb.resolve_initial_references("NameService");
			namingContext = NamingContextHelper.narrow(obj);

			component = new NameComponent(username, "");
			NameComponent[] componentList = { component };

			namingContext.rebind(componentList, remoteRef);
			users.add(username);

			return true;
		} catch (Exception e) {
		}

		return false;
	}
}
