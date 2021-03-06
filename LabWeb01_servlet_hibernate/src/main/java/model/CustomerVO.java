package model;

import java.util.Arrays;

public class CustomerVO {
	private String custid;
	private byte[] password;
	private String email;
	private java.util.Date birth;
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] bs) {
		this.password = bs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "CustomerVO [custid=" + custid + ", password=" + Arrays.toString(password) + ", email=" + email
				+ ", birth=" + birth + "]";
	}
	
	
}
