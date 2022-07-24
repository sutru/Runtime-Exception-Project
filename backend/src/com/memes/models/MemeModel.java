package com.memes.models;


import java.util.Objects;

public class MemeModel {
    private String url;
    private String name;
    private Integer numInDb;

    public MemeModel(){

    }
    public MemeModel(Builder builder) {
        this.url = builder.url;
        this.name = builder.name;
        this.numInDb = builder.numInDb;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNumInDb() {
        return numInDb;
    }

    public void setNumInDb(Integer numInDb) {
        this.numInDb = numInDb;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemeModel memeModel = (MemeModel) o;
        return Objects.equals(url, memeModel.url) && Objects.equals(name, memeModel.name) && Objects.equals(numInDb, memeModel.numInDb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, name, numInDb);
    }

    @Override
    public String toString() {
        return "MemeModel{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", numInDb=" + numInDb +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String url;
        private String name;
        private Integer numInDb;

        public Builder withUrl(String urlToUse) {
            this.url = urlToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withNumInDb(Integer numInDbToUse) {
            this.numInDb = numInDbToUse;
            return this;
        }


        public MemeModel build() {return new MemeModel(this);}
    }
}

