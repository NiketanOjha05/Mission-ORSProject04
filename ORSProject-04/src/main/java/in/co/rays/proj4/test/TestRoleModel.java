package in.co.rays.proj4.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Timestamp;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) {

//		testAdd();
//		testUpdate();
//		testDelete;
//		testfindByPk();
		testSearch();
	}

	private static void testAdd() {

		RoleBean Bean = new RoleBean();

		Bean.setName("KIOSK");
		Bean.setDescription("kiosk role");
		Bean.setCreatedBy("Niketan");
		Bean.setModifiedBy("Niketan");
		Bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		Bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(Bean);

	}

	private static void testUpdate() {

		RoleBean bean = new RoleBean();

		bean.setId(5);
		bean.setName("KIOSK");
		bean.setDescription("KIOSK role");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() {

		model.delete(1);

	}

	private static void testfindByPk() {

		RoleBean bean = model.findByPk(1);

		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
	}

	private static void testSearch() {

		RoleBean bean = new RoleBean();

//		bean.setName("Admin");

		List<RoleBean> list = model.search(bean, 1, 5);

		Iterator<RoleBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		}

	}

}
