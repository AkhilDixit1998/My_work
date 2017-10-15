package com.example.akhildixit.tab_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    TextView profile,account,chats,notifications,data_usage,contacts,help;

    ListView listView;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
/*

        profile=(TextView)findViewById(R.id.profile);
        account=(TextView)findViewById(R.id.account);
        Users=(TextView)findViewById(R.id.chatssettings);
        notifications=(TextView)findViewById(R.id.notification);
        data_usage=(TextView)findViewById(R.id.datause);
        Calls=(TextView)findViewById(R.id.contactssetting);
        help=(TextView)findViewById(R.id.help);
*/

      //  setData();

        listView=(ListView)findViewById(R.id.listviewSettings);
        listView.setAdapter(new ArrayAdapter<>(this,
              android.R.layout.simple_list_item_1 , itemname));




    }

   /* public void setData()
    {
        profile.setCompoundDrawablesWithIntrinsicBounds(R.drawable.camera, 0, 0, 0);
    }*/
}
