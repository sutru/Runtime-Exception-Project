package com.memes.models.results;

import com.memes.models.MemeModel;

public class GetRandomMemeResult {
    private MemeModel memeModel;

    public GetRandomMemeResult(GetRandomMemeResult.Builder builder) {
        this.memeModel = builder.memeModel;
    }

    public MemeModel getMemeModel() {
        return memeModel;
    }

    public void setMemeModel(MemeModel memeModel) {
        this.memeModel = memeModel;
    }

    public static GetRandomMemeResult.Builder builder() {return new GetRandomMemeResult.Builder();}

    public static final class Builder {
        private MemeModel memeModel;

        public GetRandomMemeResult.Builder withMeme(MemeModel memeModel) {
            this.memeModel = memeModel;
            return this;
        }

        public GetRandomMemeResult build() {return new GetRandomMemeResult(this);}
    }
}
