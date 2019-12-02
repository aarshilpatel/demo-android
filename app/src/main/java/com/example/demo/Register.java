package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
Button btnregiter;
    private FirebaseAuth mAuth;
    EditText edtEmail,edtpassword;
    private String TAG="Register activity";
    private EditText edtfn,edtln,edtMobile;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_register);
    btnregiter =(Button)findViewById(R.id.button3);
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User");

        edtEmail = (EditText) findViewById(R.id.editText6);
        edtpassword= (EditText) findViewById(R.id.editText9);

        edtfn = (EditText) findViewById(R.id.editText4);
        edtln = (EditText) findViewById(R.id.editText5);
        edtMobile = (EditText) findViewById(R.id.editText7);


        btnregiter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String email = edtEmail.getText().toString();
            final String password = edtpassword.getText().toString();

            final String strfn = edtfn.getText().toString();
            final String strln = edtln.getText().toString();
            final String strMobile = edtMobile.getText().toString();

Log.e("Register",""+email);
Log.e("Register",""+password);
           // registerdata(email,password);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                String struserkey = user.getUid();

                                Usermodel usermodel = new Usermodel();
                                usermodel.setUseId( struserkey);
                                usermodel.setFirstName(strfn);
                                usermodel.setLastName(strln);
                                usermodel.setUserName(email);
                                usermodel.setPassword(password);
                                usermodel.setMobileno(strMobile);
                                myRef.child(struserkey).setValue(usermodel);


                                // updateUI(user);

                                Intent i = new Intent(Register.this,GridViewActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Register.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }

                        }
                    });



        }
    });
    }

/*
    private void registerdata(String email, String password) {

    }
*/
}
