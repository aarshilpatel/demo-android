package com.example.demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {
Button btnlogin,newuser;
EditText edtusername,edtpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    btnlogin = (Button) findViewById(R.id.button);
    newuser = (Button) findViewById(R.id.button2);
    edtusername = (EditText)findViewById(R.id.editText);
    edtpassword = (EditText)findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();


        btnlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = edtusername.getText().toString().trim();
            String password = edtpassword.getText().toString();


            if(email.equals("") && email.isEmpty())

            {
                //edtusername.requestFocus();
                edtusername.setError("FIELD CANNOT BE EMPTY");
            }
            else if (!isValidEmail(email)) {
                //edtusername.requestFocus();
                edtusername.setError("Invalid Email");
            } else if(password.equals("") && password.isEmpty())
            {
                //edtusername.requestFocus();
                edtpassword.setError("FIELD password BE EMPTY");
            } else if (!isValidPassword(password)) {
                //edtpassword.requestFocus();
                edtpassword.setError("Invalid Password");
            }else
            {
                Toast.makeText(login.this,"Validation Successful",Toast.LENGTH_LONG).show();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String struid = user.getUid();
                                    Intent i = new Intent(login.this,GridViewActivity.class);
                                    startActivity(i);
                                    finish();

                                    //  updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });
            }
            }



    });


    newuser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i1 = new Intent(login.this,Register.class);
            startActivity(i1);
        }
    });


    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

}
