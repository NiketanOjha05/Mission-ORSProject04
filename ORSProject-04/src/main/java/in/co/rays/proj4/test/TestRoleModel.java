package in.co.rays.proj4.test;

import java.util.Date;
import java.sql.Timestamp;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) {

		testAdd();
//		testUpdate;
//		testDelete;
	}

	private static void testAdd() {
		
		RoleBean Bean = new RoleBean();

		Bean.setName("admin");
		Bean.setDescription("admin role");
		Bean.setCreatedBy("Niketan");
		Bean.setModifiedBy("Niketan");
		Bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		Bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(Bean);

	}

	private static void testUpdate() {

		RoleBean bean = new RoleBean();

		bean.setId(1);
		bean.setName("admin");
		bean.setDescription("admin role");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() {

		model.delete(1);

	}

}
