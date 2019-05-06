package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable{
	
	private static final long serialVersionUID = 523546336500749420L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("id")
	private List<ChapterRest> chapterList;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ChapterRest> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<ChapterRest> chapterList) {
		this.chapterList = chapterList;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ActorRest)) {
			return false;
		}
		ActorRest castOther = (ActorRest) other;
		return new EqualsBuilder().append(id, castOther.id).append(name, castOther.name)
				.append(lastName, castOther.lastName).append(chapterList, castOther.chapterList).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(lastName).append(chapterList).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).append("lastName", lastName)
				.append("chapterList", chapterList).toString();
	}
}
