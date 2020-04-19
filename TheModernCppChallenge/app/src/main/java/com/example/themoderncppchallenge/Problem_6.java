package com.example.themoderncppchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Problem_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_6);

        TextView subtitle = findViewById(R.id.subtitle);
        subtitle.setText(getString(R.string.problem_with_number, 6));

        TextView problemTitle = findViewById(R.id.problemTitle);
        problemTitle.setText(getString(R.string.problem_6_title));

        TextView problemText = findViewById(R.id.problemText);
        problemText.setText(getString(R.string.problem_6_text));

        Button button_next = findViewById(R.id.button_next);
        button_next.setVisibility(View.INVISIBLE);

        EditText et = findViewById(R.id.plain_text_input);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int limit = 0;
                if(s.length() != 0)
                {
                    limit =  Integer.parseInt(s.toString());
                }
                TextView tv = findViewById(R.id.result);
                tv.setText(getString(R.string.result_placeholder, AbundantNumbersUpTo(limit)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void goToNextProblem(View v)
    {
        // empty on purpose
    }

    public void goToPreviousProblem(View v)
    {
        Intent intent = new Intent(this, Problem_5.class);
        startActivity(intent);
    }

    public native String AbundantNumbersUpTo(int userInput);
}
