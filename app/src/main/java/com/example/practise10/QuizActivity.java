package com.example.practise10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView tot_questions;
    private TextView question;

    private AppCompatButton option_1 , option_2 , option_3 , option_4;
    private AppCompatButton next_Btn;

    private Timer quizTimer;
    private int totalTimeInMins = 1;
    private int seconds = 0;

    private List<QuestionsList> questionsLists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topic_name);

        tot_questions = findViewById(R.id.tot_questions);
        question = findViewById(R.id.question);

        option_1 = findViewById(R.id.option_1);
        option_2 = findViewById(R.id.option_2);
        option_3 = findViewById(R.id.option_3);
        option_4 = findViewById(R.id.option_4);

        next_Btn = findViewById(R.id.next_Btn);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        questionsLists = QuestionsBank.getQuestions(getSelectedTopicName);

        startTimer(timer);

        question.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());

        option_1.setText(questionsLists.get(0).getOption_1());
        option_2.setText(questionsLists.get(0).getOption_2());
        option_3.setText(questionsLists.get(0).getOption_3());
        option_4.setText(questionsLists.get(0).getOption_4());

        option_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty())
                {
                    selectedOptionByUser = option_1.getText().toString();
                    option_1.setBackgroundResource(R.drawable.round_br);
                    option_1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty())
                {
                    selectedOptionByUser = option_2.getText().toString();
                    option_2.setBackgroundResource(R.drawable.round_br);
                    option_2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty())
                {
                    selectedOptionByUser = option_3.getText().toString();
                    option_3.setBackgroundResource(R.drawable.round_br);
                    option_3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty())
                {
                    selectedOptionByUser = option_4.getText().toString();
                    option_4.setBackgroundResource(R.drawable.round_br);
                    option_4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty())
                {
                    Toast.makeText(QuizActivity.this,"Please Select an Option",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    changeNextQuestion();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void changeNextQuestion()
    {
        currentQuestionPosition++;

        if ((currentQuestionPosition+1) == questionsLists.size())
        {
            next_Btn.setText("Submit Quiz");
        }

        if (currentQuestionPosition < questionsLists.size())
        {
            selectedOptionByUser = "";

            option_1.setBackgroundResource(R.drawable.round_bw_s);
            option_1.setTextColor(Color.parseColor("#1F6BB8"));

            option_2.setBackgroundResource(R.drawable.round_bw_s);
            option_2.setTextColor(Color.parseColor("#1F6BB8"));

            option_3.setBackgroundResource(R.drawable.round_bw_s);
            option_3.setTextColor(Color.parseColor("#1F6BB8"));

            option_4.setBackgroundResource(R.drawable.round_bw_s);
            option_4.setTextColor(Color.parseColor("#1F6BB8"));

            question.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());

            option_1.setText(questionsLists.get(currentQuestionPosition).getOption_1());
            option_2.setText(questionsLists.get(currentQuestionPosition).getOption_2());
            option_3.setText(questionsLists.get(currentQuestionPosition).getOption_3());
            option_4.setText(questionsLists.get(currentQuestionPosition).getOption_4());

        }

        else
        {
            Intent intent = new Intent (QuizActivity.this, QuizResults.class);
            intent.putExtra("correct" , getCorrectAnswers());
            intent.putExtra("incorrect" , getIncorrectAnswers());
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextview)
    {
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds == 0)
                {
                    totalTimeInMins--;
                    seconds=59;
                }
                else if (seconds == 0 && totalTimeInMins == 0)
                {
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this,"Time Over",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this,QuizResults.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getIncorrectAnswers());
                    startActivity(intent);

                    finish();
                }

                else
                {
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1)
                        {
                            finalMinutes = "0" + finalMinutes;
                        }

                        if (finalSeconds.length() == 1)
                        {
                            finalSeconds = "0" + finalSeconds;
                        }

                        timerTextview.setText(finalMinutes + ":" + finalSeconds);

                    }
                });
            }
        },1000,1000);
    }

    private int getCorrectAnswers()
    {
        int correctAnswers  = 0;
        for (int i=0; i<questionsLists.size();i++)
        {
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer))
            {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }


    private int getIncorrectAnswers()
    {
        int correctAnswers  = 0;
        for (int i=0; i<questionsLists.size();i++)
        {
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer))
            {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }

    private void revealAnswer()
    {
        final  String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if (option_1.getText().toString().equals(getAnswer))
        {
            option_1.setBackgroundResource(R.drawable.round_bgreen);
            option_1.setTextColor(Color.WHITE);
        }

        else if (option_2.getText().toString().equals(getAnswer))
        {
            option_2.setBackgroundResource(R.drawable.round_bgreen);
            option_2.setTextColor(Color.WHITE);
        }

        else if (option_3.getText().toString().equals(getAnswer))
        {
            option_3.setBackgroundResource(R.drawable.round_bgreen);
            option_3.setTextColor(Color.WHITE);
        }

        else if (option_2.getText().toString().equals(getAnswer))
        {
            option_4.setBackgroundResource(R.drawable.round_bgreen);
            option_4.setTextColor(Color.WHITE);
        }
    }

}