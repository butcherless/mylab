package com.mylab.learn.myarchetype.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class SimpleText {
	@Id
	@SequenceGenerator(name = "templateGen", sequenceName = "SEQ_TEMPLATE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "templateGen")
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotNull
	@Size(min = 1, max = 128)
	private String text;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@ElementCollection
	@CollectionTable(name="TRANSLATION", joinColumns=@JoinColumn(name="TEXT_ID"))
	private List<Translation> translations;

	public void setTranslations(List<Translation> translations) {
	    this.translations = translations;
    }
	public List<Translation> getTranslations() {
	    return translations;
    }

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", this.getId())
		.append("version", this.getVersion())
		.append("text", this.getText())
		.toString();
	}
}
