package com.example.tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class AddQuestionsActivity extends AppCompatActivity {

    private Button addQuestionBtn;
    private TextInputEditText questionEdt, answerEdt;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ProgressBar loadingPB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);

        addQuestionBtn = findViewById(R.id.BtnAdd);

        questionEdt = findViewById(R.id.addquestion);
        answerEdt = findViewById(R.id.addanswer);

        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();

        // on below line creating our database reference.
        databaseReference = firebaseDatabase.getReference("questions");

    addQuestionBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        loadingPB.setVisibility(View.VISIBLE);
        String question = questionEdt.getText().toString();
        String answer = answerEdt.getText().toString();

        item courseRVModal = new item(question, answer);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // on below line we are setting data in our firebase database.
                databaseReference.child(question).setValue(courseRVModal);
                // displaying a toast message.
                Toast.makeText(AddQuestionsActivity.this, "Question Added..", Toast.LENGTH_SHORT).show();
                // starting a main activity.
                startActivity(new Intent(AddQuestionsActivity.this, MainActivity.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // displaying a failure message on below line.
                Toast.makeText(AddQuestionsActivity.this, "Fail to add Question..", Toast.LENGTH_SHORT).show();
            }

        });

    }
});

}
}