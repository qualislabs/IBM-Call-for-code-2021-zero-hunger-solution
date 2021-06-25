package com.qualislabs.mashinani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import life.sabujak.roundedbutton.RoundedButton;

public class IntroActivity extends AppCompatActivity {
    RoundedButton mRoundedButtonFarmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mRoundedButtonFarmer = (RoundedButton) findViewById(R.id.button_farmer);
        mRoundedButtonFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}