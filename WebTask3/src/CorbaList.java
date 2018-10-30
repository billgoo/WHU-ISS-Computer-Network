import java.util.*;
import ListFile.*;

public class CorbaList extends ListPOA {

	/* a hash table to store the user informations */
	private String username, password;

	/* a vector to store the items */
	private Vector<CorbaItem> items;

	/* count number of items added as the id of items */
	private static int counter = 1;

	/* count number of items deleted */
	private static int deleted = 0;

	/**
	 * The default construstor.
	 */
	public CorbaList(String username, String password) {

		this.username = username;
		this.password = password;
		items = new Vector<CorbaItem>();
	}

	/**
	 * Do the login operation.
	 */
	public boolean login(String username, String password) {

		if (username.equals(this.username) && password.equals(this.password))
			return true;
		return false;
	}

	/**
	 * Do the add operation.
	 */
	public boolean add(String username, String password, String start,
			String end, String label) {

		Date s = toDate(start);
		Date e = toDate(end);

		if (!login(username, password))
			return false;

		if (s == null || e == null)
			return false;

		if (s.after(e))
			return false;

		CorbaItem item = new CorbaItem(username, counter, s, e, label);
		items.add(item);
		counter++;

		return true;
	}

	/**
	 * Do the query operation.
	 */
	public String query(String username, String password, String start,
			String end) {

		Date s = toDate(start);
		Date e = toDate(end);

		if (!login(username, password))
			return "Fail!";

		if (s == null || e == null)
			return "Fail!";

		if (s.after(e))
			return "Fail!";

		CorbaItem item;
		Vector<CorbaItem> v = new Vector<CorbaItem>();
		for (Iterator it = items.iterator(); it.hasNext();) {

			item = (CorbaItem) it.next();

			if (e.before(item.getStart()) || s.after(item.getEnd()))
				continue;

			v.add(item);
		}

		if (v.isEmpty())
			return "[No items here.]";

		return v.toString();
	}

	/**
	 * Do the delete operation.
	 */
	public boolean delete(String username, String password, int id) {

		if (!login(username, password))
			return false;

		CorbaItem item;
		for (int i = 0; i < items.size(); i++) {

			item = items.get(i);
			if (id == item.getId()) {
				items.remove(i);
				i--;
				deleted++;
				return true;
			}
		}

		return false;
	}

	/**
	 * Do the clear operation.
	 */
	public boolean clear(String username, String password) {
		if (!login(username, password))
			return false;

		items.clear();

		return true;
	}

	/**
	 * Translate a string to date.
	 */
	public static Date toDate(String date) {

		StringTokenizer token = new StringTokenizer(date, "_");

		if (token.countTokens() != 6)
			return null;

		int year = Integer.parseInt(token.nextToken());
		int month = Integer.parseInt(token.nextToken());
		int day = Integer.parseInt(token.nextToken());
		int hour = Integer.parseInt(token.nextToken());
		int minute = Integer.parseInt(token.nextToken());
		int second = Integer.parseInt(token.nextToken());
		Date d = new Date(year, month, day, hour, minute, second);
		return d;
	}
}
