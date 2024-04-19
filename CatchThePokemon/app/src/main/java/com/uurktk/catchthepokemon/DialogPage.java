package com.uurktk.catchthepokemon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DialogPage extends AppCompatActivity {

    public int choice = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_page);
    }

    public void pikachuSelected(View view){
        choice = 1;
    }
    public void squirtleSelected(View view){
        choice = 2;
    }
    public void charmanderSelected(View view){
        choice = 3;
    }

    public void startGame(View view){
        Intent intent = new Intent(DialogPage.this, MainActivity.class);
        intent.putExtra("choice", choice);
        startActivity(intent);
    }

}