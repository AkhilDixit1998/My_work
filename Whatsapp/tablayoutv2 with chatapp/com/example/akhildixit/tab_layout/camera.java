package com.example.akhildixit.tab_layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * Created by Akhil Dixit on 6/22/2017.
 */

public class camera extends Fragment implements View.OnClickListener {

    ImageButton button;
    View rootview;
    ImageView im;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        rootview=inflater.inflate(R.layout.camerabtn,container,false);
         button = (ImageButton)rootview.findViewById(R.id.camerabtn);
        /*im=(ImageView)rootview.findViewById(R.id.im);*/
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
       */
        button.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Intent intent=new Intent(getContext(),camera_open.class);
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent,
//                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                startActivity(intent);
        }

        });

       return rootview;

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),camera_open.class);
        startActivity(intent);


    }


    /*I could have also used intent to go to next activity but in that case a bug existes o i use this method as to
    * get the picture not using this method now*/

   /* public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // convert byte array to Bitmap

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);

                im.setImageBitmap(bitmap);

            }
        }
    }*/
}
