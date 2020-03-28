package com.example.themoderncppchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Problem_2 extends AppCompatActivity {
    private void computeAndDisplayResult()
    {
        EditText et1 = findViewById(R.id.first_input_number);
        EditText et2 = findViewById(R.id.second_input_number);

        int firstNumber = extractNumberFromEditText(et1);
        int secondNumber = extractNumberFromEditText(et2);

        TextView tv = findViewById(R.id.result);
        tv.setText(getString(R.string.result_placeholder, Gcd(firstNumber, secondNumber)));
    }

    private int extractNumberFromEditText(EditText et)
    {
        assert et.getText().length() != 0 : "The EditText must not be empty";
        return Integer.parseInt(et.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_2);

        TextView tv = findViewById(R.id.subtitle);
        tv.setText(getString(R.string.problem_with_number, 2));

        TextView problemTitle = findViewById(R.id.problemTitle);
        problemTitle.setText(getString(R.string.problem_2_title));

        TextView problemText = findViewById(R.id.problemText);
        problemText.setText(getString(R.string.problem_2_text));

        EditText et = findViewById(R.id.first_input_number);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText et = findViewById(R.id.second_input_number);
                if(et.getText().length() == 0 || count == 0)
                {
                    return;
                }
                computeAndDisplayResult();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText et2 = findViewById(R.id.second_input_number);
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText et = findViewById(R.id.first_input_number);
                if(et.getText().length() == 0 || count == 0)
                {
                    return;
                }
                computeAndDisplayResult();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void goToPreviousProblem(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public native String Gcd(int i, int j);
}
