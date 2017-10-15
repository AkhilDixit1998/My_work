/*


package com.example.akhildixit.tab_layout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import UserDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



*/
/**
 * Created by Akhil Dixit on 6/15/2017.
 *//*




public class Users extends Fragment {
    ListView listView;

    DatabaseReference databaseReference;
    ArrayList<String> arrayList;
    private FirebaseAuth mAuth;

    ArrayList<String> arrayListChatwith;


    Integer images[]={R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //arrayList=new ArrayList<>();
        arrayListChatwith=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser=mAuth.getCurrentUser();
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {


                        Toast.makeText(getContext(), "  In listener " + snapshot.child("Name").getValue(), Toast.LENGTH_LONG).show();
                        arrayList.add(snapshot.child("Name").getValue(String.class));

                        // Toast.makeText(getContext(), "  In listener " + snapshot.getKey(), Toast.LENGTH_LONG).show();

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





*/
/*  listView.setAdapter(new CustomiseList_Users(this,images,data));*//*







      //listView.setAdapter(new CustomiseList_Users(getContext(),images,data));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms

                listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayList));

            }
        },1000);
       // listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayList));



    }






    }








*/




































package com.example.akhildixit.tab_layout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.akhil.UserDetails;
import com.akhil.RefreshUserList;
import com.akhil.RetrievingUserData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * Created by Akhil Dixit on 6/15/2017.
 */



/*
public class Users extends Fragment {
    ListView listView;

    DatabaseReference databaseReference;
    ArrayList<String> arrayListName;
    private FirebaseAuth mAuth;
    ArrayList<String> arrayListid;

    ArrayList<String> arrayListChatwith;


    Integer images[]={R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayListName=new ArrayList<>();
        arrayListid=new ArrayList<>();
    }


    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.chats, container, false);
        listView=(ListView)rootview.findViewById(R.id.listViewChats);

      //  arrayListName.add("Hello");
       // arrayListName.add("Hello");
       // arrayListName.add("Hello");
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                   */
/*REturn the name*//*
// Toast.makeText(getContext(), (String ) snapshot.child("Name").getValue(),Toast.LENGTH_LONG).show();


                  // To get the username  Toast.makeText(getContext(),UserDetails.username,Toast.LENGTH_LONG).show();
                    if (!(UserDetails.username.equals((String)snapshot.getKey())))
                    {
                        arrayListName.add((String) snapshot.child("Name").getValue());
                        arrayListid.add((String)snapshot.getKey());
                    }
                    // To get the key Toast.makeText(getContext(),(String)snapshot.getKey(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayListName));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserDetails.chatWith = arrayListid.get(position);
                startActivity(new Intent(getContext(),Chat.class));


            }
        });






        return rootview;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    }
*/















public class Users extends Fragment {
    ListView listView;

    DatabaseReference databaseReference;
    ArrayList<String> arrayListName;
    private FirebaseAuth mAuth;
    ArrayList<String> arrayListid;

    ArrayList<String> arrayListChatwith;
    CustomiseList_Users customiseList_users;
    RetrievingUserData retrievingUserData;


    ArrayList<String> arrayList1=new ArrayList();
    ArrayList<String> arrayList2=new ArrayList();

    Boolean bool=Boolean.TRUE;


    Integer images[]={R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,
            R.drawable.batman,R.drawable.hero,R.drawable.batman,R.drawable.hero,};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayListName=new ArrayList<>();
        arrayListid=new ArrayList<>();
        retrievingUserData=new RetrievingUserData();
        retrievingUserData.getData();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                arrayListName=retrievingUserData.getArrayistName();
                arrayListid=retrievingUserData.getArrayistId();

            }
        },1000);



    }


    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.chats, container, false);
        listView=(ListView)rootview.findViewById(R.id.listViewChats);


        FloatingActionButton floatingActionButton=(FloatingActionButton)rootview.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"In flab",Toast.LENGTH_LONG).show();

                // retrievingUserData=new RetrievingUserData();
                arrayListName.clear();
                arrayListid.clear();

                arrayList1.clear();
                arrayList2.clear();
               // retrievingUserData.getData();
               final RefreshUserList rf=new RefreshUserList(getContext());
                rf.getData();

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        arrayList1=rf.getArrayistName();
                        arrayList2=rf.getArrayistId();
                        arrayListName=rf.getArrayistName();
                        arrayListid=rf.getArrayistId();
                        CustomiseList_Users customiseList_users1=new CustomiseList_Users(getContext(),images,arrayList1);
                        //listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayListName));
                        listView.setAdapter(customiseList_users1);


                        Toast.makeText(getContext(),"In flab the name is "+arrayList1,Toast.LENGTH_LONG).show();

                        CustomiseList_Users cs=(CustomiseList_Users)listView.getAdapter();
                        cs.notifyDataSetChanged();




                    }
                },2000);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        UserDetails.chatWith = arrayList2.get(position);
                        startActivity(new Intent(getContext(),Chat.class));


                    }
                });




                CustomiseList_Users customiseList_users1=new CustomiseList_Users(getContext(),images,arrayList1);
                //listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayListName));
                listView.setAdapter(customiseList_users1);


                Toast.makeText(getContext(),"In flab the name is "+arrayList1,Toast.LENGTH_LONG).show();

                CustomiseList_Users cs=(CustomiseList_Users)listView.getAdapter();
                cs.notifyDataSetChanged();




            }
        });









        return rootview;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    customiseList_users = new CustomiseList_Users(getContext(), images, arrayListName);
                    //listView.setAdapter(new CustomiseList_Users(getContext(),images,arrayListName));
                    listView.setAdapter(customiseList_users);


                    CustomiseList_Users cs = (CustomiseList_Users) listView.getAdapter();
                    cs.notifyDataSetChanged();

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            UserDetails.chatWith = arrayListid.get(position);
                            startActivity(new Intent(getContext(), Chat.class));


                        }
                    });

                }
            }, 2000);





    }


    public void onResume()
    {

        databaseReference.child(UserDetails.username).child("Is_Logged_In").setValue("true");


        super.onResume();

    }
    public void onPause()
    {
        databaseReference.child(UserDetails.username).child("Is_Logged_In").setValue("false");
        CustomiseList_Users cs = (CustomiseList_Users) listView.getAdapter();
        cs.notifyDataSetChanged();



        super.onPause();
    }



}









