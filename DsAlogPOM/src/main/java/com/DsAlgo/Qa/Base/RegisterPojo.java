package com.DsAlgo.Qa.Base;

public class RegisterPojo {
	private String uname;
	private String pword;
	private String cpword;

	public void setUname(String uname) {
		this.uname = uname;
	}

	public RegisterPojo() {
		this.uname = uname;
		this.pword = pword;
		this.cpword = cpword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public void setCpword(String cpword) {
		this.cpword = cpword;
	}

	public String getUname() {
		return uname;
	}

	public String getPword() {
		return pword;
	}

	public String getCpword() {
		return cpword;
	}

	public RegisterPojo rpv() {
		return this;
	}

}
