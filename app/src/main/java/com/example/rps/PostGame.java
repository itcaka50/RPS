package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PostGame extends AppCompatActivity {

    TextView txt, tvt;
    Button Back, Share;
    String score;
    int h,c;
    int size = 0;
    ArrayList<String> kotki = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_game);
        txt = findViewById(R.id.resultTxt);
        Back = findViewById(R.id.goBack);
        Share = findViewById(R.id.ShareGame);
        tvt = findViewById(R.id.tv3);
        h = getIntent().getIntExtra("humanS", 0);
        c = getIntent().getIntExtra("compS", 0);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.clear().apply();

        size = sharedPref.getInt("size", 0);
        editor.putString("score" + Integer.toString(size) ,Integer.toString(h) + " - " + Integer.toString(c));
        size++;
        editor.putInt("size", size);
        editor.apply();
        //Toast.makeText(this, Integer.toString(size), Toast.LENGTH_SHORT).show();
        for(int i = 0; i < size; i++){
            tvt.setText(tvt.getText()+ System.getProperty("line.separator") + sharedPref.getString("score" + Integer.toString(i), null));
        }

        txt.setText(getIntent().getStringExtra("result"));
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
