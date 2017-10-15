package com.example.akhildixit.tab_layout;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Akhil Dixit on 6/15/2017.
 */

public class Users extends Fragment {
    ListView listView;

    DatabaseReference databaseReference;
    ArrayList<String> arrayList;
    private FirebaseAuth mAuth;


    Integer images[]={R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser=mAuth.getCurrentUser();
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    if(dataSnapshot.hasChild(firebaseUser.getUid())) {

                        Toast.makeText(getContext(), "  In listener " + snapshot.child("Name").getValue(), Toast.LENGTH_LONG).show();
                        arrayList.add(snapshot.child("Name").getValue(String.class));

                        // Toast.makeText(getContext(), "  In listener " + snapshot.getKey(), Toast.LENGTH_LONG).show();
                    }
                    //if (snapshot.getKey().equals(mAuth.getCurrentUser().getUid()))
                    //  arrayList.add(snapshot.getKey().toString());


                }
               // arrayList.add("akhil");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       // arrayList.add("akhil");
    }

    View rootview;
    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.chats, container, false);
       listView=(ListView)rootview.findViewById(R.id.listViewChats);
        return rootview;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);









//       listView.setAdapter(new ArrayAdapter<>(getActivity().getApplicationContext(),
//                android.R.layout.simple_list_item_1 , values));

//        arrayAdapter = new ArrayAdapter(getActivity(),R.layout.customlistuser, R.id.listview_textvie,values);
//        listView.setAdapter(arrayAdapter);



      /*  listView.setAdapter(new CustomiseList_Users(this,images,data));*/




      //listView.setAdapter(new CustomiseList_Users(getContext(),images,data));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms

                listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayList));

            }
        },10000);
       // listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayList));



    }






    }