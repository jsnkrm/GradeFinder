package com.example.jsnkrm.project1;

/**
 * Created by jsnkrm on 10/5/17.
 */

public class StuInfo {

    private String mName;
    private String mSyllabus;
    private int mClass;

    public String getmName() {
        return mName;
    }

    public String getmSyllabus() {
        return mSyllabus;
    }

    public int getmClass() {
        return mClass;
    }

    private int mMark1;
    private int mMark2;
    private int mMark3;
    private int mMark4;
    private int mMark5;
    private int mTotMrks;
    private String mTotGrade;

    public int getmMark1() {
        return mMark1;
    }

    public int getmMark2() {
        return mMark2;
    }

    public int getmMark3() {
        return mMark3;
    }

    public int getmMark4() {
        return mMark4;
    }

    public int getmMark5() {
        return mMark5;
    }

    public String getmGrade1() {
        return mGrade1;
    }

    public String getmGrade2() {
        return mGrade2;
    }

    public String getmGrade3() {
        return mGrade3;
    }

    public String getmGrade4() {
        return mGrade4;
    }

    public String getmGrade5() {
        return mGrade5;
    }

    private String mGrade1;
    private String mGrade2;
    private String mGrade3;
    private String mGrade4;
    private String mGrade5;

    public void setmGrade1(String mGrade1) {
        this.mGrade1 = mGrade1;
    }

    public void setmGrade2(String mGrade2) {
        this.mGrade2 = mGrade2;
    }

    public void setmGrade3(String mGrade3) {
        this.mGrade3 = mGrade3;
    }

    public void setmGrade4(String mGrade4) {
        this.mGrade4 = mGrade4;
    }

    public void setmGrade5(String mGrade5) {
        this.mGrade5 = mGrade5;
    }

    public StuInfo(String mName, String mSyllabus, int mClass, int mMark1, int mMark2, int mMark3, int mMark4, int mMark5) {
        this.mName = mName;
        this.mSyllabus = mSyllabus;
        this.mClass = mClass;
        this.mMark1 = mMark1;
        this.mMark2 = mMark2;
        this.mMark3 = mMark3;
        this.mMark4 = mMark4;
        this.mMark5 = mMark5;
    }

    public StuInfo(String mName, String mSyllabus, int mClass, String mTotGrade, String mGrade1, String mGrade2, String mGrade3, String mGrade4, String mGrade5) {
        this.mName = mName;
        this.mSyllabus = mSyllabus;
        this.mClass = mClass;
        this.mTotGrade = mTotGrade;
        this.mGrade1 = mGrade1;
        this.mGrade2 = mGrade2;
        this.mGrade3 = mGrade3;
        this.mGrade4 = mGrade4;
        this.mGrade5 = mGrade5;
    }

    public void ClearStu()
    {
        this.mName = null;
        this.mSyllabus = null;
        this.mClass = -1;
        this.mMark1 = -1;
        this.mMark2 = -1;
        this.mMark3 = -1;
        this.mMark4 = -1;
        this.mMark5 = -1;
    }


    public int getmTotMrks() {
        return mTotMrks;
    }

    public String getmTotGrade() {
        return mTotGrade;
    }

    public void setmTotMrks(int mTotMrks) {

        this.mTotMrks = mTotMrks;
    }

    public void setmTotGrade(String mTotGrade) {
        this.mTotGrade = mTotGrade;
    }
}
