package service;

import java.util.Map;

public interface BillService {
	public void createBill(double billAmount, String billDesc, Map<String, Double> splits, Map<String, Double> paid,
			String groupName);

}
