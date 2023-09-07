package com.example.calculatorappmohanty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static Integer num1 = null, num2 = null, answer = 0;
    public static String operation = "", text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static void operation(){
        if (num1 == null){
            text = "Please enter an operation";
        }
    }
    public static void equals(){
        if (operation.equals("^")){
            answer = 1;
            for (int i = 0; i < num2; i++) {
                answer*=num1;
            }
        }
        else if (operation.equals("%")) {
            answer = num1%num2;
        }
        else if (operation.equals("*")) {
            answer = num1*num2;
        }
        else if (operation.equals("/")) {
            answer = num1/num2;
        }
        else if (operation.equals("-")) {
            answer = num1%num2;
        }
        else if (operation.equals("+")) {
            answer = num1%num2;
        }
        text = ""+answer;

    }
}