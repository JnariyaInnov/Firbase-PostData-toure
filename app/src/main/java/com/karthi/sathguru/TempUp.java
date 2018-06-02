package com.karthi.sathguru;

import com.google.firebase.database.Exclude;

/**
 * Created by karthikeyansekar on 02/06/18.
 */

public class TempUp {

    private String mName;
    private String mEmail;
    private String mImageUrl;
    private String mKey;
    private String mSomething;
    private String mDate;

    public TempUp() {
        //empty constructor needed
    }


    public TempUp(String name, String email, String something, String date, String imageUrl) {
        mName=name;
        mEmail = email;
        mDate = date;
        mSomething = something;
        mImageUrl = imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String email) {
        mEmail = email;
    }

    public String getmSomething() {
        return mSomething;
    }

    public void setmSomething(String mSomething) {
        this.mSomething = mSomething;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }


    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
