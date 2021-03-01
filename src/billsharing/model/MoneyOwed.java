package billsharing.model;

public class MoneyOwed {
	private static final String currency="Rs";
	String userOwes;
	String userOwed;
	double amtOwed;

	public MoneyOwed(String userOwes, String userOwed, double amtOwed) {
		this.userOwes = userOwes;
		this.userOwed = userOwed;
		this.amtOwed = amtOwed;
	}

	public String getUserOwes() {
		return userOwes;
	}

	public void setUserOwes(String userOwes) {
		this.userOwes = userOwes;
	}

	public String getUserOwed() {
		return userOwed;
	}

	public void setUserOwed(String userOwed) {
		this.userOwed = userOwed;
	}

	public double getAmtOwed() {
		return amtOwed;
	}

	public void setAmtOwed(double amtOwed) {
		this.amtOwed = amtOwed;
	}

	@Override
	public String toString() {
		return "User " + userOwes + " owes " + currency+" "+amtOwed + " to user " + userOwed;
	}

}
