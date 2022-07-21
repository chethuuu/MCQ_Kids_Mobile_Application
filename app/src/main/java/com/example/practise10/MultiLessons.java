package com.example.practise10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiLessons extends AppCompatActivity {

    private Button lesson1;
    private Button lesson2;
    private Button lesson3;
    private Button lesson_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_lessons);

        lesson1 = findViewById(R.id.less1);
        lesson2 = findViewById(R.id.less2);
        lesson3 = findViewById(R.id.less3);
        lesson_back = findViewById(R.id.less_start);

        lesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiLessons.this,Multi_1.class);
                startActivity(intent);
            }
        });

        lesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiLessons.this,Multi_2.class);
                startActivity(intent);
            }
        });

        lesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiLessons.this,Multi_3.class);
                startActivity(intent);
            }
        });

        lesson_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiLessons.this,MultiMenu.class);
                startActivity(intent);
            }
        });
    }
}