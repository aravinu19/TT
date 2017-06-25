package com.periculam.aravi.tt;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.StringTokenizer;

public class AssignmentNotify extends AppCompatActivity {

    Firebase mb;

    String url ="https://dbdemo-b1622.firebaseio.com/";
    String an,da;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_notify);
        Firebase.setAndroidContext(this);

        mb = new Firebase(url+"/Ass1/f1");

        mb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                an = dataSnapshot.getValue(String.class);
            }

            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase n = new Firebase(url+"/Ass1/f2");
        n.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                da = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        StringTokenizer stt = new StringTokenizer(da,"/");
        int d1 = Integer.parseInt(stt.nextToken());
        int mm = Integer.parseInt(stt.nextToken());

        NotificationManager not= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder(getApplicationContext()).setContentTitle(an).setContentText("Assignment Date "+da).setSmallIcon(R.drawable.abc).build();
        notify.flags|=Notification.FLAG_AUTO_CANCEL;
        not.notify(0,notify);
    }
}
