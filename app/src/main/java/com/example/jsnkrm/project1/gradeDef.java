package com.example.jsnkrm.project1;

/**
 * Created by jsnkrm on 8/5/17.
 */

public class gradeDef {

    private int mLower;

    private int mUpper;

    private String mGrade;

    public gradeDef(int mLower, int mUpper, String mGrade) {
        this.mLower = mLower;
        this.mUpper = mUpper;
        this.mGrade = mGrade;
    }

    public int getmLower() {
        return mLower;
    }

    public int getmUpper() {
        return mUpper;
    }

    public String getmGrade() {
        return mGrade;
    }
}
