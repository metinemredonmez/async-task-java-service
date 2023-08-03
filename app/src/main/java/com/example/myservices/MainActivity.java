package com.example.myservices;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //  service başlat
    public void startService(View view) {
        Intent intent = new Intent(getApplicationContext(),ServiceClass.class);
        startService(intent);


    }
    public void stopService(View view) {
        Intent intent = new Intent(getApplicationContext(),ServiceClass.class);
        stopService(intent);
    }

}