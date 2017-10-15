package com.akhil.akhildixit.moneylending.activities.otheractivities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.akhil.akhildixit.moneylending.R;
import com.akhil.akhildixit.moneylending.database.persondetails.DetailsTable;
import com.akhil.akhildixit.moneylending.dto.PersonDetails;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Akhil Dixit on 9/19/2017.
 */

public class AddDetails extends AppCompatActivity {

    EditText firstName,middleName,lastName,email,address,phone;
    TextView hiddenUri;
    TextView appbarCross;
Intent intent;
    String serial;
    Boolean hasSaved=false;
    Boolean isPicturePresent=false;
    FloatingActionButton save;
    Button takePic;
    byte[] image;
    ImageView userImage;
    Uri uri;
    PersonDetails userDetails;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetails);
        intent=getIntent();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 8);
        initialise();
        setListeners();
        fontAwesome();

        if (intent!=null && intent.getStringExtra("from").toString().equals("main"))
        {

            serial=intent.getStringExtra("serial");
            DetailsTable detailsTable=new DetailsTable(this);
            userDetails=detailsTable.getDataForEditInAddDetails(serial);

            TextView bran=(TextView)findViewById(R.id.anim_subjectName);
            TextView batc=(TextView)findViewById(R.id.anim_division);
            TextView cours=(TextView)findViewById(R.id.anim_departName);
            bran.setVisibility(View.VISIBLE);
            batc.setVisibility(View.VISIBLE);
            cours.setVisibility(View.VISIBLE);

            firstName.setText(userDetails.firstName);
            middleName.setText(userDetails.middleName);
            lastName.setText(userDetails.lastName);
            image=userDetails.arr;

            email.setText(userDetails.email);
            address.setText(userDetails.address);
            phone.setText(userDetails.phone);
            userImage.setImageBitmap(BitmapFactory.decodeByteArray(userDetails.arr,0,userDetails.arr.length));
            userImage.setVisibility(View.VISIBLE);


            switch (userDetails.type)
            {
                case "Lender": radioGroup.check(R.id.addDetails_lender);break;
                case "Borrower":radioGroup.check(R.id.addDetails_borrower);break;
                case "Payment":radioGroup.check(R.id.addDetails_payment);break;

            }

        }

        }

    public void applyPropertiesToEditextAndRadio()
    {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {


                RadioButton lender=(RadioButton)findViewById(R.id.addDetails_lender);
                RadioButton borrower=(RadioButton)findViewById(R.id.addDetails_borrower);
                RadioButton payment=(RadioButton)findViewById(R.id.addDetails_payment);

                if (!lender.isChecked())
                {
                    lender.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.addbatcheditext)));
                }
                if (!borrower.isChecked())
                {
                    borrower.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.addbatcheditext)));
                }
                if (!payment.isChecked())
                {
                    payment.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.addbatcheditext)));
                }

                RadioButton checked;
                Log.e("HHH","GGGG");
                switch (checkedId)
                {
                    case R.id.addDetails_lender:checked=(RadioButton)findViewById(R.id.addDetails_lender);
                        checked.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.sunflower)));
                        break;
                    case R.id.addDetails_borrower:
                        checked=(RadioButton)findViewById(R.id.addDetails_borrower);

                        checked.setButtonTintList(ContextCompat.getColorStateList(AddDetails.this, R.color.sunflower));
                        break;
                    case R.id.addDetails_payment:
                        checked=(RadioButton)findViewById(R.id.addDetails_payment);
                        checked.setButtonTintList(ContextCompat.getColorStateList(AddDetails.this, R.color.sunflower));
                        break;

                }
            }
        });
    }
    public void setListeners()
    {
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getData();

                if (intent.getStringExtra("from").equals("main"))
                {
                    Boolean bool=checkData();
                    if (bool) {
                        DetailsTable table = new DetailsTable(AddDetails.this);
                        userDetails.serial=serial;
                        userDetails.arr=image;
                        table.UpdateRecord(userDetails);

                        Intent intent=new Intent(AddDetails.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Snackbar.make(v,"Looks like you have not filled all the fields!!", BaseTransientBottomBar.LENGTH_LONG).show();

                    }
                }
                else {
                    Boolean bool = checkData();
                    if (bool) {
                        DetailsTable table = new DetailsTable(AddDetails.this);
                        table.insertRecord(userDetails, image);
                        Intent intent = new Intent(AddDetails.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Snackbar.make(v, "Looks like you have not filled all the fields!!", BaseTransientBottomBar.LENGTH_LONG).show();

                    }
                }
                }

        });

        appbarCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AddDetails.this);

                builder.setTitle("Are you sure you want to discard..");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(AddDetails.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.show();
            }

        });
    }

    public void getData()
    {

        PersonDetails personDetails=new PersonDetails();
        /*radio group*/
        int id=radioGroup.getCheckedRadioButtonId();

        switch (id)
        {
            case R.id.addDetails_lender:personDetails.type="Lender";
                break;


            case R.id.addDetails_borrower:personDetails.type="Borrower";
                break;


            case R.id.addDetails_payment:personDetails.type="Payment";
                break;

        }
        /**/

        /*Names*/
        personDetails.firstName=firstName.getText().toString();
        personDetails.middleName=middleName.getText().toString();
        personDetails.lastName=lastName.getText().toString();

        personDetails.email=email.getText().toString();
        personDetails.address=address.getText().toString();
        personDetails.phone=phone.getText().toString();

        personDetails.arr=image;
        userDetails=personDetails;


        /**/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null)
        {
            Uri uri=data.getData();
            userImage.setImageURI(uri);
            this.uri=uri;
            isPicturePresent=true;
            userImage.setVisibility(View.VISIBLE);
            storeImage(uri);
        }
    }


    /*Storing images*/
    public void storeImage(Uri uri)
    {
        Bitmap bitmap1=null;
        Bitmap bitmap=null;
        try {
            bitmap1= MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
            bitmap=Bitmap.createScaledBitmap(bitmap1,1000,1000,true);

            byte[] demoArray=getBitmapAsByteArray(bitmap);
            image=demoArray;


        } catch (IOException e) {

            Log.e("Problem in decoding","prob:: "+e);
        }
    }

    public byte[] getBitmapAsByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();
    }
    /**/

    public void initialise()
    {

        firstName=(EditText)findViewById(R.id.addDetails_firstname);
        middleName=(EditText)findViewById(R.id.addDetails_middlename);
        lastName=(EditText)findViewById(R.id.addDetails_lastname);
        email=(EditText)findViewById(R.id.addDetails_email);
        address=(EditText)findViewById(R.id.addDetails_address);
        phone=(EditText)findViewById(R.id.addDetails_phone);
        appbarCross=(TextView)findViewById(R.id.addbatch_appbar_cross);

        hiddenUri=(TextView)findViewById(R.id.addDetails_hiddenUri);

        radioGroup=(RadioGroup)findViewById(R.id.addDetails_radiogroup);
        save=(FloatingActionButton) findViewById(R.id.addDetails_saveFab);
        takePic=(Button) findViewById(R.id.addDetails_takePic);
        userImage=(ImageView) findViewById(R.id.addDetails_picImage);

        radioGroup.check(R.id.addDetails_lender);
        applyPropertiesToEditextAndRadio();
        animations();

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void animations()
    {


        final TextView subject=(TextView)findViewById(R.id.anim_subjectName);

        final TextView depart=(TextView)findViewById(R.id.anim_departName);
        final TextView division=(TextView)findViewById(R.id.anim_division);


        firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (firstName.hasFocus())
                {

                    firstName.getBackground().setColorFilter(getResources().getColor(R.color.sunflower), PorterDuff.Mode.SRC_ATOP);
                    if (firstName.getText().toString().equals(""))
                    {
                        YoYo.with(Techniques.SlideInUp).duration(700).repeat(0).playOn(subject);
                        subject.setVisibility(View.VISIBLE);

                        Handler handler=new Handler();;
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                firstName.setHint("");
                            }
                        },400);
                    }

                }
                else {
                    firstName.getBackground().setColorFilter(getResources().getColor(R.color.addbatcheditext),PorterDuff.Mode.SRC_ATOP);
                    if (firstName.getText().toString().equals(""))
                    {
                        YoYo.with(Techniques.SlideOutDown).duration(700).repeat(0).playOn(subject);

                        firstName.setHint("First Name");


                    }
                }
            }
        });

        middleName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (middleName.hasFocus())
                {

                    middleName.getBackground().setColorFilter(getResources().getColor(R.color.sunflower),PorterDuff.Mode.SRC_ATOP);
                    if (middleName.getText().toString().equals(""))
                    {YoYo.with(Techniques.SlideInUp).duration(700).repeat(0).playOn(depart);
                        depart.setVisibility(View.VISIBLE);
                        Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                middleName.setHint("");
                            }
                        },400);

                    }

                }
                else {
                    middleName.getBackground().setColorFilter(getResources().getColor(R.color.addbatcheditext),PorterDuff.Mode.SRC_ATOP);
                    if (middleName.getText().toString().equals(""))
                    {
                        YoYo.with(Techniques.SlideOutDown).duration(700).repeat(0).playOn(depart);
                        middleName.setHint("Middle Name");


                    }
                }
            }
        });

        lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (lastName.hasFocus())
                {

                    lastName.getBackground().setColorFilter(getResources().getColor(R.color.sunflower),PorterDuff.Mode.SRC_ATOP);
                    if (lastName.getText().toString().equals(""))
                    {YoYo.with(Techniques.SlideInUp).duration(700).repeat(0).playOn(division);
                        division.setVisibility(View.VISIBLE);
                        Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                lastName.setHint("");
                            }
                        },400);

                    }

                }
                else {
                    lastName.getBackground().setColorFilter(getResources().getColor(R.color.addbatcheditext),PorterDuff.Mode.SRC_ATOP);
                    if (lastName.getText().toString().equals(""))
                    {
                        lastName.setHint("Last Name");
                        YoYo.with(Techniques.SlideOutDown).duration(700).repeat(0).playOn(division);


                    }
                }
            }
        });

    }


    public void onBackPressed() {
        // super.onBackPressed();
        AlertDialog.Builder builder=new AlertDialog.Builder(AddDetails.this);
        builder.setMessage("Are you sure you want to discard..");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(AddDetails.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.show();

    }

    public void fontAwesome()
    {
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        TextView subjectDetails = (TextView) findViewById(R.id.font_subjectDetails);
        TextView selectType=(TextView)findViewById(R.id.font_selectType);
        TextView cancel=(TextView)findViewById(R.id.addbatch_appbar_cross);

        TextView email = (TextView) findViewById(R.id.email);
        TextView address=(TextView)findViewById(R.id.address);
        TextView phone=(TextView)findViewById(R.id.phone);
        TextView pic=(TextView)findViewById(R.id.picture);



        subjectDetails.setTypeface(fontAwesomeFont);
        selectType.setTypeface(fontAwesomeFont);
        cancel.setTypeface(fontAwesomeFont);

        email.setTypeface(fontAwesomeFont);
        address.setTypeface(fontAwesomeFont);
        phone.setTypeface(fontAwesomeFont);
        pic.setTypeface(fontAwesomeFont);


    }

    public Boolean checkData()
    {
        if (firstName.getText().toString().trim().equals(""))
        {
            return false;
        }

        if (middleName.getText().toString().trim().equals(""))
        {
            return false;
        }

        if (lastName.getText().toString().trim().equals(""))
        {
            return false;
        }

        if (email.getText().toString().trim().equals(""))
        {
            return false;
        }

        if (address.getText().toString().trim().equals(""))
        {
            return false;
        }

        if (phone.getText().toString().trim().equals(""))
        {
            return false;
        }
        if (!isPicturePresent && userImage.getVisibility()==View.GONE )
        {
            return false;
        }


        return true;
    }


}
