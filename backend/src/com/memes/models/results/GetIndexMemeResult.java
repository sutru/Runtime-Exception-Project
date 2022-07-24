package com.memes.models.results;

import com.memes.models.MemeModel;

public class GetIndexMemeResult {
    private MemeModel memeModel;

    public GetIndexMemeResult(Builder builder) {
        this.memeModel = builder.memeModel;
    }

    public MemeModel getMemeModel() {
        return memeModel;
    }

    public void setMemeModel(MemeModel memeModel) {
        this.memeModel = memeModel;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private MemeModel memeModel;

        public Builder withMeme(MemeModel memeModel) {
            this.memeModel = memeModel;
            return this;
        }

        public GetIndexMemeResult build() {return new GetIndexMemeResult(this);}
    }
}
