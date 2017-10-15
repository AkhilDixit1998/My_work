package com.akhil;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * Created by Akhil Dixit on 7/4/2017.
 */

public class RefreshUserList {

DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    private ArrayList<String> arrayListName=new ArrayList<>();
    private ArrayList<String> arrayListid=new ArrayList<>();

    Context context;

    public RefreshUserList(Context context)
    {
        this.context=context;

    }

    public void getData()
    {
        arrayListName.add("Tejas");
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    // To get the username  Toast.makeText(getContext(),UserDetails.username,Toast.LENGTH_LONG).show();
                   if (!(UserDetails.username.equals((String) snapshot.getKey()))) {

                        Log.v("Awesome",(String)snapshot.getKey()+" the name is "+(String) snapshot.child("Name").getValue());
                        arrayListName.add((String) snapshot.child("Name").getValue());
                        arrayListid.add((String) snapshot.getKey());
                    }
                    // To get the key Toast.makeText(getContext(),(String)snapshot.getKey(),Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.v("Awesome","Some error occur "+databaseError);
            }
        });




    }






                   /*public  void getData()
                   {
                       arrayListName.clear();
                       arrayListid.clear();

                       databaseReference.child("users").addChildEventListener(new ChildEventListener() {
                           @Override
                           public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                               for (DataSnapshot snapshot : dataSnapshot.getChildren()) {




                                   // To get the username  Toast.makeText(getContext(),UserDetails.username,Toast.LENGTH_LONG).show();
                                   if (!(UserDetails.username.equals((String) snapshot.getKey()))) {
                                       arrayListName.add((String) snapshot.child("Name").getValue());
                                       arrayListid.add((String) snapshot.getKey());
                                   }

                           }}

                           @Override
                           public void onChildChanged(DataSnapshot dataSnapshot, String s) {


                           }

                           @Override
                           public void onChildRemoved(DataSnapshot dataSnapshot) {

                           }

                           @Override
                           public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                           }

                           @Override
                           public void onCancelled(DatabaseError databaseError) {



                           }
                       });



                   }*/
    public ArrayList getArrayistName()
    {
        return arrayListName;

    }
    public ArrayList getArrayistId()
    {
        return arrayListid;

    }
    public void clearData()
    {
        arrayListName.clear();
        arrayListid.clear();
    }

}
