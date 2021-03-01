package extras;

import java.util.Map;

public interface BillService {
	 void createBill(double billAmount, String billDesc,Map<String, Double> splits, Map<String, Double> paid,String groupName);

}
