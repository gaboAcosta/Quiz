package com.example.gabrielacosta.myquiz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mPreviousButton;
    private Button mNextButton;
    private TextView mQuestionText;

    private Question mCurrentQuestion;
    private Question[] mQuestionBank = new Question[]{
            new Question("La Paz is the US capital", false),
            new Question("La Paz is Bolivia's capital", true),
            new Question("A River is any concentration of water", false),
            new Question("Toronto is Canada's Capital", true),
            new Question("Mexico is the largest country in the world", false)
    };
    private int mCurrentIndex = 0;

    private int snackLength = 1000;

    private void updateQuestion(){
        mCurrentQuestion = mQuestionBank[mCurrentIndex];
        mQuestionText.setText(mCurrentQuestion.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mQuestionText = (TextView) findViewById(R.id.question_text);
        updateQuestion();
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex == 0){
                    Snackbar.make(v, "There is no previous question", snackLength)
                            .setAction("Action", null).show();
                } else {
                    mCurrentIndex --;
                    updateQuestion();
                }
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((mCurrentIndex + 1) == mQuestionBank.length){
                    Snackbar.make(v, "There is no next question", snackLength)
                            .setAction("Action", null).show();
                } else {
                    mCurrentIndex ++;
                    updateQuestion();
                }
            }
        });

        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View trueButton){
                String message = "Your answer is incorrect!";

                if(mCurrentQuestion.getAnswer() == true){
                    message = "Your answer is correct";
                }


                Snackbar.make(trueButton, message, snackLength)
                        .setAction("Action", null).show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Your answer is incorrect!";

                if(mCurrentQuestion.getAnswer() == false){
                    message = "Your answer is correct";
                }
                Snackbar.make(view, message, snackLength)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
