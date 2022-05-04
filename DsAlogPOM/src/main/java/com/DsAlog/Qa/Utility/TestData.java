package com.DsAlog.Qa.Utility;

import com.poiji.annotation.ExcelCellName;

public class TestData {
	@ExcelCellName("Username")
	private String sname;

	@ExcelCellName("Password")
	private String spword;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpword() {
		return spword;
	}

	public void setSpword(String spword) {
		this.spword = spword;
	}

	public TestData td() {
		return this;

	}
}
