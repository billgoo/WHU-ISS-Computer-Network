package ListFile;


/**
* ListFile/ListOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从List.idl
* 2017年4月25日 星期二 下午09时15分44秒 CST
*/

public interface ListOperations 
{
  boolean add (String username, String password, String start_time, String end_time, String description);
  String query (String username, String password, String start_time, String end_time);
  boolean delete (String username, String password, int item_id);
  boolean clear (String username, String password);
} // interface ListOperations
