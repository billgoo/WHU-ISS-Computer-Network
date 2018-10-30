package CreatorFile;


/**
* CreatorFile/CreatorHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Creator.idl
* 2017年4月25日 星期二 下午09时15分34秒 CST
*/

abstract public class CreatorHelper
{
  private static String  _id = "IDL:CreatorFile/Creator:1.0";

  public static void insert (org.omg.CORBA.Any a, CreatorFile.Creator that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CreatorFile.Creator extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CreatorFile.CreatorHelper.id (), "Creator");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CreatorFile.Creator read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CreatorStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CreatorFile.Creator value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CreatorFile.Creator narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CreatorFile.Creator)
      return (CreatorFile.Creator)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CreatorFile._CreatorStub stub = new CreatorFile._CreatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CreatorFile.Creator unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CreatorFile.Creator)
      return (CreatorFile.Creator)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CreatorFile._CreatorStub stub = new CreatorFile._CreatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
