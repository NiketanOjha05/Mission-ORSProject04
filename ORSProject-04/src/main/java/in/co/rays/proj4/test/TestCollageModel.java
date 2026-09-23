package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.CollageBean;
import in.co.rays.proj4.model.CollageModel;

public class TestCollageModel {

	public static CollageModel model = new CollageModel();

	public static void main(String[] args) {

	}

	private static void testAdd() {

		CollageBean bean = new CollageBean();

		bean.setName("Indus University");
		bean.setAddress("Ahemedabad");
		bean.setState("Gujrat");
		bean.setCity("Ahemedabad");
		bean.setPhoneNo("9098126553");
		bean.setCreatedBy("Niketan");
		bean.setModifiedBy("Niketan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedBy(null);
	}

}
