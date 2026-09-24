package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {

	public static UserModel model = new UserModel();
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException {

//		testAdd();
//		testUpdate();
//		testDelete();
		testfindByPk();
//		testSearch();

	}

	private static void testAdd() throws ParseException {

		UserBean bean = new UserBean();

		bean.setFirstName("Nisha");
		bean.setLastName("Pandey");
		bean.setLogin("nisha@gmail.com");
		bean.setPassword("nisha123");
		bean.setDob(sdf.parse("2001-12-16"));
		bean.setMobileNo("7953146280");
		bean.setRoleId(2);
		bean.setUnsuccessfulLogin(1);
		bean.setGender("Female");
		bean.setLastLogin(new Timestamp(new Date().getTime()));
		bean.setUserLock("Inactive");
		bean.setRegisteredIP("10.0.0.40");
		bean.setLastLoginIP("10.0.0.50");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}

	private static void testUpdate() throws ParseException {

		UserBean bean = new UserBean();

		bean.setId(0);
		bean.setFirstName("Nirmal");
		bean.setLastName("Fayake");
		bean.setLogin("nirmal@gmail.com");
		bean.setPassword("nirmal123");
		bean.setDob(sdf.parse("2000-12-10"));
		bean.setRoleId(1);
		bean.setUnsuccessfulLogin(1);
		bean.setGender("Male");
		bean.setLastLogin(new Timestamp(new Date().getTime()));
		bean.setUserLock("Active");
		bean.setRegisteredIP("10.0.0.1");
		bean.setLastLoginIP("10.0.0.10");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() {

		UserBean bean = new UserBean();

		model.delete(0);
	}

	private static void testfindByPk() {

		UserBean bean = model.findByPk(1);

		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getRoleId());
		System.out.println(bean.getUnsuccessfulLogin());
		System.out.println(bean.getGender());
		System.out.println(bean.getLastLogin());
		System.out.println(bean.getUserLock());
		System.out.println(bean.getRegisteredIP());
		System.out.println(bean.getLastLoginIP());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());

	}

	private static void testSearch() {

		UserBean bean = new UserBean();

		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnsuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getUserLock());
			System.out.println(bean.getRegisteredIP());
			System.out.println(bean.getLastLoginIP());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		}

	}

}
