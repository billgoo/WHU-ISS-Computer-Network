package ListFile;

/**
* ListFile/ListHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从List.idl
* 2017年4月25日 星期二 下午09时15分44秒 CST
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
