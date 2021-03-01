package billsharing;

import java.util.HashMap;
import java.util.Map;

import service.BillServiceImpl;
import service.GroupServiceImpl;
import service.UserServiceImpl;

public class Driver {

	private static final String GROUP1 = "group1";
	private static final String USER1 = "himanshu1495@gmail.com";
	private static final String USER2 = "sparshbansal17895@gmail.com";
	private static final String USER3 = "anirudhaggarwal2@gmail.com";

	public static void main(String[] args) {
		UserServiceImpl.createUser("himanshu", USER1);
		UserServiceImpl.createUser("sparsh", USER2);
		UserServiceImpl.createUser("anirudh", USER3);
		GroupServiceImpl.createGroup(GROUP1, "himanshu", "sparsh", "anirudh");
		Map<String, Double> split = new HashMap<>();
		Map<String, Double> payments = new HashMap<>();
		split.put(USER1, 100d);
		split.put(USER2, 100d);
		split.put(USER3, 100d);
		payments.put(USER1, 250d);
		payments.put(USER2, 50d);
		payments.put(USER3, 0d);
		BillServiceImpl.createBill(300, "pawri", split, payments, GROUP1);
		System.out.println(BillServiceImpl.findMoneyOwed(GROUP1));
	}

}
