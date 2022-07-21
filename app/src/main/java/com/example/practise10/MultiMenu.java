package com.example.practise10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiMenu extends AppCompatActivity {

    private Button multiLesson;
    private Button multiquiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_menu);

        multiLesson = findViewById(R.id.mlesson);
        multiquiz = findViewById(R.id.mquiz);

        multiquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiMenu.this,MultiLessons.class);
                startActivity(intent);
            }
        });

        multiLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiMenu.this,MultiLevel.class);
                startActivity(intent);
            }
        });

    }
}