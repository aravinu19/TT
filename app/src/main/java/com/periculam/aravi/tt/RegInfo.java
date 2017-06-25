package com.periculam.aravi.tt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class RegInfo extends AppCompatActivity {

    String yr,dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_info);

        Bundle b = getIntent().getExtras();

        String tg = b.getString("reg");

        char tt[]= tg.toCharArray();

        switch (tt[1])
        {
            case 4:yr = "fourth";break;
            case 5:yr = "third";break;
            case 6:yr = "second";break;
            case 7:yr = "first";break;
        }

        switch (tt[3])
        {
            case 'd':dept="CSE";break;
            case 'b':dept = "MECH";break;
            case 'a':dept ="CIVIL";break;
            case 'e':dept="EEE";break;
            case 'c':dept="ECE";break;
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(dept);
        list.add(yr);

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.putStringArrayListExtra("ii",list);
        startActivity(i);

    }
}
