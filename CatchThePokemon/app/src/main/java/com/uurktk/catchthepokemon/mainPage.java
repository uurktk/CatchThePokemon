package com.uurktk.catchthepokemon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainPage extends AppCompatActivity {
    public void startGame(View view){
        Intent intent = new Intent(mainPage.this, DialogPage.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
}