package com.example.themoderncppchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    void addButton(@IdRes int id, String text)
    {
        RelativeLayout ll = findViewById(R.id.buttons);

        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button b = new Button(this);
        b.setId(id);
        b.setText(text);
        b.setOnClickListener(this);

        newParams.addRule (RelativeLayout.ALIGN_LEFT);
        b.setLayoutParams(newParams);
        ll.addView(b);
    }

    void addButton(@IdRes int id, String text, @IdRes int idOfLeftElement)
    {
        RelativeLayout ll = findViewById(R.id.buttons);

        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button b = new Button(this);
        b.setId(id);
        b.setText(text);
        b.setOnClickListener(this);

        newParams.addRule (RelativeLayout.RIGHT_OF, idOfLeftElement);
        b.setLayoutParams(newParams);
        ll.addView(b);
    }

    void addButtonBelow(@IdRes int id, String text, @IdRes int idOfElementOnTop)
    {
        RelativeLayout ll = findViewById(R.id.buttons);

        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button b = new Button(this);
        b.setId(id);
        b.setText(text);
        b.setOnClickListener(this);

        newParams.addRule (RelativeLayout.BELOW, idOfElementOnTop);
        b.setLayoutParams(newParams);
        ll.addView(b);
    }

    void addButtonBelow(@IdRes int id, String text, @IdRes int idOfLeftElement, @IdRes int idOfElementOnTop)
    {
        RelativeLayout ll = findViewById(R.id.buttons);

        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button b = new Button(this);
        b.setId(id);
        b.setText(text);
        b.setOnClickListener(this);

        newParams.addRule (RelativeLayout.RIGHT_OF, idOfLeftElement);
        newParams.addRule (RelativeLayout.BELOW, idOfElementOnTop);
        b.setLayoutParams(newParams);
        ll.addView(b);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton(R.id.menu_button_1, "1");
        addButton(R.id.menu_button_2, "2", R.id.menu_button_1);
        addButton(R.id.menu_button_3, "3", R.id.menu_button_2);
        addButton(R.id.menu_button_4, "4", R.id.menu_button_3);
        addButtonBelow(R.id.menu_button_5, "5", R.id.menu_button_1);
        addButtonBelow(R.id.menu_button_6, "6", R.id.menu_button_5, R.id.menu_button_2);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.menu_button_1:
                startActivity(new Intent(this, Problem_1.class));
                break;
            case R.id.menu_button_2:
                startActivity(new Intent(this, Problem_2.class));
                break;
            case R.id.menu_button_3:
                startActivity(new Intent(this, Problem_3.class));
                break;
            case R.id.menu_button_4:
                startActivity(new Intent(this, Problem_4.class));
                break;
            case R.id.menu_button_5:
                startActivity(new Intent(this, Problem_5.class));
                break;
            case R.id.menu_button_6:
                startActivity(new Intent(this, Problem_6.class));
                break;
            default:
                new AssertionError("Unknown menu button.");
                break;
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     * @param i input given by the user which is the limit used by the algorithm
     */
    public native String Sum3And5Multiples(int i);
}
