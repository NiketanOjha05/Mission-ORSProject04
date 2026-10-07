package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.TimetableBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class TimetableModel extends BaseModel<TimetableBean> {

	@Override
	public long add(TimetableBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(getTable());

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.rollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return 0;
	}

	@Override
	public void update(TimetableBean bean) throws ApplicationException, DuplicateRecordException {

	}

	@Override
	public String getWhereClause(TimetableBean bean) {

		return null;
	}

	@Override
	public String getTable() {

		return "st_timetable";
	}

	@Override
	public TimetableBean getBean() {

		return new TimetableBean();
	}

}
