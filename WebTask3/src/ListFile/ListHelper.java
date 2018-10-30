package ListFile;


/**
* ListFile/ListHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��List.idl
* 2017��4��25�� ���ڶ� ����09ʱ15��44�� CST
*/

abstract public class ListHelper
{
  private static String  _id = "IDL:ListFile/List:1.0";

  public static void insert (org.omg.CORBA.Any a, ListFile.List that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ListFile.List extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ListFile.ListHelper.id (), "List");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ListFile.List read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ListStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ListFile.List value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ListFile.List narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ListFile.List)
      return (ListFile.List)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ListFile._ListStub stub = new ListFile._ListStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ListFile.List unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ListFile.List)
      return (ListFile.List)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ListFile._ListStub stub = new ListFile._ListStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
