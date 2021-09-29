package com.example.spaceheist;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    Button shop;
    ImageButton more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.space);
        mediaPlayer.start();
        setContentView(R.layout.activity_start);

        //full screen

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        more = findViewById(R.id.more);
        shop =  findViewById(R.id.shop);


        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, ShopActivity.class));
                finish();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu = new PopupMenu(StartActivity.this, more);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        Intent intent, chooser;
                        int id = menuItem.getItemId();
                            if (id == R.id.feedback){
                                intent = new Intent(Intent.ACTION_SEND);
                                intent.setData(Uri.parse("mailto:"));
                                String[] to = {"sarveshjaiofficial@gmail.com"}; // my email
                                intent.putExtra(Intent.EXTRA_EMAIL, to);
                                intent.setType("message/rfc822");
                                chooser = Intent.createChooser(intent, "Send Feedback");
                                startActivity(chooser);
                            }

                            if (id == R.id.share){
                                intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Space Heist");
                                String sAux = "\n Follow Us On \n\n";
                                sAux = sAux+ "https://www.youtube.com/c/TamilCyberSec\n\n";
                                intent.putExtra(Intent.EXTRA_TEXT, sAux);
                                startActivity(Intent.createChooser(intent, "Share"));
                            }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
    public void help(View view) {
        Intent intent = new Intent(this,help.class);
        startActivity(intent);
    }
    public void startgame(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){
                case  KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return  super.dispatchKeyEvent(event);
    }
    public void exit(View view) {
        StartActivity.this.finish();
        System.exit(0);

    }

    public void startquiz(View view) {
        Intent in = new Intent(this,QuestionsActivity.class);
        startActivity(in);
    }
}
