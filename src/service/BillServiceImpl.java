package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import billsharing.model.Bill;
import billsharing.model.Contribution;
import billsharing.model.MoneyOwed;
import billsharing.model.UserGroup;
import billsharing.repository.GroupRepository;

public class BillServiceImpl {
	public static void createBill(double billAmount, String billDesc, Map<String, Double> split,
			Map<String, Double> payments, String groupName) {
		UserGroup userGroup = GroupRepository.groupMap.get(groupName);
		userGroup.getGroupBills().add(new Bill(billAmount, billDesc, split, payments));
		List<Contribution> paid = new ArrayList<Contribution>();
		for (String email : payments.keySet()) {
			paid.add(new Contribution(email, payments.get(email)));
		}
		Map<String, Double> payCopy = new HashMap<>();
		for (String email : payments.keySet()) {
			payCopy.put(email, payments.get(email));
		}
		Collections.sort(paid);
		List<MoneyOwed> billMoneyOwed = new ArrayList<>();
		int i = 0;
		int j = paid.size() - 1;
		// calculating the money owed for setting this bill as per the split
		while (i < j) {
			Contribution contri = paid.get(i);
			String user1 = contri.getUserId();
			double userPaid = contri.getAmt();
			double share = split.get(user1);
			if (userPaid > share) {// this user paid more than his share people owe him
				Contribution contri2 = paid.get(j);
				double userPaid2 = contri2.getAmt();
				String user2 = contri2.getUserId();
				double share2 = split.get(user2);
				if (userPaid2 < share2) {// make this user owe to first one
					double diff1 = userPaid - share;
					double diff2 = share2 - userPaid2;
					double owedMoney = Math.min(diff1, diff2);
					billMoneyOwed.add(new MoneyOwed(user2, user1, owedMoney));
					contri.setAmt(userPaid - owedMoney);
					contri2.setAmt(userPaid2 + owedMoney);
					if (contri.getAmt() == share)
						i++;
					if (contri2.getAmt() == share2)
						j--;
				}

			}
		}
		userGroup.getGroupMoneyOwed().addAll(billMoneyOwed);
	}

	public static List<MoneyOwed> findMoneyOwed(String groupName) {
		return GroupRepository.groupMap.get(groupName).getGroupMoneyOwed();

	}
}
