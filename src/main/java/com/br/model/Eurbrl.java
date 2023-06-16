package com.br.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Generated("jsonschema2pojo")
@Getter
@Setter
public class Eurbrl {

	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("codein")
	@Expose
	private String codein;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("high")
	@Expose
	private String high;
	@SerializedName("low")
	@Expose
	private String low;
	@SerializedName("varBid")
	@Expose
	private String varBid;
	@SerializedName("pctChange")
	@Expose
	private String pctChange;
	@SerializedName("bid")
	@Expose
	private String bid;
	@SerializedName("ask")
	@Expose
	private String ask;
	@SerializedName("timestamp")
	@Expose
	private String timestamp;
	@SerializedName("create_date")
	@Expose
	private String createDate;
}