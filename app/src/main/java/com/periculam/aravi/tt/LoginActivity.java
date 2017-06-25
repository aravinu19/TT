package com.periculam.aravi.tt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView u, p;

    Button s, r,stu;
    String una, pws;
    FirebaseAuth ma;
    FirebaseAuth.AuthStateListener mau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ma = FirebaseAuth.getInstance();

        u = (TextView) findViewById(R.id.un);
        p = (TextView) findViewById(R.id.pws);

        s = (Button) findViewById(R.id.sg);
        r = (Button) findViewById(R.id.reg);
        stu = (Button)findViewById(R.id.st);

        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),StudentLogin.class));
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                una = u.getText().toString().trim();
                pws = p.getText().toString().trim();

                if ((una.equals(null)) || (pws.equals(null))) {
                    Toast.makeText(getApplicationContext(), "Field is Empty , plz Fill It !", Toast.LENGTH_LONG).show();
                    return;
                }

                ma.signInWithEmailAndPassword(una,pws).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Sorry Something went Wrong ,We'll fix it soon and plz Try Again !",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

    }

    public void checkdata()
    {

    }


}
