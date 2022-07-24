package com.memes.models.results;

import com.memes.models.MemeModel;

public class GetUrlMemeResult {
    private MemeModel memeModel;

    public GetUrlMemeResult(GetUrlMemeResult.Builder builder) {
        this.memeModel = builder.memeModel;
    }

    public MemeModel getMemeModel() {
        return memeModel;
    }

    public void setMemeModel(MemeModel memeModel) {
        this.memeModel = memeModel;
    }

    public static GetUrlMemeResult.Builder builder() {return new GetUrlMemeResult.Builder();}

    public static final class Builder {
        private MemeModel memeModel;

        public GetUrlMemeResult.Builder withMeme(MemeModel memeModel) {
            this.memeModel = memeModel;
            return this;
        }

        public GetUrlMemeResult build() {return new GetUrlMemeResult(this);}
    }
}
