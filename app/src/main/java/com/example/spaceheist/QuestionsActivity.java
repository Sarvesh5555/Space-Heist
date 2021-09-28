package com.example.spaceheist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which of the following is the largest planet of the Solar System according to size?",
            "Which of the following planets in the Solar System takes the shortest revolution?",
            "Which planet in the Solar System has the highest density?",
            "Which is the hottest planet of our solar system.",
            "Which is the smallest planet of our solar system?",
            "Which of these is the coldest planet of our solar system?",
            "Which of these planets have rings around them?",
            "Which is called the “Red Planet” of our solar system?",
            "Which is the third planet from the sun?",
            "The planet with the highest number of moons is?",
    };
    String answers[] = {"Jupiter","Mercury","Earth","Venus","Mercury","Uranus","All of the mentioned","Mars","Earth","Jupiter"};
    String opt[] = {
            "Jupiter","Saturn","Neptune","Uranus",
            "Neptune","Mars","Mercury","Venus",
            "Uranus","Neptune","Earth","Jupiter",
            "Mercury","Venus","Jupiter","Earth",
            "Mercury","Uranus","Saturn","Mars",
            "Uranus","Neptune","Saturn","Jupiter",
            "Saturn","Jupiter","Uranus","All of the mentioned",
            "Mercury","Venus","Earth","Mars",
            "Mars","Earth","Jupiter","Saturn",
            "Saturn","Jupiter","Neptune","Uranus"
    };
    int flag=0;
    int gamescore = getIntent().getIntExtra("SCORE", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final TextView score = (TextView)findViewById(R.id.textView4);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    QuestionsActivity.score++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+ QuestionsActivity.score);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StartActivity.class);
                startActivity(intent);
            }
        });
    }

}