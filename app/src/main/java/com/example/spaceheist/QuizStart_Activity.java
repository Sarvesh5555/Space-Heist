package com.example.spaceheist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuizStart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);
    }

    public void quizstart(View view) {
        Intent intent = new Intent(this,QuestionsActivity.class);
        startActivity(intent);
    }
}