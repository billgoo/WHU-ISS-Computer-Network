import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class CorbaServant {

	/**
	 * Run the servant and waiting for call from clients.
	 */
	public static void main(String[] args) {

		try {

			ORB orb = ORB.init(args, null);

			POA rootpoa = (POA) orb.resolve_initial_references("RootPOA");
			rootpoa.the_POAManager().activate();

			org.omg.CORBA.Object object = orb
					.resolve_initial_references("NameService");

			CorbaCreator creator = new CorbaCreator(args);

			org.omg.CORBA.Object remoteRef = rootpoa
					.servant_to_reference(creator);

			NamingContext namingContext = NamingContextHelper.narrow(object);

			NameComponent component = new NameComponent("Creator", "");
			NameComponent[] componentList = { component };

			namingContext.rebind(componentList, remoteRef);

			orb.run();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}

