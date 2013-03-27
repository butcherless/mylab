package com.mylab.learn.myarchetype.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Embeddable
public class Translation {
	@NotNull
	@Size(min = 2, max = 16)
	private String language;

	@NotNull
	@Size(min = 1, max = 128)
	private String translatedText;

	public Translation() {
	}

	public Translation(String language, String translatedText) {
	    this.language = language;
	    this.translatedText = translatedText;
    }

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	public String getTranslatedText() {
		return translatedText;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("language", this.getLanguage())
		.append("translatedText", this.getTranslatedText())
		.toString();
	}

}
