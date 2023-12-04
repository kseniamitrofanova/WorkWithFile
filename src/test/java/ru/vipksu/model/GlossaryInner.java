package ru.vipksu.model;

import com.google.gson.annotations.SerializedName;

public class GlossaryInner {

    @SerializedName("DB")
    private String db;
    @SerializedName("DBAngle")
    private String dbangle;

    public String getDB() {
        return db;
    }

    public void setDB(String db) {
        this.db = db;
    }

    public String getDBAngle() {
        return dbangle;
    }

    public void setDBAngle(String dbangle) {
        this.dbangle = dbangle;
    }
}