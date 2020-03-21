package com.example.themoderncppchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                tv.setText("Result: " + Sum3And5Multiples(limit));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     * @param i
     */
    public native String Sum3And5Multiples(int i);

    public native String Gcd(int i, int j);
}
