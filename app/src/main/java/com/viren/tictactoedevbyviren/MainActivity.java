package com.viren.tictactoedevbyviren;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     boolean gameActive = true;
    // Representation
    // [ 1 == X ] , [ 0 == O ] , [2=NULL]

    int activePlayer = 0;
    int [] gameState = {2,2 ,2 ,2 ,2 ,2 ,2 , 2, 2};

    int[][] winPositions = {{0,1,2}, {3,4,5},{6,7,8},{0,2,6}, {1,3,7},{2,4,8},{0,4,8},{2,4,6}};



    public void Tap(View view) {

        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        // to get position which section of grid touched
        if(!gameActive){
            gameReset(view);
            return;
        }
        if(gameState[tappedImg] == 2) {
            gameState[tappedImg]= activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("X`s turn : Tap to Play");
            }

            else{
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O`s turn : Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //if player won

        for(int [] win : winPositions){
            if((gameState[win[0]]==gameState[win[1]]) && (gameState[win[1]]==gameState[win[2]]) &&
            gameState[win[0]]!=2) {
                String winnerText;
                gameActive = false;
                if (gameState[win[0]] == 0) {

                    winnerText = "O won the match";
                }

                else {

                    winnerText = " X won the match";
                }

                TextView status = findViewById(R.id.status);
                status.setText(winnerText);

            }
        }

//        for (int i=0; i<9 ;i++){
//
//            int k=0;
//            if(gameState[i]==1 || gameState[i]==0){
//                k++;
//            }
//
//            if(k==8){
//                gameReset(view);
//            }
//        }


    }


    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for(int i=0 ; i<gameState.length;i++){

            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

    }
}