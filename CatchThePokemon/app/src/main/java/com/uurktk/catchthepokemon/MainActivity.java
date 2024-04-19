package com.uurktk.catchthepokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView score;
    TextView time;
    int point;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] images;
    Handler handler;
    Runnable runnable;
    CountDownTimer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = findViewById(R.id.score);
        time = findViewById(R.id.time);
        point = 0;
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        images = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        int choice = getIntent().getIntExtra("choice",1);
        for(ImageView view : images){
            if(choice == 1){
                view.setImageResource(R.drawable.pikachu);
            }
            else if(choice == 2){
                view.setImageResource(R.drawable.squirtle);
            }
            else if(choice == 3){
                view.setImageResource(R.drawable.charmander);
            }
        }
        hideImages();
       counter = new CountDownTimer(30090,1000){

            @Override
            public void onTick(long l) {
                    time.setText("Time: "+ (l/1000));
            }

            @Override
            public void onFinish() {
                time.setText("Done!");
                handler.removeCallbacks(runnable);
                Intent intent = new Intent(MainActivity.this, endPage.class);
                intent.putExtra("score",point);
                startActivity(intent);
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        handler.removeCallbacks(runnable);
        counter.cancel();
        Intent intent = new Intent(MainActivity.this,mainPage.class);
        startActivity(intent);
    }

    public void increaseScore(View view){
        point++;
        score.setText(""+point);
    }
    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : images){
                    image.setVisibility(View.INVISIBLE);

                }
                Random random = new Random();
                int num = random.nextInt(9);
                images[num].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable , 500);
            }
        };
        handler.post(runnable);


    }
}