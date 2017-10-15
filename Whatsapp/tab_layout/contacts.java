package com.example.akhildixit.tab_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Akhil Dixit on 6/15/2017.
 */

public class contacts extends Fragment {

    ArrayAdapter arrayAdapter;

    ListView listView;

    /*String values[] = {"Cupcake","Donut", "Eclair", "Froyo", "GingerBread", "HoneyComb",
            "IceCream Sandwich", "JellyBean","Kitkat", "Lollipop",
            "Marshmallow","Nougat","Cupcake","Donut", "Eclair", "Froyo", "GingerBread", "HoneyComb",
            "IceCream Sandwich", "JellyBean","Kitkat", "Lollipop"};*/


    Integer images[]={R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,
            R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,
            R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,
            R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile};


    String data[]={"hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its "
            ,"hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its "
            ,"hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its "
            ,"hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its ",

            "hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its "
            ,"hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ",

            "hello nice to meet you its ","hello nice to meet you its ",
            "hello nice to meet you its ","hello nice to meet you its ","hello nice to meet you its "
            ,"hello nice to meet you its "};


    View rootview;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.contacts, container, false);
        listView=(ListView)rootview.findViewById(R.id.listViewContacts);
        return rootview;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//       listView.setAdapter(new ArrayAdapter<>(getActivity().getApplicationContext(),
//                android.R.layout.simple_list_item_1 , values));

//        arrayAdapter = new ArrayAdapter(getActivity(),R.layout.customlistchats, R.id.listview_textvie,values);
//        listView.setAdapter(arrayAdapter);



      /*  listView.setAdapter(new CustomiseList(this,images,data));*/

        listView.setAdapter(new CustomiseList(getContext(),images,data));  /*Here we use custom of chats only*/

    }






}