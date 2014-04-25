package com.mylab.learn.myarchetype.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "SIMPLE_TEXT")
public class SimpleText extends AbstractEntity {

    @NotNull
    @Size(min = 1, max = 128)
    private String text;

    @ElementCollection
    @CollectionTable(name = "TRANSLATION", joinColumns = @JoinColumn(name = "TEXT_ID"))
    private List<Translation> translations;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("text", this.getText())
                .toString();
    }
}
