package in.co.rays.proj4.bean;

import java.sql.ResultSet;

public class MarksheetBean extends BaseBean {

	private String rollNo;
	private long studentId;
	private String name;
	private int chemistry;
	private int physics;
	private int maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	@Override
	public String getValue() {

		return rollNo;
	}

	@Override
	public void setResultSet(ResultSet rs) {

		try {
			setRollNo(rs.getString("roll_no"));
			setStudentId(rs.getLong("student_id"));
			setName(rs.getString("name"));
			setChemistry(rs.getInt("chemistry"));
			setPhysics(rs.getInt("physics"));
			setMaths(rs.getInt("maths"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setResultSet(rs);
	}

}
