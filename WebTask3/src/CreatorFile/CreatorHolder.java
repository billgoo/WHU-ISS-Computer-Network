package CreatorFile;

/**
* CreatorFile/CreatorHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Creator.idl
* 2017��4��25�� ���ڶ� ����09ʱ15��34�� CST
*/

public final class CreatorHolder implements org.omg.CORBA.portable.Streamable
{
  public CreatorFile.Creator value = null;

  public CreatorHolder ()
  {
  }

  public CreatorHolder (CreatorFile.Creator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CreatorFile.CreatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CreatorFile.CreatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CreatorFile.CreatorHelper.type ();
  }

}
