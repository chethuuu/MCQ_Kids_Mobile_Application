package com.example.practise10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Exam_I extends AppCompatActivity {

    EditText q1, q2;
    Button saveBtn;

    ProgressDialog pd;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_i);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Data");

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        saveBtn = findViewById(R.id.saveBtn);

        pd = new ProgressDialog(this);

        db = FirebaseFirestore.getInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String Q1 = q1.getText().toString().trim();
                //String Q2 = q2.getText().toString().trim();

                //uploadData(Q1,Q2);
            }
        });

    }

    /*private void uploadData (String q1, String q2) {
        pd.setTitle("Adding Data to the Firestore...");
        pd.show();

        String id = UUID.randomUUID().toString();

        Map<String,Object> doc = new HashMap<>();

        doc.put("id",id);
        doc.put("Q1",q1);
        doc.put("Q2",q2);

        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(Exam_I.this, "Uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(Exam_I.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }*/
}