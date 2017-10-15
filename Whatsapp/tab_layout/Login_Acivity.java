package com.example.akhildixit.tab_layout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.io.File;

/**
 * Created by Akhil Dixit on 6/20/2017.
 */

public class Login_Acivity extends AppCompatActivity {

    EditText email,password,name;
    private String TAG="Login_Activity";
    Intent intent;
    Button sign,register;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    String emailadd,passw;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String nameUser;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        sign=(Button)findViewById(R.id.sign);
        register=(Button)findViewById(R.id.register);
        name=(EditText)findViewById(R.id.nameLogin);

        intent=new Intent(Login_Acivity.this,MainActivity.class);
        autho();



        /*Database coming*/


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailadd=email.getText().toString();
                passw=password.getText().toString();
                nameUser=name.getText().toString();
                signin(emailadd,passw);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailadd=email.getText().toString();
                passw=password.getText().toString();
                register(emailadd,passw);

            }
        });



    }




    public void autho()
    {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };



    }
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void signin(String email,String password)

    {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        if(task.isSuccessful())
                        {Toast.makeText(Login_Acivity.this,"U have signed in",Toast.LENGTH_LONG).show();

                            FirebaseUser firebaseUser=mAuth.getCurrentUser();

                          //  Toast.makeText(Login_Acivity.this,firebaseUser.getUid(),Toast.LENGTH_LONG).show();
                            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
                            databaseReference.child("users").child(mAuth.getCurrentUser().getUid()).setValue("active");
                            database_entry();

                            startActivity(intent);
                        }
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(Login_Acivity.this, "Sorry sign in could not be completed"+task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }

    public void register(String email,String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if(task.isSuccessful())
                        {Toast.makeText(Login_Acivity.this,"U have signed in",Toast.LENGTH_LONG).show();
                        }

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Login_Acivity.this,"Register unsuccesful",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
    public void database_entry()
    {
         DatabaseReference database = FirebaseDatabase.getInstance().getReference();
       /* myRef = database.getReference("message");*/
        /*String key=myRef.push().getKey();*/
        FirebaseUser firebaseUser=mAuth.getCurrentUser();

       // database.child("New Child").setValue(25);/*For making new childs*/
        DatabaseReference db=FirebaseDatabase.getInstance().getReference();
        db.child("users").child(firebaseUser.getUid()).child("Name").setValue(nameUser);









        /*myRef.child("here").child(key).setValue("akhil");
        String key2=  myRef.push().getKey();
        myRef.child("nice").child(key2).setValue("awesome");*/

    }




}
