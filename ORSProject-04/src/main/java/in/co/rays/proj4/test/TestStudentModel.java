package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {

	public static StudentModel model = new StudentModel();

	public static void main(String[] args) throws Exception {

//		testAdd();
//		 testUpdate();
//		 testDelete();
		testFindByPk();
//		testSearch();

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		StudentBean bean = new StudentBean();

		bean.setCollegeId(6);
		bean.setCollegeName("University of Madras");
		bean.setFirstName("Nisha");
		bean.setLastName("Pandey");
		bean.setDateOfBirth(sdf.parse("2002-09-09"));
		bean.setMobileNo("7953146280");
		bean.setEmail("nisha@gmail.com");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testUpdate() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		StudentBean bean = new StudentBean();

		bean.setId(0);
		bean.setCollegeId(0);
		bean.setCollegeName("");
		bean.setFirstName("");
		bean.setLastName("");
		bean.setDateOfBirth(sdf.parse(""));
		bean.setMobileNo("");
		bean.setEmail("");
		bean.setCreatedBy("");
		bean.setModifiedBy("");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testDelete() {

		model.delete(6);
	}

	private static void testFindByPk() {

		StudentBean bean = model.findByPk(1);

		System.out.println(bean.getId());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDateOfBirth());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getEmail());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());

	}

	private static void testSearch() {
		StudentBean bean = new StudentBean();

		List<StudentBean> list = model.search(bean, 1, 5);

		Iterator<StudentBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDateOfBirth());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

			System.out.println("-------------------------------");

		}
	}
}
