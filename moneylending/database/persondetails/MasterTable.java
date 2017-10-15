package com.akhil.akhildixit.moneylending.database.persondetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akhil.akhildixit.moneylending.database.Connection;

/**
 * Created by Akhil Dixit on 9/20/2017.
 */

public class MasterTable {

    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper openHelper;
    Context context;

    MasterTable(Context context)
    {
       this.context=context;
        openHelper=new Connection(context);
        sqLiteDatabase=openHelper.getWritableDatabase();
    }

    public void insertName(String tableName)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("TABLENAME",tableName);
        sqLiteDatabase.insert("MASTER_TABLE",null,contentValues);
    }
    public void deleteName(String tableName)
    {
        sqLiteDatabase.delete("MASTER_TABLE","TABLENAME=?",new String[]{tableName});
    }
    public Boolean checkTable(String tableName)
    {
        Cursor cursor=sqLiteDatabase.query("MASTER_TABLE",new String[]{"TABLENAME"},"TABLENAME=?",new String[]{tableName},null,null,null);
        if (cursor!=null && cursor.getCount()>0)
        {
            return true;
        }
        else return false;
    }
}
