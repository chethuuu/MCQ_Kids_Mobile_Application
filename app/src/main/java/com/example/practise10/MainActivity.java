package com.example.practise10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout multiplication = findViewById(R.id.multiLayout);
        final LinearLayout addition = findViewById(R.id.addLayout);
        final LinearLayout division = findViewById(R.id.DivLayout);
        final LinearLayout subtraction = findViewById(R.id.subLayout);

        final Button startBtn = findViewById(R.id.start_quiz_btn);

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Multiplication";

                multiplication.setBackgroundResource(R.drawable.round_bws);

                addition.setBackgroundResource(R.drawable.menu_color);
                division.setBackgroundResource(R.drawable.menu_color);
                subtraction.setBackgroundResource(R.drawable.menu_color);
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Addition";

                addition.setBackgroundResource(R.drawable.round_bws);

                multiplication.setBackgroundResource(R.drawable.menu_color);
                division.setBackgroundResource(R.drawable.menu_color);
                subtraction.setBackgroundResource(R.drawable.menu_color);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Division";

                division.setBackgroundResource(R.drawable.round_bws);

                multiplication.setBackgroundResource(R.drawable.menu_color);
                addition.setBackgroundResource(R.drawable.menu_color);
                subtraction.setBackgroundResource(R.drawable.menu_color);
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "Subtraction";

                subtraction.setBackgroundResource(R.drawable.round_bws);

                multiplication.setBackgroundResource(R.drawable.menu_color);
                division.setBackgroundResource(R.drawable.menu_color);
                addition.setBackgroundResource(R.drawable.menu_color);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedTopicName.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please Select the Topic", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent = new Intent(MainActivity.this, MultiMenu.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }
            }
        });
    }
}