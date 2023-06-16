package com.br.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "codein", "name", "high", "low", "varBid", "pctChange", "bid", "ask", "timestamp", "create_date" })
@Getter
@Setter
public class Usdbrl {

	@JsonProperty("code")
	private String code;
	@JsonProperty("codein")
	private String codein;
	@JsonProperty("name")
	private String name;
	@JsonProperty("high")
	private String high;
	@JsonProperty("low")
	private String low;
	@JsonProperty("varBid")
	private String varBid;
	@JsonProperty("pctChange")
	private String pctChange;
	@JsonProperty("bid")
	private String bid;
	@JsonProperty("ask")
	private String ask;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("create_date")
	private String createDate;

	// Getters e Setters

	// ...
}

