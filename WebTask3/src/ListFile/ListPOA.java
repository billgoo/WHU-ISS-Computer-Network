package ListFile;


/**
* ListFile/ListPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从List.idl
* 2017年4月25日 星期二 下午09时15分44秒 CST
*/

public abstract class ListPOA extends org.omg.PortableServer.Servant
 implements ListFile.ListOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("query", new java.lang.Integer (1));
    _methods.put ("delete", new java.lang.Integer (2));
    _methods.put ("clear", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ListFile/List/add
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String start_time = in.read_string ();
         String end_time = in.read_string ();
         String description = in.read_string ();
         boolean $result = false;
         $result = this.add (username, password, start_time, end_time, description);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // ListFile/List/query
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String start_time = in.read_string ();
         String end_time = in.read_string ();
         String $result = null;
         $result = this.query (username, password, start_time, end_time);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // ListFile/List/delete
       {
         String username = in.read_string ();
         String password = in.read_string ();
         int item_id = in.read_long ();
         boolean $result = false;
         $result = this.delete (username, password, item_id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // ListFile/List/clear
       {
         String username = in.read_string ();
         String password = in.read_string ();
         boolean $result = false;
         $result = this.clear (username, password);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ListFile/List:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public List _this() 
  {
    return ListHelper.narrow(
    super._this_object());
  }

  public List _this(org.omg.CORBA.ORB orb) 
  {
    return ListHelper.narrow(
    super._this_object(orb));
  }


} // class ListPOA
