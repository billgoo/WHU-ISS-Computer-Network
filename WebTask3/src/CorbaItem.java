import java.util.*;

public class CorbaItem {

	private String username;
	private int id;
	private Date start;
	private Date end;
	private String label;

	/**
	 * The default constructor.
	 */
	public CorbaItem() {
	}

	/**
	 * The constructor that has all attributes initial.
	 */
	public CorbaItem(String u, int i, Date s, Date e, String l) {

		username = u;
		id = i;
		start = s;
		end = e;
		label = l;
	}

	/**
	 * Return the username.
	 */
	public String getUsername() {

		return username;
	}

	/**
	 * Return the id.
	 */
	public int getId() {

		return id;
	}

	/**
	 * Return the start time.
	 */
	public Date getStart() {

		return start;
	}

	/**
	 * Return the end time.
	 */
	public Date getEnd() {

		return end;
	}

	/**
	 * Return the lable.
	 */
	public String getLabel() {

		return label;
	}

	/**
	 * Return the description of the item.
	 */
	public String toString() {

		return "\n No." + id + ": " + label + "\n\t Start: " + start.toString()
				+ "\n\t End: " + end.toString();
	}
}
