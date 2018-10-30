package CreatorFile;

/**
* CreatorFile/CreatorHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Creator.idl
* 2017年4月25日 星期二 下午09时15分34秒 CST
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
