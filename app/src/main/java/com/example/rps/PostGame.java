package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

    public void GoBack(View view)
    {
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
    }

    public void Share(View view)
    {
        String a = "I have won a game of rock, paper, scissors";
        String b = "The computer has bested me at rock, paper, scissors";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        if(txt.toString().equals("You have won the game!"))
        {
            intent.putExtra(intent.EXTRA_TEXT, a);

        }
        if(txt.toString().equals("You lost! L + ratio"))
        {
            intent.putExtra(intent.EXTRA_TEXT, b);

        }
        Intent share =  Intent.createChooser(intent, "Share score: ");
        startActivity(share);
    }
}