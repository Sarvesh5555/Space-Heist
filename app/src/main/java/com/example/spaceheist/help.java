package com.example.spaceheist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void back(View view) {
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }

    public void credits(View view) {
        Intent intent = new Intent(this,Credits.class);
        startActivity(intent);
    }
}