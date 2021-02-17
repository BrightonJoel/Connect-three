package com.example.gameconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0:yellow , 1:red
    int [][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    boolean b = true;
    int c=1;
    public void dropIn(View view){
        ImageView counter = (ImageView)view;
        Log.i("Tag",counter.getTag().toString());
        int tappedcounter = Integer.parseInt( counter.getTag().toString());

        if(gameState[tappedcounter]==2 && b&& c<=9) {
            c++;
            gameState[tappedcounter] = activePlayer;
            counter.setTranslationY(-4000);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(4000).rotation(3600).setDuration(300);
            for (int[] wins : winpos) {
                if (gameState[wins[0]] == gameState[wins[1]] && gameState[wins[1]] == gameState[wins[2]] && gameState[wins[0]] != 2) {
                    String winners;
                    if (activePlayer == 1) {
                        winners = "Yellow ";
                    } else {
                        winners = "Red ";
                    }
                    b=false;
                    //Toast.makeText(this, winners+ " has won!", Toast.LENGTH_SHORT).show();

                    Button playAgainbutton = (Button) findViewById(R.id.playAgainButton);

                    TextView Winner = (TextView) findViewById(R.id.textView);
                    Winner.setText(winners+ "has won!");
                    playAgainbutton.setVisibility(view.VISIBLE);
                    Winner.setVisibility(view.VISIBLE);
                }

            }
            if(c==9){
                b=false;
            }

        }
        else{
            if(b)
            Toast.makeText(this,  " replacement is Not allowed ", Toast.LENGTH_SHORT).show();
            else  {
                Toast.makeText(this, " The game is finished already", Toast.LENGTH_SHORT).show();
                if (activePlayer == 0) {
                    counter.setImageResource(R.drawable.yellow);
                    activePlayer = 1;
                } else {
                    counter.setImageResource(R.drawable.red);
                    activePlayer = 0;
                }


                        Button playAgainbutton = (Button) findViewById(R.id.playAgainButton);
                        TextView Winner = (TextView) findViewById(R.id.textView);
                        Winner.setText("Its a Draw!");
                        playAgainbutton.setVisibility(view.VISIBLE);
                        Winner.setVisibility(view.VISIBLE);


                }

            }
        }

    public void playAgian(View view){

        Button playAgainbutton = (Button) findViewById(R.id.playAgainButton);

        TextView Winner = (TextView) findViewById(R.id.textView);
        playAgainbutton.setVisibility(view.INVISIBLE);
        Winner.setVisibility(view.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageDrawable(null);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageDrawable(null);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setImageDrawable(null);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView5.setImageDrawable(null);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView6.setImageDrawable(null);
        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView7.setImageDrawable(null);
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setImageDrawable(null);
        ImageView imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView9.setImageDrawable(null);
        ImageView imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView10.setImageDrawable(null);

             for(int i=0;i<gameState.length;i++)
             {
                 gameState[i]=2;
             }
             activePlayer = 0;
             b = true;
             c=1;
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
