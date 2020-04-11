package com.example.themoderncppchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ProblemInterface {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView subtitle = findViewById(R.id.subtitle);
        subtitle.setText(getString(R.string.problem_with_number, 1));

        TextView problemTitle = findViewById(R.id.problemTitle);
        problemTitle.setText(getString(R.string.problem_1_title));

        TextView problemText = findViewById(R.id.problemText);
        problemText.setText(getString(R.string.problem_1_text));

        Button button_previous = findViewById(R.id.button_previous);
        button_previous.setVisibility(View.INVISIBLE);

        EditText et = findViewById(R.id.plain_text_input);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int limit = 0;
                if(count != 0)
                {
                    limit =  Integer.parseInt(s.toString());
                }
                TextView tv = findViewById(R.id.result);
                tv.setText(getString(R.string.result_placeholder, Sum3And5Multiples(limit)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void goToNextProblem(View v)
    {
        Intent intent = new Intent(this, Problem_2.class);
        startActivity(intent);
    }

    @Override
    public void goToPreviousProblem(View v) {
        // empty on purpose
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     * @param i input given by the user which is the limit used by the algorithm
     */
    public native String Sum3And5Multiples(int i);
}
