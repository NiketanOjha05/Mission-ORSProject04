package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;

public class TestCollegeModel {

	public static CollegeModel model = new CollegeModel();

	public static void main(String[] args) {

//		testAdd();
//		testUpdate();
//		testDelete();
		testfindByPk();
//		testSearch();
	}

	private static void testAdd() {

		CollegeBean bean = new CollegeBean();

		bean.setName("Osmania University");
		bean.setAddress("Hyderabad");
		bean.setState("Telangana");
		bean.setCity("Hyderabad");
		bean.setPhoneNo("9876543218");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testUpdate() {

		CollegeBean bean = new CollegeBean();

		bean.setId(1);
		bean.setName("University of Patna");
		bean.setAddress("Patna");
		bean.setState("Bihar");
		bean.setCity("Patna");
		bean.setPhoneNo("9876543219");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testDelete() {

		CollegeBean bean = new CollegeBean();

		model.delete(2);
	}

	private static void testfindByPk() {

		CollegeBean bean = model.findByPk(3);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getAddress());
		System.out.println(bean.getState());
		System.out.println(bean.getCity());
		System.out.println(bean.getPhoneNo());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());

	}

	private static void testSearch() {

		CollegeBean bean = new CollegeBean();

		List<CollegeBean> list = model.search(bean, 1, 5);

		Iterator<CollegeBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		}

	}

}
