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
    TextView tvH,tvC, tvS;
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

        humanI = findViewById(R.id.humanImg);
        compI = findViewById(R.id.compImg);
    }

    public void RockClick(View view)
    {
        humanI.setImageResource(R.drawable.rock);
        String message = turn("rock");
        Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
        tvS.setText("You: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(CompScore));
        GameResult();
    }

    public void PaperClick(View view)
    {
        humanI.setImageResource(R.drawable.paper);
        String message = turn("paper");
        Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
        tvS.setText("You: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(CompScore));
        GameResult();
    }

    public void ScissorsClick(View view)
    {
        humanI.setImageResource(R.drawable.scissor);
        String message = turn("scissors");
        Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
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
            return "Rock wins! Point for you.";
        } else if (a == "rock" && b == "paper") {
            CompScore++;
            return "Paper wins! Point for the computer.";
        } else if (a == "scissors" && b == "rock") {
            CompScore++;
            return "Rock wins! Point for the computer.";
        } else if (a == "scissors" && b == "paper") {
            HumanScore++;
            return "Scissors win! Point for you.";
        } else if (a == "paper" && b == "rock") {
            HumanScore++;
            return "Paper wins! Point for you.";
        } else if (a == "paper" && b == "scissors") {
            CompScore++;
            return "Scissors win! Point for the computer.";
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
            startActivity(intent);
        }
        if(CompScore == 10)
        {
            Intent intent = new Intent(this, PostGame.class);
            intent.putExtra("result", "You lost! L + ratio");
            startActivity(intent);
        }
    }
}