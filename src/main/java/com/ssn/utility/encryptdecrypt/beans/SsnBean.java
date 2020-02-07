package com.ssn.utility.encryptdecrypt.beans;

public class SsnBean {

	private int id;
	private String ssn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public SsnBean(int id, String ssn) {
		super();
		this.id = id;
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "SsnBean [id=" + id + ", ssn=" + ssn + "]";
	}
}
