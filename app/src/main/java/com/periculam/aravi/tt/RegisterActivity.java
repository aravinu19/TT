package com.periculam.aravi.tt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    TextView unaa,pwss;
    Button regss;

    FirebaseAuth ma;

    FirebaseAuth.AuthStateListener mau;
    //CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ma = FirebaseAuth.getInstance();

        unaa = (TextView)findViewById(R.id.una);
        pwss = (TextView)findViewById(R.id.pws);
        regss = (Button)findViewById(R.id.regs);
        //cb = (CheckBox)findViewById(R.id.checkBox);

        regss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uns = unaa.getText().toString().trim();
                String pwd = pwss.getText().toString().trim();

                if((uns.equals(null)) || (pwd.equals(null))) {

                    Toast.makeText(getApplicationContext(),"All fields are necessary !",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    ma.createUserWithEmailAndPassword(uns,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Registration Failed !",Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else
                            {
                                FirebaseAuth.getInstance().signOut();
                                Toast.makeText(getApplicationContext(),"Registration Successful !",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            }
                        }
                    });
                }

            }
        });
    }
}
