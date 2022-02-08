package com.example.breakingbadgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int activePlayer=0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    int winningPosition[][]={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    //GridLayout gridLayout;
    boolean gameActive=true;

    public  void fade(View view)
    {

        ImageView counter=(ImageView) view;

        int tappedCounter= Integer.parseInt(counter.getTag().toString());


        if(gameState[tappedCounter-1]==2 && gameActive) {

            counter.setTranslationY(-1000);
            gameState[tappedCounter-1] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.walter_logo);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.jesse_logo);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000).rotation(3600).setDuration(1000);
        }


        for (int[] winningPosition:winningPosition)
        {
            if (gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]]==gameState[winningPosition[2]] && gameState[winningPosition[0]]!=2)
            {
                gameActive=false;
                String winner;
               // gridLayout.setVisibility(View.I);

                if(activePlayer==0)
                {
                    winner="Jesse";
                    Intent intent =new Intent(this,WinnerActivity.class);
                    intent.putExtra("message",winner);
                    startActivity(intent);


                }
                else
                {
                    winner="Haisenburg";
                    Intent intent =new Intent(this,WinnerActivity.class);
                    intent.putExtra("message",winner);
                    startActivity(intent);
                }
                Toast.makeText(this,winner+" has won",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}