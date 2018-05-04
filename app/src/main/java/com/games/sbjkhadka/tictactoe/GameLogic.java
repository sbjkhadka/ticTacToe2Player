package com.games.sbjkhadka.tictactoe;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class GameLogic {
    private ImageView imageView;
    private ImageView imageViewSmall;
    private static int playerNumber=0;
    private static int[] turns={2,2,2,2,2,2,2,2,2};
    boolean isGameOver=false;
    static int count=0;
    int index;
    int temp;
    final private int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    GameLogic(){}
    GameLogic(ImageView imageView,ImageView imageViewSmall){
        this.imageView=imageView;
        this.imageViewSmall=imageViewSmall;
    }

    public void animation(){
         index=Integer.parseInt(imageView.getTag().toString());
        if (turns[index]==2){
            temp=turns[index];
            turns[index]=playerNumber;
            imageView.setTranslationY(-1000f);
                if (playerNumber==0){
                    imageViewSmall.setImageResource(R.drawable.red);
                    imageView.setImageResource(R.drawable.blue);
                    playerNumber=1;
                }else {
                    imageViewSmall.setImageResource(R.drawable.blue);
                    imageView.setImageResource(R.drawable.red);
                    playerNumber=0;
                }
            imageView.setVisibility(View.VISIBLE);
            imageView.animate().translationYBy(1000f).alpha(1f).setDuration(500);
        }
    }

    public int gameSequence(){
        //winner fetcher loop
            for (int i=0;i<winningPositions.length;i++){
                int a=turns[winningPositions[i][0]];
                int b=turns[winningPositions[i][1]];
                int c=turns[winningPositions[i][2]];
                        if((a==b)&&(a==c)){
                            if (a==0){
                                isGameOver=true;
                                return 0; //player red wins
                            }else if(a==1){
                                isGameOver=true;
                                return 1; //player blue wins
                            }
                        }
            } //winner fetcher loop ends
        if (count==turns.length-1){
                isGameOver=true;
                return 2; //its a draw
        }else {
                //if(turns[index]==2){
            if(temp==2){
                    //turns[index]=playerNumber;
                    ++count;
                }
            Log.i("COUNT",Integer.toString(count));
                return 3; //playing continues
        }
    }

    public void restart(LinearLayout linearLayout, android.support.v7.widget.GridLayout gridLayout){
        playerNumber=0;
        count=0;
        for (int i=0;i<turns.length;i++){
            turns[i]=2;
        }
        linearLayout.setVisibility(View.INVISIBLE);
        for (int i=0;i<gridLayout.getChildCount();i++){
                ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

}




