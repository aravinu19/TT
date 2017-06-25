package com.periculam.aravi.tt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class AssignmentActivity extends AppCompatActivity {

    TextView as,sts;
    Button set;

    Firebase fb;
    String url ="https://dbdemo-b1622.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        Firebase.setAndroidContext(this);

        fb = new Firebase(url);

        set = (Button)findViewById(R.id.button3);
        as = (TextView)findViewById(R.id.asn);
        sts = (TextView)findViewById(R.id.dt);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ass = as.getText().toString().trim();
                String date = sts.getText().toString().trim();

                Firebase sett = fb.child("Ass1").child("f1");
                sett.setValue(ass);

                Firebase sett1 = fb.child("Ass1").child("f2");
                sett1.setValue(date);
            }
        });

    }
}
