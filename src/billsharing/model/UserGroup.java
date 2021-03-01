package billsharing.model;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
	private String groupName;
	private List<String> userMails;
	List<Bill> groupBills;
	List<MoneyOwed> groupMoneyOwed;

	public List<Bill> getGroupBills() {
		return groupBills;
	}

	public void setGroupBills(List<Bill> groupBills) {
		this.groupBills = groupBills;
	}

	public List<MoneyOwed> getGroupMoneyOwed() {
		return groupMoneyOwed;
	}

	public void setGroupMoneyOwed(List<MoneyOwed> groupMoneyOwed) {
		this.groupMoneyOwed = groupMoneyOwed;
	}

	public UserGroup(String groupName2, ArrayList<String> arrayList) {
		this.groupName = groupName2;
		this.userMails = arrayList;
		this.groupBills = new ArrayList<>();
		this.groupMoneyOwed = new ArrayList<>();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<String> getUserMails() {
		return userMails;
	}

	public void setUserMails(List<String> userMails) {
		this.userMails = userMails;
	}

	// since one user can belong to multiple groups so we cannot make a List<User>
	// as that would force the user to belong to that group only
	// or cause data duplication of userdata within multiple groups
	// so we only store the emails of the members of the group within the group
	// object

}
