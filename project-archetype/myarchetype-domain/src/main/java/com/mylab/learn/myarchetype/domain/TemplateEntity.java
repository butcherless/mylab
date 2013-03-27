package com.mylab.learn.myarchetype.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Template entity for simple persistence operations
 * 
 * @author cmartin
 * 
 */
@Entity
@Table(name = "TABLE_TEMPLATE")
public class TemplateEntity {

	@Id
	@SequenceGenerator(name = "templateGen", sequenceName = "SEQ_TEMPLATE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "templateGen")
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 8, max = 64)
	private String name;

	@Version
	@Column(name = "version")
	private Integer version;

	/**
	 * default constructor
	 */
	public TemplateEntity() {
    }
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("version", getVersion())
		.append("name", this.name)
		.toString();
	}
}
