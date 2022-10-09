package com.example.game;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    private Game game ;
    private  int score;
    private  int qNum;
    private String question;
    private String answer;
    private String log;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question= "" ;
        answer="" ;
        score =0 ;
        qNum=1 ;
        log="";
        ((TextView) findViewById(R.id.score)).setText("Score = " + score);
        ((TextView)findViewById(R.id.qNum)).setText("Q# "+qNum);
        ask();
    }




//Controller shall have two methods

    //Method1
    public void ask(){
        Game game = new Game();
        String  codedResultString = game.qa();
        String lines[]= codedResultString.split("\\n") ;
        this.question= lines[0] ;
        this.answer=lines[1] ;
        TextView ques= ((TextView) findViewById(R.id.question));
        ques.setText(question);
        //  ((TextView) findViewById(R.id.score)).setText("Score = " + score);
        // ((TextView)findViewById(R.id.qNum)).setText("Q# "+qNum);





    }



    //Method2

    @SuppressLint("SetTextI18n")
    public void onDone(View v){


        TextView qN=(TextView) findViewById(R.id.qNum) ;
        TextView result=(TextView) findViewById(R.id.log);
        TextView scoreO=(TextView) findViewById(R.id.score) ;
        String ansS,resultS = "";

        if (qNum == 10){
            qN.setText("Game Over!");
            Button button1= (Button) findViewById(R.id.button) ;
            button1.setEnabled(false);
            button1.setClickable(false);
            finish();
        }

        else {

            ansS= ((EditText) findViewById(R.id.answer)).getText().toString();
            resultS +="\nQ# " + qNum +":"+question+ "\nYour Answer:" + ansS + "\nCorrect Answer: " + answer + "\n" ;
            log+=  resultS ;
            qNum++ ;
            qN.setText("Q# "+qNum);
            result.setText(log);
            if (ansS.equalsIgnoreCase(answer)){
                score++;
                scoreO.setText("SCORE= "+score);
            }

            ask();

        }


    }


}