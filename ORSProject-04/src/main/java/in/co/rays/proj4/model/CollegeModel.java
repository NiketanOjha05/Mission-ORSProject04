package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class CollegeModel extends BaseModel<CollegeBean> {

	@Override
	public long add(CollegeBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		try {
			pk = nextPk();

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getState());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getPhoneNo());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDatetime());
			pstmt.setTimestamp(10, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted : " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.rollBack(conn);

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(CollegeBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set name = ?, address = ?, state = ?, city = ?, phone_No = ?, created_By = ?, modified_By = ?, created_Datetime = ?, modified_Datetime = ? where id = ?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setString(3, bean.getState());
			pstmt.setString(4, bean.getCity());
			pstmt.setString(5, bean.getPhoneNo());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.setLong(10, bean.getId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Update : " + i);

		} catch (Exception e) {
			e.printStackTrace();

			JDBCDataSource.rollBack(conn);

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	@Override
	public String getWhereClause(CollegeBean bean) {

		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append("and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append("and name like '" + bean.getName() + "%'");

			}
			if (bean.getState() != null && bean.getState().length() > 0) {
				sql.append(" and state like '" + bean.getState() + "%'");
			}
			if (bean.getCity() != null && bean.getCity().length() > 0) {
				sql.append(" and city like '" + bean.getCity() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {

		return "st_college";
	}

	@Override
	public CollegeBean getBean() {

		return new CollegeBean();
	}

}