package com.example.practise10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MultiLevel extends AppCompatActivity {

    MediaPlayer mysong;

    private String selectedTopicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_level);

        mysong=MediaPlayer.create(MultiLevel.this,R.raw.dora);

        final Button multilevel1 = findViewById(R.id.mlvl1);
        final Button multilevel2 = findViewById(R.id.mlvl2);
        final Button multilevel3 = findViewById(R.id.mlvl3);
        final Button multilevel4 = findViewById(R.id.mlvl4);

        multilevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Level 01";

                if (selectedTopicName.isEmpty())
                {
                    Toast.makeText(MultiLevel.this,"Please Select the Level", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent = new Intent(MultiLevel.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }

            }
        });

        multilevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Level 02";

                if (selectedTopicName.isEmpty())
                {
                    Toast.makeText(MultiLevel.this,"Please Select the Level", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent = new Intent(MultiLevel.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }

            }
        });

        multilevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Level 03";

                if (selectedTopicName.isEmpty())
                {
                    Toast.makeText(MultiLevel.this,"Please Select the Level", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent = new Intent(MultiLevel.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }

            }
        });

        multilevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Multiplication Exam";

                if (selectedTopicName.isEmpty())
                {
                    Toast.makeText(MultiLevel.this,"Please Select the Level", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent = new Intent(MultiLevel.this, Exam_d.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }

            }
        });

    }

    public void playIT(View v) {
        mysong.start();
    }
}