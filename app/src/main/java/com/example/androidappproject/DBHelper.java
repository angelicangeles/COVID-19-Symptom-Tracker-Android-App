package com.example.androidappproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "SymptomTracker.db";
//    public static final String TABLE_USERS = "users";
//    public static final String ID = "ID";

    public DBHelper(Context context) {

        super(context, "SymptomTracker.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL(
                "create Table users(" +
                        "UserID INTEGER primary key autoincrement not null, " +
                        "etRegName TEXT, " +
                        "etRegAddress TEXT, " +
                        "etRegContact TEXT, " +
                        "etUsername TEXT not null, " +
                        "etPassword TEXT not null);"
        );

        MyDB.execSQL(
                "create Table symptoms(" +
                        "SymptomID INTEGER primary key autoincrement not null, " +
                        "etUsername TEXT not null, " +
                        "etPassword TEXT not null, " +
                        "Fever INTEGER, " +
                        "Chills INTEGER, " +
                        "Bodyaches INTEGER, " +
                        "SoreThroat INTEGER, " +
                        "DSwallowing INTEGER, " +
                        "PCough INTEGER, " +
                        "DBreathing INTEGER, " +
                        "RunnyNose INTEGER, " +
                        "FluSyndrome INTEGER, " +
                        "LossOfTaste INTEGER, " +
                        "Fatigue INTEGER, " +
                        "Symptom INTEGER, " +
                        "Headache INTEGER, " +
                        "Dizziness INTEGER, " +
                        "DConcentrate INTEGER, " +
                        "MemoryLapses INTEGER, " +
                        "LowMood INTEGER, " +
                        "Anxiety INTEGER, " +
                        "DSleep INTEGER, " +
                        "Tinnitus INTEGER, " +
                        "Earache INTEGER, " +
                        "Numbness INTEGER, " +
                        "HeartPalpitate INTEGER, " +
                        "ChestPain INTEGER, " +
                        "AbdominalPain INTEGER, " +
                        "LossAppetite INTEGER, " +
                        "MealSkipped INTEGER, " +
                        "Diarrhea INTEGER, " +
                        "SkinRash INTEGER, " +
                        "OtherSymptoms TEXT," +
                        "FirstDayM INTEGER, " +
                        "FirstDayD INTEGER, " +
                        "FirstDayY INTEGER, " +
                        "LastDayM INTEGER, " +
                        "LastDayD INTEGER, " +
                        "LastDayY INTEGER);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("Drop Table if exists users");
        MyDB.execSQL("Drop Table if exists symptoms");

    }

    public Boolean insertData (String etRegName, String etRegAddress, String etRegContact, String etUsername, String etPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etRegName", etRegName);
        contentValues.put("etRegAddress", etRegAddress);
        contentValues.put("etRegContact", etRegContact);
        contentValues.put("etUsername", etUsername);
        contentValues.put("etPassword", etPassword);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean checketUsername(String etUsername){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select etUsername from users where etUsername = ?", new String [] {etUsername});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checketUsernameetPassword(String etUsername, String etPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select etUsername, etPassword from users where etUsername = ? and etPassword = ?", new String [] {etUsername, etPassword});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getAllData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String []temp = {username,password};
        Cursor result = MyDB.rawQuery(
                "Select * from users where etUsername= ? and etPassword = ?", temp);
        return result;
    }

    public boolean updateData(String oldUsername, String UserID, String etRegName, String etRegAddress, String etRegContact, String etUsername, String etPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String []temp = {UserID};
        contentValues.put("etRegName", etRegName);
        contentValues.put("etRegAddress", etRegAddress);
        contentValues.put("etRegContact", etRegContact);
        contentValues.put("etUsername", etUsername);
        contentValues.put("etPassword", etPassword);
        MyDB.update("users", contentValues, "UserID = ?", temp);
        update_record_symptom(oldUsername,etUsername,etPassword);
        return true;
    }

    public void update_record_symptom(String oldusername,String newusername, String newpassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String []temp = {oldusername};
        ContentValues contentValues = new ContentValues();
        contentValues.put("etUsername",newusername);
        contentValues.put("etPassword",newpassword);
        MyDB.update("symptoms",contentValues,"etUsername = ?", temp);
    }

    public Boolean insertSymptoms (String etUsername, String etPassword, int Fever,
                                   int Chills,
                                   int Bodyaches,
                                   int SoreThroat,
                                   int DSwallowing,
                                   int PCough,
                                   int DBreathing,
                                   int RunnyNose,
                                   int FluSyndrome,
                                   int LossOfTaste,
                                   int Fatigue,
                                   int Symptom,
                                   int Headache,
                                   int Dizziness,
                                   int DConcentrate,
                                   int MemoryLapses,
                                   int LowMood,
                                   int Anxiety,
                                   int DSleep,
                                   int Tinnitus,
                                   int Earache,
                                   int Numbness,
                                   int HeartPalpitate,
                                   int ChestPain,
                                   int AbdominalPain,
                                   int LossAppetite,
                                   int MealSkipped,
                                   int Diarrhea,
                                   int SkinRash,
                                   String OtherSymptoms,
                                   int FirstDayM,
                                   int FirstDayD,
                                   int FirstDayY,
                                   int LastDayM,
                                   int LastDayD,
                                   int LastDayY){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etUsername", etUsername);
        contentValues.put("etPassword", etPassword);
        contentValues.put("Fever", Fever);
        contentValues.put("Chills", Chills);
        contentValues.put("Bodyaches", Bodyaches);
        contentValues.put("SoreThroat", SoreThroat);
        contentValues.put("DSwallowing", DSwallowing);
        contentValues.put("PCough", PCough);
        contentValues.put("DBreathing", DBreathing);
        contentValues.put("RunnyNose", RunnyNose);
        contentValues.put("FluSyndrome", FluSyndrome);
        contentValues.put("LossOfTaste", LossOfTaste);
        contentValues.put("Fatigue", Fatigue);
        contentValues.put("Symptom", Symptom);
        contentValues.put("Headache", Headache);
        contentValues.put("Dizziness", Dizziness);
        contentValues.put("DConcentrate", DConcentrate);
        contentValues.put("MemoryLapses", MemoryLapses);
        contentValues.put("LowMood", LowMood);
        contentValues.put("Anxiety", Anxiety);
        contentValues.put("DSleep", DSleep);
        contentValues.put("Tinnitus", Tinnitus);
        contentValues.put("Earache", Earache);
        contentValues.put("Numbness", Numbness);
        contentValues.put("HeartPalpitate", HeartPalpitate);
        contentValues.put("ChestPain", ChestPain);
        contentValues.put("AbdominalPain", AbdominalPain);
        contentValues.put("LossAppetite", LossAppetite);
        contentValues.put("MealSkipped", MealSkipped);
        contentValues.put("Diarrhea", Diarrhea);
        contentValues.put("SkinRash", SkinRash);
        contentValues.put("OtherSymptoms", OtherSymptoms);
        contentValues.put("FirstDayM", FirstDayM);
        contentValues.put("FirstDayD", FirstDayD);
        contentValues.put("FirstDayY", FirstDayY);
        contentValues.put("LastDayM", LastDayM);
        contentValues.put("LastDayD", LastDayD);
        contentValues.put("LastDayY",LastDayY);
        long result = MyDB.insert("symptoms", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getSymptomID(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String []temp = {username,password};
        Cursor result = MyDB.rawQuery(
                "Select SymptomID from symptoms where etUsername= ? and etPassword = ? order by SymptomID DESC limit 1", temp);
        return result;
    }


    public Cursor getSpecificSymptoms(String SymptomID){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String []temp = {SymptomID};
        Cursor result = MyDB.rawQuery(
                "Select * from symptoms where SymptomID= ?", temp);
        return result;
    }

    public Cursor getAllSymptoms(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String []temp = {username,password};
        Cursor result = MyDB.rawQuery(
                "Select * from symptoms where etUsername= ? and etPassword = ?", temp);
        return result;
    }

    public Integer deleteSymptom(String SymptomID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("symptoms", "SymptomID = ?", new String[] { SymptomID });
    }


}
