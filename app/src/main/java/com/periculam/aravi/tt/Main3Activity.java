package com.periculam.aravi.tt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    Firebase fb;

    String url ="https://dbdemo-b1622.firebaseio.com/";

    TextView a,s,d,f,ssa;
    Button set;
    ArrayList<String> list;
    String day[] = new String[6];
    int in = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Firebase.setAndroidContext(this);
         list = getIntent().getStringArrayListExtra("Aravi");

        day[0] = "monday";
        day[1] = "tuesday";
        day[2] = "wednesday";
        day[3] = "thursday";
        day[4] = "friday";



        fb = new Firebase(url);
        ssa = (TextView)findViewById(R.id.day) ;
        a = (TextView)findViewById(R.id.s12);
        s = (TextView)findViewById(R.id.s34);
        d = (TextView)findViewById(R.id.s56);
        f = (TextView)findViewById(R.id.s78);

        ssa.setText(day[0]);

        set = (Button)findViewById(R.id.upload);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = list.get(0);
                String yr = list.get(1);
                    String dya = day[in];

                    Firebase data = fb.child(dept).child(yr).child(dya);
                    data.child("s1").setValue(a.getText().toString().toLowerCase().trim());
                    data.child("s2").setValue(s.getText().toString().toLowerCase().trim());
                    data.child("s3").setValue(d.getText().toString().toLowerCase().trim());
                    data.child("s4").setValue(f.getText().toString().toLowerCase().trim());

                    a.setText("");
                    s.setText("");
                    d.setText("");
                    f.setText("");
                    ssa.setText(day[in]);

                    if (in>=6) {
                        startActivity(new Intent(getApplicationContext(),AssignmentActivity.class));
                    }
                    in++;
                    //startActivity(new Intent(getApplicationContext(),Main3Activity.class));

            }
        });
    }
}
