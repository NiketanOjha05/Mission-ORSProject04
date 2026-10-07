package in.co.rays.proj4.bean;

import java.sql.ResultSet;

public class LibraryBean extends BaseBean {

	private int bookid;
	private String title;
	private String author;
	private double prize;
	private boolean availability;

	public int getBookid() {
		return bookid;
	}

	public void setBookId(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String getValue() {

		return title;
	}

	@Override
	public void setResultSet(ResultSet rs) {

		try {
			setBookId(rs.getInt("bookid"));
			setTitle(rs.getString("title"));
			setAuthor(rs.getString("auther"));
			setPrize(rs.getDouble("prize"));
			setAvailability(rs.getBoolean("availability"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setResultSet(rs);
	}

}
