package com.games.sbjkhadka.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int result=3;
    LinearLayout linearLayout;
    ImageView imageViewSmall;
    android.support.v7.widget.GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gameStart(View view){
        ImageView imageView=(ImageView) view;
        imageViewSmall=(ImageView) findViewById(R.id.playerColor);
        GameLogic gameLogic=new GameLogic(imageView,imageViewSmall);
        linearLayout=(LinearLayout) findViewById(R.id.dialog);
        gridLayout=(android.support.v7.widget.GridLayout)findViewById(R.id.gridBoard);
        if (result==3){
            gameLogic.animation();
            result=gameLogic.gameSequence();
            String message;
            Log.i("RETURNEE",Integer.toString(result));
                if(result==0){
                    message="Player BLUE wins!!!";
                }else if(result==1){
                    message="Player RED wins";
                }else if(result==2){
                    message="Its a draw";
                }else {
                    message="Keep playing";
                }

                if (result==0||result==1||result==2)
                {
                    ((TextView)findViewById(R.id.txtMessage)).setText(message);
                    linearLayout.setTranslationY(-1000f);
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout.animate().translationYBy(1000f).alpha(1f).setDuration(2000);
                }
        }
    }

    public void gameRestart(View view){
        result=3;
        GameLogic gameLogic=new GameLogic();
        gameLogic.restart(linearLayout,gridLayout);
    }
}
