package com.example.jsnkrm.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by jsnkrm on 10/5/17.
 */

public class SQLiteHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "grades_db";

    // cbse table name
    private static final String TABLE_CBSE = "cbse";

    // cbse Table Columns names
    private static final String KEY_ID = "cbseid";
    private static final String KEY_Lower = "lower_marks";
    private static final String KEY_Upper = "upper_marks";
    private static final String KEY_Grade = "grade";


    // icsc table name
    private static final String TABLE_ICSC = "icsc";

    // icsc Table Columns names
    private static final String KEY_ICSC_ID = "icscid";
    private static final String KEY_ICSC_Lower = "lower_marks";
    private static final String KEY_ICSC_Upper = "upper_marks";
    private static final String KEY_ICSC_Grade = "grade";

    // sslc table namecursor.getString(cursor.getColumnIndex("name"));
    private static final String TABLE_SSLC = "sslc";

    // sslc Table Columns names
    private static final String KEY_SSLC_ID = "sslcid";
    private static final String KEY_SSLC_Lower = "lower_marks";
    private static final String KEY_SSLC_Upper = "upper_marks";
    private static final String KEY_SSLC_Grade = "grade";

    // student table name
    private static final String TABLE_STU = "stu";

    // sslc Table Columns names
    private static final String KEY_STU_Name = "name";
    private static final String KEY_STU_Syll = "syll";
    private static final String KEY_STU_Class = "class";
    private static final String KEY_STU_Grd1 = "grd1";
    private static final String KEY_STU_Grd2 = "grd2";
    private static final String KEY_STU_Grd3 = "grd3";
    private static final String KEY_STU_Grd4 = "grd4";
    private static final String KEY_STU_Grd5 = "grd5";
    private static final String KEY_STU_TotGrd = "TotGrd";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CBSE_TABLE = "CREATE TABLE " + TABLE_CBSE + "("
                + KEY_ID + " INTEGER,"
                + KEY_Lower + " TEXT,"
                + KEY_Upper + " TEXT,"
                + KEY_Grade + " TEXT PRIMARY KEY"
                + ")";
        db.execSQL(CREATE_CBSE_TABLE);


        String CREATE_ICSC_TABLE = "CREATE TABLE " + TABLE_ICSC + "("
                + KEY_ICSC_ID + " INTEGER,"
                + KEY_ICSC_Lower + " TEXT,"
                + KEY_ICSC_Upper + " TEXT,"
                + KEY_ICSC_Grade + " TEXT PRIMARY KEY"
                + ")";
        db.execSQL(CREATE_ICSC_TABLE);

        String CREATE_SSLC_TABLE = "CREATE TABLE " + TABLE_SSLC + "("
                + KEY_SSLC_ID + " INTEGER,"
                + KEY_SSLC_Lower + " TEXT,"
                + KEY_SSLC_Upper + " TEXT,"
                + KEY_SSLC_Grade + " TEXT PRIMARY KEY"
                + ")";
        db.execSQL(CREATE_SSLC_TABLE);

        String CREATE_STU_TABLE = "CREATE TABLE " + TABLE_STU + "("
                + KEY_STU_Name + " TEXT PRIMARY KEY,"
                + KEY_STU_Syll + " TEXT,"
                + KEY_STU_Class + " TEXT,"
                + KEY_STU_Grd1 + " TEXT,"
                + KEY_STU_Grd2 + " TEXT,"
                + KEY_STU_Grd3 + " TEXT,"
                + KEY_STU_Grd4 + " TEXT,"
                + KEY_STU_Grd5 + " TEXT,"
                + KEY_STU_TotGrd + " TEXT"
                + ")";
        db.execSQL(CREATE_STU_TABLE);

        Log.d(TAG, "Database tables created");

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CBSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ICSC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SSLC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STU);
        // Create tables again
        onCreate(db);
    }

    /**
     * Storing cbse details in database
     * */
    public void addCbseGrade(String id, int lower, int upper, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_Lower, lower); // lower Mrks
        values.put(KEY_Upper, upper); // upper Mrks
        values.put(KEY_Grade, grade); // grade

        // Inserting Row
        long uid = db.insert(TABLE_CBSE, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New cbse grade field inserted into sqlite: " + uid);
    }

    /**
     * Storing icsc details in database
     * */
    public void addIcscGrade(String id, int lower, int upper, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ICSC_Grade, id);
        values.put(KEY_ICSC_Lower, lower); // lower Mrks
        values.put(KEY_ICSC_Upper, upper); // upper Mrks
        values.put(KEY_ICSC_Grade, grade); // grade

        // Inserting Row
        long uid = db.insert(TABLE_ICSC, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New icsc grade field inserted into sqlite: " + uid);
    }


    /**
     * Storing sslc details in database
     * */
    public void addSslcGrade(String id, int lower, int upper, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SSLC_Grade, id);
        values.put(KEY_SSLC_Lower, lower); // lower Mrks
        values.put(KEY_SSLC_Upper, upper); // upper Mrks
        values.put(KEY_SSLC_Grade, grade); // grade

        // Inserting Row
        long uid = db.insert(TABLE_SSLC, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New sslc grade field inserted into sqlite: " + uid);
    }


    /**
     * Storing student details in database
     * */
    public void addStudent(String name, String syll, int cl, String gr1,String gr2,String gr3,String gr4,
                           String gr5,String grTot) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STU_Name, name);
        values.put(KEY_STU_Class, cl); // lower Mrks
        values.put(KEY_STU_Syll, syll); // upper Mrks
        values.put(KEY_STU_Grd1, gr1); // grade 1
        values.put(KEY_STU_Grd2, gr2); // grade 2
        values.put(KEY_STU_Grd3, gr3); // grade 3
        values.put(KEY_STU_Grd4, gr4); // grade 4
        values.put(KEY_STU_Grd5, gr5); // grade 5
        values.put(KEY_STU_TotGrd, grTot); // grade Total

        // Inserting Row
        long uid = db.insert(TABLE_STU, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New student grade field inserted into sqlite: " + uid);
    }


    /**
     * Getting cbse data from database
     * */

    public Cursor getAllCBSE() {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_CBSE;
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }

    /**
     * Getting specific cbse data from database
     * */

    public Cursor getCBSErow(String gr) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_CBSE +" WHERE " + KEY_Grade + "='" + gr.trim()+"'";
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }



    /**
     * Getting icsc data from database
     * */

    public Cursor getAllICSE() {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_ICSC;
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }

    /**
     * Getting specific icsc data from database
     * */

    public Cursor getICSCrow(String gr) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_ICSC +" WHERE " + KEY_ICSC_Grade + "='" + gr.trim()+"'";
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }


    /**
     * Getting sslc data from database
     * */

    public Cursor getAllSSLC() {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_SSLC;
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }

    /**
     * Getting specific sslc data from database
     * */

    public Cursor getSSLCrow(String gr) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_SSLC +" WHERE " + KEY_SSLC_Grade + "='" + gr.trim()+"'";
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }

    /**
     * Getting student data from database
     * */

    public Cursor getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_STU;
        Cursor prdct = db.rawQuery(selectQuery, null);
        return prdct;
    }

    public void deleteCBSErow(String gr)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        db.execSQL("DELETE FROM "+TABLE_CBSE+" WHERE grade = '" + gr+"'");
        db.close();
        Log.d(TAG, "Row deleted from cbse Table:");
    }


    public void deleteSSLCrow(String gr)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        db.execSQL("DELETE FROM "+TABLE_SSLC+" WHERE grade = '" + gr+"'");
        db.close();
        Log.d(TAG, "Row deleted from sslc Table:");
    }

    public void deleteICSCrow(String gr)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        db.execSQL("DELETE FROM "+TABLE_ICSC+" WHERE grade = '" + gr+"'");
        db.close();
        Log.d(TAG, "Row deleted from icsc Table:");
    }

}
