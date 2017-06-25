package com.periculam.aravi.tt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    Firebase fb;

    String url ="https://dbdemo-b1622.firebaseio.com/";

    TextView s1,s2;

    Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        s1 = (TextView)findViewById(R.id.dept);
        s2 = ( TextView)findViewById(R.id.yr);
        up = (Button)findViewById(R.id.button2);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s1.getText().toString().toLowerCase().trim());
                list.add(s2.getText().toString().toLowerCase().trim());
                Intent i = new Intent(getApplicationContext(),Main3Activity.class);
                i.putExtra("Aravi",list);

                startActivity(i);
            }
        });

    }
}
