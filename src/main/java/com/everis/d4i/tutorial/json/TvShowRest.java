package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowRest implements Serializable {

	private static final long serialVersionUID = 4916713904971425156L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("shortDescription")
	private String shortDescription;
	
	@JsonProperty("longDescription")
	private String longDescription;
	
	@JsonProperty("year")
	private Year year;
	
	@JsonProperty("recommendedAge")
	private byte recommendedAge;
	
	@JsonProperty("categoryListRest")
	private List<CategoryRest> categoryListRest;
	
	@JsonProperty("advertising")
	private String advertising;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public byte getRecommendedAge() {
		return recommendedAge;
	}

	public void setRecommendedAge(byte recommendedAge) {
		this.recommendedAge = recommendedAge;
	}

	public List<CategoryRest> getCategoryListRest() {
		return categoryListRest;
	}

	public void setCategoryListRest(List<CategoryRest> categoryListRest) {
		this.categoryListRest = categoryListRest;
	}

	public String getAdvertising() {
		return advertising;
	}

	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof TvShowRest)) {
			return false;
		}
		TvShowRest castOther = (TvShowRest) other;
		return new EqualsBuilder().append(id, castOther.id).append(name, castOther.name)
				.append(shortDescription, castOther.shortDescription).append(longDescription, castOther.longDescription)
				.append(year, castOther.year).append(recommendedAge, castOther.recommendedAge)
				.append(categoryListRest, castOther.categoryListRest).append(advertising, castOther.advertising)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(shortDescription).append(longDescription)
				.append(year).append(recommendedAge).append(categoryListRest).append(advertising).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("shortDescription", shortDescription).append("longDescription", longDescription)
				.append("year", year).append("recommendedAge", recommendedAge)
				.append("categoryListRest", categoryListRest).append("advertising", advertising).toString();
	}
}
