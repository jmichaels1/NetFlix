package com.everis.d4i.tutorial.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeasonRest implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("number")
	private short number;
	
	@JsonProperty("name")
	private String name;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof SeasonRest)) {
			return false;
		}
		SeasonRest castOther = (SeasonRest) other;
		return new EqualsBuilder().append(id, castOther.id).append(number, castOther.number)
				.append(name, castOther.name).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(number).append(name).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("number", number).append("name", name).toString();
	}

}
