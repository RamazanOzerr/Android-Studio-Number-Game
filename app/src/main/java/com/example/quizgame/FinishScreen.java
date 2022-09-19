package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class FinishScreen extends AppCompatActivity {

    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        img = (ImageView) findViewById(R.id.imgDemo);
        btn = (Button) findViewById(R.id.button);

        Random random = new Random();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rNum = random.nextInt(6);
                Toast toast = Toast.makeText(getApplicationContext(),"random: "+String.valueOf(rNum),Toast.LENGTH_SHORT);
                toast.show();
                if(rNum == 0)
                    img.setImageResource(R.drawable.win1);
                else if(rNum == 1)
                    img.setImageResource(R.drawable.win2);
                else if(rNum == 2)
                    img.setImageResource(R.drawable.win3);
                else if(rNum == 3)
                    img.setImageResource(R.drawable.win4);
                else if(rNum == 4)
                    img.setImageResource(R.drawable.win5);
                else img.setImageResource(R.drawable.win6);
//                switch (rNum){
//                    case 0:
//                        img.setImageResource(R.drawable.win1);
//                    case 1:
//                        img.setImageResource(R.drawable.win2);
//                    case 2:
//                        img.setImageResource(R.drawable.win3);
//                    case 3:
//                        img.setImageResource(R.drawable.win4);
//                    case 4:
//                        img.setImageResource(R.drawable.win5);
//                    case 5:
//                        img.setImageResource(R.drawable.win6);
//                }
            }
        });



    }
}