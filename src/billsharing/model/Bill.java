package billsharing.model;

import java.util.Map;

public class Bill {
	public Bill(double billAmount, String billDesc, Map<String, Double> split, Map<String, Double> paid) {
		this.amt = billAmount;
		this.desc = billDesc;
		this.split = split;
		this.payments = paid;
	}

	double amt;
	Map<String, Double> payments;
	Map<String, Double> split;
	String desc;

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public Map<String, Double> getPayments() {
		return payments;
	}

	public void setPayments(Map<String, Double> payments) {
		this.payments = payments;
	}

	public Map<String, Double> getSplit() {
		return split;
	}

	public void setSplit(Map<String, Double> split) {
		this.split = split;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	// to describe the reason for this bill
	// can keep fields like createdBy, createdDate for future
}
