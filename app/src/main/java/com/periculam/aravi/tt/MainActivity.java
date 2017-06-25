package com.periculam.aravi.tt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {
    TextView mon[]=new TextView[21];//,mon34,mon56,mon78,tue12,tue34,tue56,tue78,wed12,wed34,wed56,wed78,thurs12,thurs34,thurs56,thurs78,fri12,fri34,fri56,fri78;

    String dept,yr;

    Firebase fb;

    int gett = 0,lim = 3;

    ArrayList<String> list = new ArrayList<>();

    final String url ="https://dbdemo-b1622.firebaseio.com/";

    String day[] = new String[5];
    String s[] = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        list = getIntent().getStringArrayListExtra("ii");

        dept = list.get(0);
        yr = list.get(1);

        day[0] = "monday";
        day[1] = "tuesday";
        day[2] = "wednesday";
        day[3] = "thursday";
        day[4] = "friday";

        s[0] = "s1"; s[1] = "s2"; s[2] = "s3"; s[3] = "s4";


        mon[0] = (TextView)findViewById(R.id.un1);
        mon[1] = (TextView)findViewById(R.id.sa1);
        mon[2] = (TextView)findViewById(R.id.go1);
        mon[3] = (TextView)findViewById(R.id.ex1);

        mon[4] = (TextView)findViewById(R.id.un2);
        mon[5] = (TextView)findViewById(R.id.sa2);
        mon[6] = (TextView)findViewById(R.id.go2);
        mon[7] = (TextView)findViewById(R.id.ex2);

        mon[8] = (TextView)findViewById(R.id.un3);
        mon[9] = (TextView)findViewById(R.id.sa3);
        mon[10] = (TextView)findViewById(R.id.go3);
        mon[11] = (TextView)findViewById(R.id.ex3);

        mon[12] = (TextView)findViewById(R.id.un4);
        mon[13] = (TextView)findViewById(R.id.sa4);
        mon[14] = (TextView)findViewById(R.id.go4);
        mon[15] = (TextView)findViewById(R.id.ex4);

        mon[16] = (TextView)findViewById(R.id.un5);
        mon[17] = (TextView)findViewById(R.id.sa5);
        mon[18] = (TextView)findViewById(R.id.go5);
        mon[19] = (TextView)findViewById(R.id.ex5);

        getData(dept,yr);
    }

    public void getData(String dept, String yr)
    {
        fb = new Firebase(url);
        Firebase dataget1 = fb.child(dept).child(yr);
        for(String dataa : day) {
            for (String sd : s) {
                Firebase dataget = dataget1.child(dataa).child(sd);
                dataget.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
//                        for(;gett<=lim;gett++)
//                        {
                            mon[gett].setText(dataSnapshot.getValue(String.class));

//                        }
                        gett++;
                        lim+=3;
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }
        }

    }

}
