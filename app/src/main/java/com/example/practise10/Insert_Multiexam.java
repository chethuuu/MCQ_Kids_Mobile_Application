package com.example.practise10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Insert_Multiexam extends AppCompatActivity {

    EditText q1, q2, q3, q4, q5, q6, q7, q8;
    Button saveBtn;

    ProgressDialog pd;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_multiexam);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Data");

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        saveBtn = findViewById(R.id.saveBtn);

        pd = new ProgressDialog(this);

        db = FirebaseFirestore.getInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Q1 = q1.getText().toString().trim();
                String Q2 = q2.getText().toString().trim();
                String Q3 = q3.getText().toString().trim();
                String Q4 = q4.getText().toString().trim();
                String Q5 = q5.getText().toString().trim();
                String Q6 = q6.getText().toString().trim();
                String Q7 = q7.getText().toString().trim();
                String Q8 = q8.getText().toString().trim();

                uploadData(Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8);
            }
        });

    }

    private void uploadData(String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        pd.setTitle("Adding Data to the Firestore...");
        pd.show();

        String id = UUID.randomUUID().toString();

        Map<String,Object> doc = new HashMap<>();

        doc.put("id",id);
        doc.put("Q1",q1);
        doc.put("Q2",q2);
        doc.put("Q3",q3);
        doc.put("Q4",q4);
        doc.put("Q5",q5);
        doc.put("Q6",q6);
        doc.put("Q7",q7);
        doc.put("Q8",q8);

        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(Insert_Multiexam.this, "Uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(Insert_Multiexam.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}