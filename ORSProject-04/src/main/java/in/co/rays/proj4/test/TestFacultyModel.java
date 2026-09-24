package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;

public class TestFacultyModel {

	public static FacultyModel model = new FacultyModel();

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
		testSearch();

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FacultyBean bean = new FacultyBean();

		bean.setCollegeId(5);
		bean.setCollegeName("University of Calcutta");
		bean.setFirstName("Varun");
		bean.setLastName("Mishra");
		bean.setEmail("varun@gmail.com");
		bean.setMobileNo("8061725349");
		bean.setAddress("Kolkata");
		bean.setGender("Male");
		bean.setDateOfBirth(sdf.parse("1998-11-26"));
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		FacultyBean bean = new FacultyBean();

		bean.setId(1);
		bean.setCollegeId(1);
		bean.setCollegeName("University of Delhi");
		bean.setFirstName("Varun");
		bean.setLastName("Mishra");
		bean.setEmail("varun@gmail.com");
		bean.setMobileNo("8061725349");
		bean.setAddress("Delhi");
		bean.setGender("Male");
		bean.setDateOfBirth(sdf.parse("1998-11-26"));
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testDelete() {

		model.delete(2);
	}

	private static void testfindByPk() {

		FacultyBean bean = model.findByPk(1);

		System.out.println(bean.getId());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getEmail());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getAddress());
		System.out.println(bean.getGender());
		System.out.println(bean.getDateOfBirth());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
	}

	private static void testSearch() {

		FacultyBean bean = new FacultyBean();

		List<FacultyBean> list = model.search(bean, 1, 5);

		Iterator<FacultyBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getEmail());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getAddress());
			System.out.println(bean.getGender());
			System.out.println(bean.getDateOfBirth());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

			System.out.println("-----------------------------");
		}
	}
}