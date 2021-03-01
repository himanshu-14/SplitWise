package billsharing.model;

public class Contribution implements Comparable<Contribution> {
	String userId;
	double amt;

	public Contribution(String userId, Double amt) {
		this.userId = userId;
		this.amt = amt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUser(String user) {
		this.userId = user;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	@Override
	public int compareTo(Contribution o) {
		// TODO Auto-generated method stub
		return (int) (o.getAmt() - this.getAmt());
	}

}
