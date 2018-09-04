package com.meta.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Model to store response
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "status", "payload" })
public class ResponseBuilder {

	@JsonProperty("status")
	private Integer status;
	@JsonProperty("payload")
	private List<Category> payload = null;

	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("payload")
	public List<Category> getPayload() {
		return payload;
	}

	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonProperty("payload")
	public void setPayload(List<Category> payload) {
		this.payload = payload;
	}
}
