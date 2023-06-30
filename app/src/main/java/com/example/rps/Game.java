package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button b_rock, b_paper, b_scissor;
    TextView tvH,tvC, tvS, txt;
    ImageView humanI, compI;
    int HumanScore, CompScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        b_rock = findViewById(R.id.rock_b);
        b_paper = findViewById(R.id.paper_b);
        b_scissor = findViewById(R.id.scissors_b);

        tvH = findViewById(R.id.humanChoice);
        tvC = findViewById(R.id.compChoice);
        tvS = findViewById(R.id.score);
        txt = findViewById(R.id.textView2);

        humanI = findViewById(R.id.humanImg);
        compI = findViewById(R.id.compImg);
    }

    public void RockClick(View view)
    {
        humanI.setImageResource(R.drawable.rock);
        String message = turn("rock");
        txt.setText(message);
        tvS.setText("You: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(CompScore));
        GameResult();
    }

    public void PaperClick(View view)
    {
        humanI.setImageResource(R.drawable.paper);
        String message = turn("paper");
        txt.setText(message);
        tvS.setText("You: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(CompScore));
        GameResult();
    }

    public void ScissorsClick(View view)
    {
        humanI.setImageResource(R.drawable.scissor);
        String message = turn("scissors");
        txt.setText(message);
        tvS.setText("You: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(CompScore));
        GameResult();
    }

    public String turn(String a) {
        String b = "";
        Random r = new Random();
        int pc_choice_num = r.nextInt(3);

        //set computer pick
        if (pc_choice_num == 0) {
            b = "rock";
        } else if (pc_choice_num == 1) {
            b = "paper";
        } else if (pc_choice_num == 2) {
            b = "scissors";
        }

        //set computer image
        if (b == "rock") {
            compI.setImageResource(R.drawable.rock);
        } else if (b == "paper") {
            compI.setImageResource(R.drawable.paper);
        } else if (b == "scissors") {
            compI.setImageResource(R.drawable.scissor);
        }

        //determine winner
        if (a == b) {
            return "Draw.";
        } else if (a == "rock" && b == "scissors") {
            HumanScore++;
            return "W";
        } else if (a == "rock" && b == "paper") {
            CompScore++;
            return "L";
        } else if (a == "scissors" && b == "rock") {
            CompScore++;
            return "L";
        } else if (a == "scissors" && b == "paper") {
            HumanScore++;
            return "W";
        } else if (a == "paper" && b == "rock") {
            HumanScore++;
            return "W";
        } else if (a == "paper" && b == "scissors") {
            CompScore++;
            return "L";
        } else {
            return "HUH";
        }

    }

    public void GameResult()
    {
        if(HumanScore == 10)
        {
            Intent intent = new Intent(this, PostGame.class);
            intent.putExtra("result", "You have won the game!");
            intent.putExtra("humanS", HumanScore);
            intent.putExtra("compS", CompScore);
            startActivity(intent);
        }
        if(CompScore == 10)
        {
            Intent intent = new Intent(this, PostGame.class);
            intent.putExtra("result", "You lost! L + ratio");
            intent.putExtra("humanS", HumanScore);
            intent.putExtra("compS", CompScore);
            startActivity(intent);
        }
    }
}