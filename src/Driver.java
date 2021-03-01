import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import billsharing.model.Bill;
import billsharing.model.User;
import billsharing.model.UserGroup;
import billsharing.model.Contribution;
import billsharing.model.MoneyOwed;
import billsharing.repository.GroupRepository;
import billsharing.repository.UserRepository;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static void createUser(String username,String emailId){
		UserRepository.userMap.put(username, new User(username,emailId));
	}
	static void createGroup(String groupName,String[] userList){
		GroupRepository.groupMap.put(groupName, new UserGroup(groupName,new ArrayList<String>(Arrays.asList(userList))));
	}
	static void createBill(double billAmount, String billDesc,Map<String, Double> splits, Map<String, Double> paid,String groupName){
		GroupRepository.groupMap.get(groupName).getGroupBills().add(new Bill(billAmount,billDesc,splits,paid));
		List<Contribution> c=new ArrayList<Contribution>();
		for(String key:paid.keySet()) {
			c.add(new Contribution(key,paid.get(key)));
		}
		Map<String,Double> payCopy=new HashMap<>();
		for(String key:paid.keySet()) {
			payCopy.put(key,paid.get(key));
		}
		
		Collections.sort(c);
		List<MoneyOwed> moneyOwed=new ArrayList<>();
		for(int i=0;i<c.size();i++) {
			Contribution contri=c.get(i);
			if(contri.getAmt()>splits.get(contri.getUser())){
				for(int j=c.size()-1;j>i;j--) {
					Contribution contri2=c.get(j);
					if(contri2.getAmt()<splits.get(contri2.getUser())) {//make this user owe to first one
						moneyOwed.add(new MoneyOwed(contri.getUser(),contri2.getUser(),Math.min(a, b)))
					}
				}
				//user has paid more than his required make other users pay him
			}
		}
	}

}
