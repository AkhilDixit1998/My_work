package com.example.akhildixit.tab_layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Akhil Dixit on 6/26/2017.
 */

public class CustomiseList_Calls extends BaseAdapter {

    String namearray[];
    String time[];
    Integer images[];
    LayoutInflater inflater;
    Context context;
    ImageView imageView;
    ImageView icon;



    CustomiseList_Calls(Context context, Integer images[], String data[],String time[])
    {
        this.context=context;
        this.images=images;
        namearray=data;
        this.time=time;
        inflater= (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return namearray.length;
    }

    @Override
    public Object getItem(int position) {
        return namearray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        view=inflater.inflate(R.layout.customlistcalls,null);

        TextView name=(TextView)view.findViewById(R.id.calls_name_textview);
        TextView data=(TextView)view.findViewById(R.id.calls_time_textview);
        imageView=(ImageView)view.findViewById(R.id.calls_imageview);
        icon=(ImageView)view.findViewById(R.id.calls_call_or_videocall);


        name.setText(namearray[position]);
        imageView.setImageResource(images[position]);
        icon.setImageResource(R.drawable.phonecall);
        data.setText(time[position]);
        circularImageView(position);

        return view;
    }
    public void circularImageView(int id)
    {
        Resources res = context.getResources();
        Bitmap src = BitmapFactory.decodeResource(res, images[id]);
        RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, src);
        /*dr.setCornerRadius(Math.max(src.getWidth(), src.getHeight()) / 2.0f);*/

        dr.setCornerRadius(Math.min(dr.getMinimumWidth(), dr.getMinimumHeight()) / 2.0f);

        imageView.setImageDrawable(dr);

    }
}
