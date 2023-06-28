package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PostGame extends AppCompatActivity {

    TextView txt;
    Button Back, Share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_game);
        txt = findViewById(R.id.resultTxt);
        Back = findViewById(R.id.goBack);
        Share = findViewById(R.id.ShareGame);
        txt.setText(getIntent().getStringExtra("result").toString());
    }

    public void GoBack()
    {
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
    }

    public void Share()
    {

    }
}