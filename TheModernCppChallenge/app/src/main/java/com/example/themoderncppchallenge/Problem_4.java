package com.example.themoderncppchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Problem_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_4);

        TextView subtitle = findViewById(R.id.subtitle);
        subtitle.setText(getString(R.string.problem_with_number, 4));

        TextView problemTitle = findViewById(R.id.problemTitle);
        problemTitle.setText(getString(R.string.problem_4_title));

        TextView problemText = findViewById(R.id.problemText);
        problemText.setText(getString(R.string.problem_4_text));
    }

    public void goToPreviousProblem(View v)
    {
        Intent intent = new Intent(this, Problem_3.class);
        startActivity(intent);
    }
}
