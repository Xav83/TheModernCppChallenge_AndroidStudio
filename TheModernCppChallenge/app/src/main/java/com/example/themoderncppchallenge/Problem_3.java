package com.example.themoderncppchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Problem_3 extends ProblemInterface {
    private void computeAndDisplayResult()
    {
        assert userInputs.size() > 2 : "lcm works with at least two parameters";

        TextView tv = findViewById(R.id.result);
        tv.setText(getString(R.string.result_placeholder, Lcm(userInputs.stream().mapToInt(i->i).toArray())));
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
    }

    public void goToNextProblem(View v)
    {
        Intent intent = new Intent(this, Problem_4.class);
        startActivity(intent);
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
        if(userInputs.size() >= 2)
        {
            computeAndDisplayResult();
        }
    }

    public void clearUserInput(View v)
    {
        userInputs.clear();

        TextView calculation = findViewById(R.id.calculation);
        calculation.setText(getString(R.string.problem_3_current_calculation, ""));

        TextView result = findViewById(R.id.result);
        result.setText(getString(R.string.result));
    }

    public native String Lcm(int [] userInputs);

    List<Integer> userInputs = new ArrayList<Integer>();
}
