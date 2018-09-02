package com.meta.model;

public class Advertisement {
	private int advId;
	private String advTitle;
	private String advDesc;
	private int categoryId;

	public int getAdvId() {
		return advId;
	}

	public void setAdvId(int advId) {
		this.advId = advId;
	}

	public String getAdvTitle() {
		return advTitle;
	}

	public void setAdvTitle(String advTitle) {
		this.advTitle = advTitle;
	}

	public String getAdvDesc() {
		return advDesc;
	}

	public void setAdvDesc(String advDesc) {
		this.advDesc = advDesc;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Advertisment [advId=" + advId + ", advTitle=" + advTitle + ", advDesc=" + advDesc + ", categoryId="
				+ categoryId + "]";
	}

}
