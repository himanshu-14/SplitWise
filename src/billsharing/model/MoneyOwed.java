package billsharing.model;

public class MoneyOwed {
	String userOwes;
	String userOwed;
	double amtOwed;

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

}
