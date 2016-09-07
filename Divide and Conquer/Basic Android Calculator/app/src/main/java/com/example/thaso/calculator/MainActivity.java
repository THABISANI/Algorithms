package com.example.thaso.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonAdd, buttonSubb, buttonMull, buttonDivv;
    private TextView answerDisplay;
    private EditText one, two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // MediaPlayer sibz = MediaPlayer.create(MainActivity.this, R.raw.intro);
       // sibz.start();
        init();
    }

    public void init() {
        buttonAdd = (Button) findViewById(R.id.buttonAd);
        buttonSubb = (Button) findViewById(R.id.buttonSub);
        buttonMull = (Button) findViewById(R.id.buttonMul);
        buttonDivv = (Button) findViewById(R.id.buttonDiv);


        one = (EditText) findViewById(R.id.firstNum);
        two = (EditText) findViewById(R.id.secondNum);
        answerDisplay = (TextView) findViewById(R.id.answerView);

        buttonAdd.setOnClickListener(this);
        buttonMull.setOnClickListener(this);
        buttonSubb.setOnClickListener(this);
        buttonDivv.setOnClickListener(this);


    }

    public void onClick(View view) {
        int num1 = Integer.parseInt(one.getText().toString());
        int num2 = Integer.parseInt(two.getText().toString());
        int answer = 0;
        switch (view.getId()) {

            case R.id.buttonAd:
                answer = num1 + num2;
                answerDisplay.setText(answer + "");
                break;
            case R.id.buttonSub:
                answer = num1 - num2;
                answerDisplay.setText(answer + "");
                break;
            case R.id.buttonMul:
                answer = num1 * num2;
                answerDisplay.setText(answer + "");
                break;
            case R.id.buttonDiv:
                try {
                    if (num2 == 0) {
                        buttonDivv.setBackgroundColor(Color.parseColor ("red"));
                        throw new Exception("Operation undefined!");
                    }
                    answer = num1 / num2;
                    answerDisplay.setText(answer + "");
                    break;
                } catch (Exception e) {
                    answerDisplay.setText(e.getMessage());
                }


        }
    }
}
