package com.akhil.akhildixit.moneylending.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created by Akhil Dixit on 9/20/2017.
 */

public class Connection extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="moneylending.db";
    public static final int DATABASE_VERSION=1;
    String masterTable="CREATE TABLE IF NOT EXISTS MASTER_TABLE(TABLENAME TEXT)";
    String peopleDetailstable="CREATE TABLE IF NOT EXISTS DETAILS(SERIAL INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,MNAME TEXT,LNAME TEXT,ADDRESS TEXT,PHONE TEXT,EMAIL TEXT,PHOTO BLOB,TYPE TEXT)";


    public Connection(Context context) {
        super(context, Environment.getExternalStorageDirectory()+ File.separator+"MoneyLending"+File.separator+ DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Connection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(masterTable);
        db.execSQL(peopleDetailstable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
