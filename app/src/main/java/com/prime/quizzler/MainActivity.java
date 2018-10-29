package com.prime.quizzler;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvQuestionNumber;
    private TextView tvScore;
    private Button btnTrue;
    private Button btnFalse;
    private ProgressBar questionProgressBar;

    private QuesitonBank allQuestions;
    private boolean pickedAnswer = false;
    private int questionNumber = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind view
        tvQuestion = findViewById(R.id.tv_question);
        tvQuestionNumber = findViewById(R.id.tv_question_number);
        tvScore = findViewById(R.id.tv_score);
        btnTrue = findViewById(R.id.btn_true);
        btnFalse = findViewById(R.id.btn_false);
        questionProgressBar = findViewById(R.id.progressBar);

        allQuestions = new QuesitonBank();

        nextQuestion();

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickedAnswer = true;
                checkAnswer(pickedAnswer);
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickedAnswer = false;
                checkAnswer(pickedAnswer);
            }
        });
    }

    private void checkAnswer(boolean pickedAnswer) {
        boolean correctAnswer = allQuestions.list.get(questionNumber).answer;
        if (correctAnswer == pickedAnswer) {
            score = score + 1;
            Log.d("TAG: ", "Correct");
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("TAG: ", "Wrong");
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
        questionNumber = questionNumber + 1;
        nextQuestion();
    }

    private void nextQuestion() {
        if (questionNumber <= allQuestions.list.size() - 1) {
            tvQuestion.setText(allQuestions.list.get(questionNumber).questionText);
            updateUI();
        } else {
            updateUI();
            new AlertDialog.Builder(this)
                    .setTitle("Awesome")
                    .setMessage("You've finished all the questions, do you want to start over?")
                    .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startOver();
                        }
                    })
                    .show();
        }
    }

    private void updateUI() {
        tvQuestionNumber.setText(questionNumber + 1 + "/" + allQuestions.list.size());
        tvScore.setText("Score: " + score);
        questionProgressBar.setProgress(questionNumber+1);
    }

    private void startOver() {
        score = 0;
        questionNumber = 0;
        nextQuestion();
    }
}
