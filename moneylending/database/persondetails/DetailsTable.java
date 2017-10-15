package com.akhil.akhildixit.moneylending.database.persondetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.akhil.akhildixit.moneylending.database.Connection;
import com.akhil.akhildixit.moneylending.dto.PersonDetails;

import java.util.ArrayList;

/**
 * Created by Akhil Dixit on 9/20/2017.
 */

public class DetailsTable {

    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper openHelper;
    Context context;
    String[] coloumn=new String[]{"FNAME","MNAME","LNAME","ADDRESS","PHONE","EMAIL","PHOTO","TYPE"};


    public  DetailsTable(Context context)
    {
      this.context=context;
        openHelper=new Connection(context);
        sqLiteDatabase=openHelper.getWritableDatabase();
    }

    public void insertRecord(PersonDetails personDetails,byte[] arr)
    {

        ContentValues contentValues=new ContentValues();
        contentValues.put(coloumn[0],personDetails.firstName);
        contentValues.put(coloumn[1],personDetails.middleName);
        contentValues.put(coloumn[2],personDetails.lastName);
        contentValues.put(coloumn[3],personDetails.address);
        contentValues.put(coloumn[4],personDetails.phone);
        contentValues.put(coloumn[5],personDetails.email);
        contentValues.put(coloumn[6],arr);
        contentValues.put(coloumn[7],personDetails.type);
        sqLiteDatabase.insert("DETAILS",null,contentValues);
        Log.e("Suuc","Ss");
    }

    public ArrayList<PersonDetails> getDataForMainAct()
    {
        ArrayList<PersonDetails> arrayList=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.query("DETAILS",new String[]{"FNAME","LNAME","PHONE","TYPE","SERIAL"},null,null,null,null,null);
        if (cursor.getCount()>0)
        {
            Log.e("h","In cursor");
            while (cursor.moveToNext())
            {
                PersonDetails personDetails=new PersonDetails();
                personDetails.firstName=cursor.getString(0);
                personDetails.lastName=cursor.getString(1);
                personDetails.phone=cursor.getString(2);
                personDetails.type=cursor.getString(3);
                personDetails.serial=String.valueOf(cursor.getInt(4));
                Log.e("The de","detais "+personDetails.serial);
                arrayList.add(personDetails);
            }
            Log.e("The array size","A"+arrayList.size());
            return arrayList;
    }
    return null;
}

public PersonDetails getDataForEditInAddDetails(String serial)
{
    PersonDetails personDetails=new PersonDetails();

    Cursor cursor=sqLiteDatabase.query("DETAILS",new String[]{"FNAME","MNAME","LNAME","PHONE","TYPE","SERIAL","EMAIL","ADDRESS","PHOTO"},"SERIAL=?",new String[]{serial},null,null,null);
    if (cursor!=null && cursor.getCount()>0) {
        if (cursor.moveToFirst()) {
            personDetails.firstName = cursor.getString(0);
            personDetails.middleName = cursor.getString(1);
            personDetails.lastName = cursor.getString(2);
            personDetails.phone = cursor.getString(3);
            personDetails.type = cursor.getString(4);
            personDetails.serial = cursor.getString(5);
            personDetails.email = cursor.getString(6);
            personDetails.address = cursor.getString(7);
            personDetails.arr=cursor.getBlob(8);
            Log.e("It", "Woks" + personDetails.firstName);
        }
    }
return  personDetails;
}

public void UpdateRecord(PersonDetails personDetails)
{
    ContentValues contentValues=new ContentValues();
    contentValues.put(coloumn[0],personDetails.firstName);
    contentValues.put(coloumn[1],personDetails.middleName);
    contentValues.put(coloumn[2],personDetails.lastName);
    contentValues.put(coloumn[3],personDetails.address);
    contentValues.put(coloumn[4],personDetails.phone);
    contentValues.put(coloumn[5],personDetails.email);
    contentValues.put(coloumn[6],personDetails.arr);
    contentValues.put(coloumn[7],personDetails.type);

    sqLiteDatabase.update("DETAILS",contentValues,"SERIAL=?",new String[]{personDetails.serial});
}
}
