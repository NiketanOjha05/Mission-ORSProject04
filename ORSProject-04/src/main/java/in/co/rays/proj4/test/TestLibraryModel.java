package in.co.rays.proj4.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.LibraryBean;
import in.co.rays.proj4.model.LibraryModel;

public class TestLibraryModel {

	public static LibraryModel model = new LibraryModel();

	public static void main(String[] args) {

		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
//		testSearch();
	}

	private static void testAdd() {

		LibraryBean Bean = new LibraryBean();

		Bean.setTitle("Hello");
		Bean.setAuthor("Rahul Sharma");
		Bean.setPrize(1200);
		Bean.setAvailability(false);

		model.add(Bean);

	}

	private static void testUpdate() {

		LibraryBean Bean = new LibraryBean();

		Bean.setBookId(1);
		Bean.setTitle("Hello");
		Bean.setAuthor("Rahul Sharma");
		Bean.setPrize(1200);
		Bean.setAvailability(true);

		model.update(Bean);

	}

	private static void testDelete() {

		model.delete(1);

	}

	private static void testfindByPk() {

		LibraryBean Bean = model.findByPk(0);

		System.out.println(Bean.getBookid());
		System.out.println(Bean.getTitle());
		System.out.println(Bean.getAuthor());
		System.err.println(Bean.getPrize());
		System.out.println(Bean.getCreatedBy());
		System.out.println(Bean.getModifiedBy());
		System.out.println(Bean.getCreatedDatetime());
		System.out.println(Bean.getModifiedDatetime());

	}

	private static void testSearch() {

		LibraryBean Bean = new LibraryBean();

		List<LibraryBean> list = model.search(Bean, 1, 5);

		Iterator<LibraryBean> it = list.iterator();

		while (it.hasNext()) {
			Bean = it.next();

			System.out.println(Bean.getBookid());
			System.out.println(Bean.getTitle());
			System.out.println(Bean.getAuthor());
			System.out.println(Bean.getPrize());
			System.out.println(Bean.getAvailability());

		}

	}

}
