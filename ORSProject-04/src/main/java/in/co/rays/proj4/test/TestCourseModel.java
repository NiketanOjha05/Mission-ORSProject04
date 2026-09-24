package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {

	public static CourseModel model = new CourseModel();

	public static void main(String[] args) {

//		testAdd();
//		testUpdate();
//		testDelete();
		testfindByPk();
//		testSearch();

	}

	private static void testAdd() {

		CourseBean bean = new CourseBean();

		bean.setName("Java Programming");
		bean.setDescription("Core Java and OOP concepts");
		bean.setDuration("6 Months");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testUpdate() {

		CourseBean bean = new CourseBean();

		bean.setId(11);
		bean.setName("Phython Programming");
		bean.setDescription("Core Java and OOP concepts");
		bean.setDuration("6 Months");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testDelete() {

		model.delete(11);

	}

	private static void testfindByPk() {

		CourseBean bean = model.findByPk(1);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getDuration());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedBy());

	}

	private static void testSearch() {

		CourseBean bean = new CourseBean();

		List<CourseBean> list = model.search(bean, 1, 5);

		Iterator<CourseBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getDuration());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		}

	}
}