package com.uurktk.catchthepokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class endPage extends AppCompatActivity {
    TextView scoreText;
    TextView preText;
    Button playagain;
    ImageView emoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page2);
        scoreText = findViewById(R.id.finalScore);
        preText = findViewById(R.id.preText);
        playagain = findViewById(R.id.playagain);
        emoji = findViewById(R.id.emojii);
        emoji.setVisibility(View.INVISIBLE);
        scoreText.setVisibility(View.INVISIBLE);
        playagain.setVisibility(View.INVISIBLE);
        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                preText.setVisibility(View.INVISIBLE);
                scoreText.setVisibility(View.VISIBLE);
                int score = getIntent().getIntExtra("score",0);
                scoreText.setText("SCORE : "+score);
                playagain.setVisibility(View.VISIBLE);
                emoji.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void backtoMainmenu(View view){
        Intent intent = new Intent(endPage.this,mainPage.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        Intent intent = new Intent(endPage.this,mainPage.class);
        startActivity(intent);
    }
}