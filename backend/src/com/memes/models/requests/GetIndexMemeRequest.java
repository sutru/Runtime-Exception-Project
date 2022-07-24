package com.memes.models.requests;

import java.util.Objects;

public class GetIndexMemeRequest {
    private Integer numInDb;

    public GetIndexMemeRequest() {

    }

    public GetIndexMemeRequest(Builder builder) {
        this.numInDb = builder.numInDb;
    }

    public Integer getNumInDb() {
        return numInDb;
    }

    public void setNumInDb(Integer numInDb) {
        this.numInDb = numInDb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetIndexMemeRequest that = (GetIndexMemeRequest) o;
        return Objects.equals(numInDb, that.numInDb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numInDb);
    }

    @Override
    public String toString() {
        return "GetPlaylistRequest{" +
                "index='" + numInDb + '\'' +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private Integer numInDb;

        private Builder() {

        }

        public Builder withNumInDb(Integer numInDb) {
            this.numInDb = numInDb;
            return this;
        }

        public GetIndexMemeRequest build() { return new GetIndexMemeRequest(this); }
    }
}
