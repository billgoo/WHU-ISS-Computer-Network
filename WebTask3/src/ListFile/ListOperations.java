package ListFile;


/**
* ListFile/ListOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��List.idl
* 2017��4��25�� ���ڶ� ����09ʱ15��44�� CST
*/

public interface ListOperations 
{
  boolean add (String username, String password, String start_time, String end_time, String description);
  String query (String username, String password, String start_time, String end_time);
  boolean delete (String username, String password, int item_id);
  boolean clear (String username, String password);
} // interface ListOperations
