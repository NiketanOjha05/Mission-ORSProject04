package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class UserModel extends BaseModel<UserBean> {

	@Override
	public long add(UserBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		try {
			pk = nextPk();

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setInt(9, bean.getUnsuccessfulLogin());
			pstmt.setString(10, bean.getGender());
			pstmt.setTimestamp(11, bean.getLastLogin());
			pstmt.setString(12, bean.getUserLock());
			pstmt.setString(13, bean.getRegisteredIP());
			pstmt.setString(14, bean.getLastLoginIP());
			pstmt.setString(15, bean.getCreatedBy());
			pstmt.setString(16, bean.getModifiedBy());
			pstmt.setTimestamp(17, bean.getCreatedDatetime());
			pstmt.setTimestamp(18, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted : " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.rollBack(conn);

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return 0;
	}

	@Override
	public void update(UserBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " firstName = ?, lastName = ?, login = ?, password = ?, confirmPassword = ?, dob = ?, mobileNo = ?, roleId = ?, unSuccessfulLogin = ?, gender = ?, lastLogin = ?, lock = ?, registerdIp = ?, lastLoginIp = ?, createdBy = ?, modifiedBy = ?, createdDatetime = ?, modifiedDatetime = ? where id = ?");

			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setInt(9, bean.getUnsuccessfulLogin());
			pstmt.setString(10, bean.getGender());
			pstmt.setTimestamp(11, bean.getLastLogin());
			pstmt.setString(12, bean.getUserLock());
			pstmt.setString(13, bean.getRegisteredIP());
			pstmt.setString(14, bean.getLastLoginIP());
			pstmt.setString(15, bean.getCreatedBy());
			pstmt.setString(16, bean.getModifiedBy());
			pstmt.setTimestamp(17, bean.getCreatedDatetime());
			pstmt.setTimestamp(18, bean.getModifiedDatetime());
			pstmt.setLong(1, bean.getId());

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
	public String getWhereClause(UserBean bean) {

		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}
			if (bean.getRoleId() > 0) {
				sql.append(" and roleId = " + bean.getRoleId());
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" and login like '" + bean.getLogin() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {

		return "st_user";
	}

	@Override
	public UserBean getBean() {

		return new UserBean();
	}

}
