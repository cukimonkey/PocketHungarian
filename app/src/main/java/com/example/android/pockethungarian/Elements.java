package com.example.android.pockethungarian;

/**
 * Created by Orsi on 01/12/2016.
 */
public class Elements {
    private String mEnglishTranslation;
    private String mHungarianTranslation;
    private int mImageId = NO_IMAGE_PROVIDED;

    public static final int NO_IMAGE_PROVIDED = -1;


    public Elements(String englishTranslation, String hungarianTranslation, int imageId ) {
        mEnglishTranslation = englishTranslation;
        mHungarianTranslation = hungarianTranslation;
        mImageId = imageId;
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

}
