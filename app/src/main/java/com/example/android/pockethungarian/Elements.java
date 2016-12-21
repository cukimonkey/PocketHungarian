package com.example.android.pockethungarian;


public class Elements {
    private String mEnglishTranslation;
    private String mHungarianTranslation;
    private int mImageId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    public static final int NO_IMAGE_PROVIDED = -1;

    public Elements(String englishTranslation, String hungarianTranslation, int imageId, int audioResourceId ) {
        mEnglishTranslation = englishTranslation;
        mHungarianTranslation = hungarianTranslation;
        mImageId = imageId;
        mAudioResourceId = audioResourceId;
    }
    public Elements(String englishTranslation, String hungarianTranslation, int audioResourceId) {
        mEnglishTranslation = englishTranslation;
        mHungarianTranslation = hungarianTranslation;
        mAudioResourceId = audioResourceId;

    }
    //Get English translation
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }
    //Get Hungarian translation
    public String getmHungarianTranslation() {
        return mHungarianTranslation;
    }

    public int getmImageId() {
        return mImageId;
    }
    public boolean hasImage(){
        return mImageId != NO_IMAGE_PROVIDED;
    }
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

}
