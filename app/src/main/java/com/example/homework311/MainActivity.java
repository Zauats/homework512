package com.example.homework311;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // работает кривовато, но должно
    TextView field;
    String exText = "";
    String n1 = "";
    String n2 = "";
    char sign;
    double answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field = findViewById(R.id.field);
    }

    public void Click(View view) {
        Button button = (Button)view;
        field.setText(field.getText().toString() + button.getText().toString());
        exText += button.getText().toString();
    }

    public void engineeringClick(View view) {
        LinearLayout engineering = findViewById(R.id.engineering);
        engineering.setVisibility(View.VISIBLE);
    } 

    public void signClick(View view) {
        double num1 = 0;
        double num2 = 1;
        for (int i = 0; i < exText.length(); i++) {
            if (exText.charAt(i) == '+' | exText.charAt(i) == '-' | exText.charAt(i) == '*' | exText.charAt(i) == '/') {
                sign = exText.charAt(i);
                for (int j = 0; j < i; j++) {
                    n1 += (exText.charAt(j) + "");
                }
                for (int j = i + 1; j < exText.length(); j++) {
                    n2 += exText.charAt(j);
                }
                num1 = Double.parseDouble(n1);
                num2 = Double.parseDouble(n2);
            }

            if (sign == '/') {
                answer = num1 / num2;
                String strAnswer = Double.toString(answer);
                field.setText(strAnswer);
            } else if (sign == '*') {
                answer = num1 * num2;
                String strAnswer = Double.toString(answer);
                field.setText(strAnswer);
            } else if (sign == '-') {
                answer = num1 - num2;
                String strAnswer = Double.toString(answer);
                field.setText(strAnswer);
            } else if (sign == '+') {
                answer = num1 + num2;
                String strAnswer = Double.toString(answer);
                field.setText(strAnswer);
            }
        }
    }

    public void clearClick(View view) {
        field.setText("");
        exText = "";
        n1 = "";
        n2 = "";
    }
}
