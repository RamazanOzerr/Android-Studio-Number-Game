package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editTextMin, editTextMax, editTextLength;
    Button btnSave, btnStart, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        btnInfo = (Button) findViewById(R.id.btnRules);
        btnStart = (Button) findViewById(R.id.btnStart);
        editTextLength = (EditText) findViewById(R.id.editTextNumber4);
        editTextMax = (EditText) findViewById(R.id.editTextNumber3);
        editTextMin = (EditText) findViewById(R.id.editTextNumber2);

        // GAME SCREEN WILL BE DISPLAYED
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                openGameScreen();
                int min, max, length;
                if(!editTextMin.getText().toString().equals("")){
                    min = Integer.parseInt(editTextMin.getText().toString());
                }else{
                    min = 0;
                }
                if(!editTextMax.getText().toString().equals("")){
                    max = Integer.parseInt(editTextMax.getText().toString());
                }else{
                    max = 10;
                }
                if(!editTextLength.getText().toString().equals("")){
                    length = Integer.parseInt(editTextLength.getText().toString());
                }else{
                    length = 10;
                }

                Intent intent = new Intent(getApplicationContext(),MainScreennActivity.class);
                intent.putExtra("MAX",max);
                intent.putExtra("MIN",min);
                intent.putExtra("LENGTH",length);
                startActivity(intent);
            }
        });


        // GAME RULES HAVE BEEN SHOWED
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRules();
            }
        });
    }

    public void showRules(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }


}
