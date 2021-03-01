package billsharing.model;

public class Contribution implements Comparable<Contribution> {
	String user;
	double amt;

	public Contribution(String key, Double double1) {
		this.user = key;
		this.amt = double1;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
