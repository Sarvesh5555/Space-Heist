package com.example.spaceheist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CreditsAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_acitivty);
    }

    public void backcreditis(View view) {
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);

    }
}