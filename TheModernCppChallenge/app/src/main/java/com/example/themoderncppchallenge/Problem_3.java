package com.example.themoderncppchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Problem_3 extends AppCompatActivity {
    private void computeAndDisplayResult()
    {
        EditText et1 = findViewById(R.id.first_input_number);
        EditText et2 = findViewById(R.id.second_input_number);

        int firstNumber = extractNumberFromEditText(et1);
        int secondNumber = extractNumberFromEditText(et2);

        TextView tv = findViewById(R.id.result);
        tv.setText(getString(R.string.result_placeholder, Lcm(firstNumber, secondNumber)));
    }

    private int extractNumberFromEditText(EditText et)
    {
        assert et.getText().length() != 0 : "The EditText must not be empty";
        return Integer.parseInt(et.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_3);

        TextView subtitle = findViewById(R.id.subtitle);
        subtitle.setText(getString(R.string.problem_with_number, 3));

        TextView problemTitle = findViewById(R.id.problemTitle);
        problemTitle.setText(getString(R.string.problem_3_title));

        TextView problemText = findViewById(R.id.problemText);
        problemText.setText(getString(R.string.problem_3_text));

        TextView calculation = findViewById(R.id.calculation);
        calculation.setText(getString(R.string.problem_3_current_calculation, ""));

        EditText et = findViewById(R.id.input_number);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count == 0)
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
        Intent intent = new Intent(this, Problem_2.class);
        startActivity(intent);
    }

    public void addUserInput(View v)
    {
        EditText et = findViewById(R.id.input_number);
        if(et.getText().length() == 0)
        {
            return;
        }
        userInputs.add(Integer.parseInt(et.getText().toString()));
        et.setText("");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < userInputs.size(); ++i)
        {
            sb.append(userInputs.get(i));
            if(i != userInputs.size() - 1)
            {
                sb.append(", ");
            }
        }
        TextView calculation = findViewById(R.id.calculation);
        calculation.setText(getString(R.string.problem_3_current_calculation, sb.toString()));
    }

    public void clearUserInput(View v)
    {
        userInputs.clear();

        TextView calculation = findViewById(R.id.calculation);
        calculation.setText(getString(R.string.problem_3_current_calculation, ""));
    }

    public native String Lcm(int i, int j);

    List<Integer> userInputs = new ArrayList<Integer>();
}
