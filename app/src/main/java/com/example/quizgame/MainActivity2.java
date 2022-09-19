package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.button10);
        txt = findViewById(R.id.textRules);

        txt.setText("WE WILL WRITE THE GAME RULES HERE");
        txt.setText("NUMBER GAME\n" +
                "Some numbers will display on the screen when you click on the next button\n" +
                "and you'll be supposed to enter them in that order\n" +
                "there are 3 section on the main screen, you can select game rules\n" +
                "FIRST SECTION: The number of numbers which will be display on the screen\n" +
                "SECOND SECTION: Max number which will be display on the screen\n" +
                "THIRD SECTION: Min number which will be display on the screen\n" +
                "SAVE BUTTON: when you click it, settings will be saved and game will start\n" +
                "SHOW RULES BUTTON: you already know what it is for :D\n" +
                "START BUTTON: Opens the game with default settings\n" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "");



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameScreen();

            }
        });
    }
    public void openGameScreen(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}