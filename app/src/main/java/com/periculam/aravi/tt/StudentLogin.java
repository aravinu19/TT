package com.periculam.aravi.tt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentLogin extends AppCompatActivity {

    TextView regn;
    Button si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        regn = (TextView)findViewById(R.id.editText);
        si = (Button)findViewById(R.id.Sh);
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegInfo.class);
                i.putExtra("reg",si.getText().toString().trim());
                startActivity(i);
            }
        });
    }
}
