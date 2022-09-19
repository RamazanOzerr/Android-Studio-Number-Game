package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainScreennActivity extends AppCompatActivity {

    TextView textViewNum;
    EditText editText;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btn0, btnAyn, btnEnter, btnNext,btnBack;
    String enterText = "";
    ImageView img;
    int buttonType;
    int i = -1;  // Counter that we use while showing numbers and checking answers
    Boolean isStarted = false; // checks if all the numbers have been shown(returns true)
    int point = 0;
    int counter = 0;
    int maxNum;
    int minNum;
    int numLength;
    int[] numArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        maxNum = intent.getIntExtra("MAX",10);
        minNum = intent.getIntExtra("MIN",0);
        numLength = intent.getIntExtra("LENGTH",10);

        numArray = new int[numLength];

        textViewNum = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextNumber);
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnAyn = (Button) findViewById(R.id.buttonAyn);
        btnEnter = (Button) findViewById(R.id.buttonEnter);
        btnNext = (Button) findViewById(R.id.buttonNext);
        btnBack = (Button) findViewById(R.id.buttonBack);
        img = (ImageView) findViewById(R.id.imageView);

        createRandomNums();  // RANDOM NUMBERS HAVE BEEN CREATED AND ADDED TO THE ARRAY
        FirstPartvisibility();

        btnAyn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 0;
                pressButton();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 1;
                pressButton();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 2;
                pressButton();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 3;
                pressButton();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 4;
                pressButton();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 5;
                pressButton();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 6;
                pressButton();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 7;
                pressButton();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 8;
                pressButton();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = 9;
                pressButton();
            }
        });

        // bu butonu, yazılan yazıyı silmekte kullanıcaz
        btnAyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = -2;
                pressButton();
            }
        });

        // enter tuşuna basıcak ve gereken kontrolleri yapacak
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonType = -1;
                pressButton();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isStarted){
                    displayNumber();
                    counter++;
                }
                if (counter == (numLength+1)){ // burayı +1 yaptık çünkü, next de isStarted true
                    secondPartVisibility();    // dönmesi için bir kere daha next e basmamız gerekiyor

                }                              // sonra düzeltiriz, şimdilik kalsın böyle
            }
        });
    }

    public void pressButton(){
        if(buttonType == 0){
            enterText += "0";
            editText.setText(enterText);}

        else if(buttonType == 1){
            enterText += "1";
            editText.setText(enterText);}

        else if(buttonType == 2){
            enterText += "2";
            editText.setText(enterText);}

        else if(buttonType == 3){
            enterText += "3";
            editText.setText(enterText);}

        else if(buttonType == 4){
            enterText += "4";
            editText.setText(enterText);}

        else if(buttonType == 5){
            enterText += "5";
            editText.setText(enterText);}

        else if(buttonType == 6){
            enterText += "6";
            editText.setText(enterText);}

        else if(buttonType == 7){
            enterText += "7";
            editText.setText(enterText);}

        else if(buttonType == 8){
            enterText += "8";
            editText.setText(enterText);}

        else if(buttonType == 9){
            enterText += "9";
            editText.setText(enterText);
        }

        // ENTER
        else if(buttonType == -1){
            if (!isStarted){  // BEFORE GAME STARTS
                enterText = "";
                editText.setText(enterText);

            }else if(isStarted){  // AFTER GAME STARTS

                Boolean flag = checkResult();

                if(flag){
                    point += 10;
//                    textViewNum.setHeight(100);
//                    textViewNum.setWidth(300);
                    textViewNum.setText("YOUR POINT: "+String.valueOf(point));
                    Toast toast = Toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 10, 10);
                    toast.show();
                    enterText = "";
                    editText.setText(enterText); // her dogru cevaptan sonra ekran oto sıfırlanacak
                    if(point == (numLength*10)){

                        // RANDOM YOU WIN IMAGE WILL BE SHOWN
                        Random random = new Random();
                        int rNum = random.nextInt(6);
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

                        img.setVisibility(View.VISIBLE);
                        finalPartVisibility();
                    }
                }else if(!flag){
                    Toast toast = Toast.makeText(getApplicationContext(), "GAME OVER, YOUR POINT: "+String.valueOf(point), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 10, 10);
                    toast.show();

                    // RANDOM GAME OVER IMAGE WILL BE SHOWN
                    Random random = new Random();
                    int rNum = random.nextInt(6);

                    if(rNum == 0)
                        img.setImageResource(R.drawable.gameover1);
                    else if(rNum == 1)
                        img.setImageResource(R.drawable.gameover2);
                    else if(rNum == 2)
                        img.setImageResource(R.drawable.gameover3);
                    else if(rNum == 3)
                        img.setImageResource(R.drawable.gameover4);
                    else if(rNum == 4)
                        img.setImageResource(R.drawable.gameover5);
                    else img.setImageResource(R.drawable.gameover6);
//
                    img.setVisibility(View.VISIBLE);
                    finalPartVisibility();
                }
            }
        }
        // Delete
        else if(buttonType == -2){

            if(enterText.equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "NO TEXT TO DELETE ON THE SCREEN", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 10, 10);
                toast.show();
            }
            enterText = "";
            editText.setText(enterText);

        }
    }

    // CREATES RANDOM NUMBERS AND ADDS THEM TO THE ARRAY
    public void createRandomNums(){

            int prevNum = -1;
            // random numbers have been created
            Random random = new Random();
            for (int i = 0; i<numLength; i++){
                int randomNum = random.nextInt(maxNum-minNum)+minNum;

                // IT WON'T CREATE SAME NUMBER BACK TO BACK
                while (randomNum == prevNum){
                    randomNum = random.nextInt(maxNum);
                }
                prevNum = randomNum;
                numArray[i] = randomNum;
            }
    }

    // ADD A NUMBER TO THE TEXT FIELD, IF AN ERROR OCCURS, IT SHOWS A TOAST MESSAGE SAYS
    // "OUT OF NUMBER" AND STARTS THE GAME
    public void displayNumber(){
        i++;
        try{
            textViewNum.setText(String.valueOf(numArray[i]));
        }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(), "ALL NUMBERS HAVE BEEN SHOWN", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 10, 10);
            toast.show();
            i = -1; // cevapları kontrolde i yi yeniden kullanmak üzere sıfırlıyoruz
            isStarted = true;
        }
    }

    // CHECKS AND IF IT'S TRUE RETURNS TRUE, OTHERWISE FALSE
    public Boolean checkResult(){

        i++;
        int answer = Integer.parseInt(editText.getText().toString());
        if (answer == numArray[i])
            return true;

        return false;
}
    public void FirstPartvisibility(){
        btnAyn.setVisibility(View.GONE);
        btnEnter.setVisibility(View.GONE);
        btn0.setVisibility(View.GONE);
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);
        btn9.setVisibility(View.GONE);
        editText.setVisibility(View.GONE);
    }
    public void secondPartVisibility(){
        btnAyn.setVisibility(View.VISIBLE);
        btnEnter.setVisibility(View.VISIBLE);
        btn0.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
        btn9.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.GONE);
    }
    public void finalPartVisibility(){
        btnAyn.setVisibility(View.GONE);
        btnEnter.setVisibility(View.GONE);
        btn0.setVisibility(View.GONE);
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);
        btn9.setVisibility(View.GONE);
        editText.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        textViewNum.setVisibility(View.GONE);
    }

}