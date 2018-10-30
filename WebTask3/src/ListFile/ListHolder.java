package ListFile;

/**
* ListFile/ListHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��List.idl
* 2017��4��25�� ���ڶ� ����09ʱ15��44�� CST
*/

public final class ListHolder implements org.omg.CORBA.portable.Streamable
{
  public ListFile.List value = null;

  public ListHolder ()
  {
  }

  public ListHolder (ListFile.List initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ListFile.ListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ListFile.ListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ListFile.ListHelper.type ();
  }

}
