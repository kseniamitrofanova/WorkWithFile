package ru.vipksu.model;

import com.google.gson.annotations.SerializedName;

public class Glossary {

    private String comment;
    @SerializedName("ID")
    private Integer id;

    private GlossaryInner glossary;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public GlossaryInner getGlossary() {
        return glossary;
    }

    public void setGlossary(GlossaryInner glossary) {
        this.glossary = glossary;
    }
}