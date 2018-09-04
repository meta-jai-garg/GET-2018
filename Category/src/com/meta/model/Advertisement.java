package com.meta.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/**
 * model to hold fields related to advertisement table
 * @author User22
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "advId", "advTitle", "advDesc" })
public class Advertisement {
	private Integer advId;
	private String advTitle;
	private String advDesc;
	private Integer categoryId;

	public Integer getAdvId() {
		return advId;
	}

	public String getAdvTitle() {
		return advTitle;
	}

	public String getAdvDesc() {
		return advDesc;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setAdvId(Integer advId) {
		this.advId = advId;
	}

	public void setAdvTitle(String advTitle) {
		this.advTitle = advTitle;
	}

	public void setAdvDesc(String advDesc) {
		this.advDesc = advDesc;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Advertisement [advId=" + advId + ", advTitle=" + advTitle
				+ ", advDesc=" + advDesc + ", categoryId=" + categoryId + "]";
	}

}