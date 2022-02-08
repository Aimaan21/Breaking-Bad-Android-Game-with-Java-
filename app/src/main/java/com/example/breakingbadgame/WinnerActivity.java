package com.example.breakingbadgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        ImageView imageView=(ImageView) findViewById(R.id.imageViewWinnerActivity);


        Intent intent=getIntent();
        String message=intent.getStringExtra("message");
        //Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

        if(message.equals("Jesse"))
        {

           imageView.setImageResource(R.drawable.jesse);


        }
        else
        {

            imageView.setImageResource(R.drawable.walter);


        }


    }

    public void playAgain(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}