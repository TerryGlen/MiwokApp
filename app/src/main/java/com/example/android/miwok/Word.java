package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;

    private boolean mHasImage;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
        mHasImage = true;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }
    public int getAudioResourceId(){return mAudioResourceId;}
    public boolean getHasImage(){return mHasImage;}
}
