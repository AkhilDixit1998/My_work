package com.example.akhildixit.tab_layout;

/**
 * Created by Akhil Dixit on 6/25/2017.
 */
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

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by Akhil Dixit on 6/25/2017.
 */

public class CustomiseList_Users extends BaseAdapter {

    Context context;
    Integer images[];
    ArrayList<String> data;
    LayoutInflater inflater;
    ImageView imageView;
    private FirebaseAuth mAuth;

    String key;


   public CustomiseList_Users()
    {

    }
    CustomiseList_Users(Context context, Integer images[], ArrayList<String> data) {
        this.context = context;
        this.images = images;
        this.data = data;
        inflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.customlistuser, null);
        TextView textView = (TextView) view.findViewById(R.id.textViewChats);
        TextView time = (TextView) view.findViewById(R.id.textViewtimeChats);
        imageView = (ImageView) view.findViewById(R.id.imageViewChats);

        key = data.get(position);

        textView.setText(key);
        imageView.setImageResource(images[position]);
        time.setText("25");


        circularImageView(position);

        return view;


    }

    public void circularImageView(int id) {
        Resources res = context.getResources();
        Bitmap src = BitmapFactory.decodeResource(res, images[id]);
        RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, src);
        /*dr.setCornerRadius(Math.max(src.getWidth(), src.getHeight()) / 2.0f);*/

        dr.setCornerRadius(Math.min(dr.getMinimumWidth(), dr.getMinimumHeight()) / 2.0f);

        imageView.setImageDrawable(dr);

    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
      //  getView();


    }
    public void clearData(){

        data.clear();


    }

}
