package ListFile;


/**
* ListFile/_ListStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从List.idl
* 2017年4月25日 星期二 下午09时15分44秒 CST
*/

public class _ListStub extends org.omg.CORBA.portable.ObjectImpl implements ListFile.List
{

  public boolean add (String username, String password, String start_time, String end_time, String description)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("add", true);
                $out.write_string (username);
                $out.write_string (password);
                $out.write_string (start_time);
                $out.write_string (end_time);
                $out.write_string (description);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return add (username, password, start_time, end_time, description        );
            } finally {
                _releaseReply ($in);
            }
  } // add

  public String query (String username, String password, String start_time, String end_time)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("query", true);
                $out.write_string (username);
                $out.write_string (password);
                $out.write_string (start_time);
                $out.write_string (end_time);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return query (username, password, start_time, end_time        );
            } finally {
                _releaseReply ($in);
            }
  } // query

  public boolean delete (String username, String password, int item_id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("delete", true);
                $out.write_string (username);
                $out.write_string (password);
                $out.write_long (item_id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return delete (username, password, item_id        );
            } finally {
                _releaseReply ($in);
            }
  } // delete

  public boolean clear (String username, String password)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("clear", true);
                $out.write_string (username);
                $out.write_string (password);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return clear (username, password        );
            } finally {
                _releaseReply ($in);
            }
  } // clear

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ListFile/List:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ListStub
