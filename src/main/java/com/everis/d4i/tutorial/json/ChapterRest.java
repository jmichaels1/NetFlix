package com.everis.d4i.tutorial.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChapterRest implements Serializable {

	private static final long serialVersionUID = 8725949484031409482L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("number")
	private short number;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("duration")
	private short duration;


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

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ChapterRest)) {
			return false;
		}
		ChapterRest castOther = (ChapterRest) other;
		return new EqualsBuilder().append(id, castOther.id).append(number, castOther.number)
				.append(name, castOther.name).append(duration, castOther.duration).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(number).append(name).append(duration).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("number", number).append("name", name)
				.append("duration", duration).toString();
	}
}
