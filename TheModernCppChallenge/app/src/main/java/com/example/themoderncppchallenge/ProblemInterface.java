package com.example.themoderncppchallenge;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public abstract class ProblemInterface extends AppCompatActivity {
    public abstract void goToNextProblem(View v);
    public abstract void goToPreviousProblem(View v);

    public void goToMenu(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }
}
