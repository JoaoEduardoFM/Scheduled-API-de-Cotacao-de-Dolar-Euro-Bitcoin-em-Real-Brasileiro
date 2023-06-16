package com.br.model;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EURBRL" })
public class EURBRLS {


@JsonProperty("EURBRL")
private Eurbrl eurbr;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("EURBRL")
public Eurbrl getEurBrl() {
	return eurbr;
}

@JsonProperty("EURBRL")
public void setEurBrl(Eurbrl eurbr) {
	this.eurbr = eurbr;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
}

}
