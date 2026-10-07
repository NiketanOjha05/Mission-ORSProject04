package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.LibraryBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class LibraryModel extends BaseModel<LibraryBean> {

	@Override
	public long add(LibraryBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		int pk = 0;

		try {
			pk = nextPk();

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getAuthor());
			pstmt.setDouble(4, bean.getPrize());
			pstmt.setBoolean(5, bean.getAvailability());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record inserted Successfully : " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.rollBack(conn);

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(LibraryBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set title = ?, auther = ?, prize = ?, availability = ?, where bookid = ?");

			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setDouble(3, bean.getPrize());
			pstmt.setBoolean(4, bean.getAvailability());
			pstmt.setLong(5, bean.getBookid());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record updated successfully : " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.rollBack(conn);

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(LibraryBean bean) {

		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getBookid() > 0) {
				sql.append("and bookid = " + bean.getBookid());
			}
			if (bean.getTitle() != null && bean.getTitle().length() > 0) {
				sql.append("and title like '" + bean.getTitle() + "%'");
			}
			if (bean.getAuthor() != null && bean.getAuthor().length() > 0) {
				sql.append("and auther like '" + bean.getAuthor() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {

		return "library";
	}

	@Override
	public LibraryBean getBean() {

		return new LibraryBean();
	}

}
