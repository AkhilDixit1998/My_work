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

/**
 * Created by Akhil Dixit on 6/25/2017.
 */

public class CustomiseList extends BaseAdapter {

    Context context;
    Integer images[];
    String data[];
    LayoutInflater inflater;
    ImageView imageView;

    CustomiseList(Context context,Integer images[],String data[])
    {
        this.context=context;
        this.images=images;
        this.data=data;
        inflater= (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }







    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view=inflater.inflate(R.layout.customlistcontact,null);
        TextView textView=(TextView)view.findViewById(R.id.textViewContact);
        TextView textViewIcon=(TextView)view.findViewById(R.id.textViewIconContact);
        imageView=(ImageView)view.findViewById(R.id.imageViewContact);

        textView.setText(data[position]);
        imageView.setImageResource(images[position]);
        textViewIcon.setText("25");



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
