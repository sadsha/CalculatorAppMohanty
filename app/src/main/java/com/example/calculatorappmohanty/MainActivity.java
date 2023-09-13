package com.example.calculatorappmohanty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Double num1 = 0.0;
    public static Double num2 = 0.0;
    public static Double answer = 0.0;
    public static String operation = "", text = "";
    public static boolean first = true, second = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clear(View v){
        TextView display = findViewById(R.id.display);
        display.setText("");
        num1 = 0.0;
        num2 = 0.0;
        answer = 0.0;
        operation = "";
        first = true;
        second = true;
    }

    public String setNum(int num){
        if (first){
            num1 = num1*10+num;
            return ""+num1;
        }
        else {
            if (operation.equals("!")){
                return ""+num1+operation;
            } else {
                num2 = num2*10+num;
                return ""+num1+operation+num2;
            }
        }
    }
    public void addNumber(View v){
        TextView display = findViewById(R.id.display);
        Button btn = findViewById(v.getId());
        String num = btn.getText().toString();
    //https://stackoverflow.com/questions/5620772/get-text-from-pressed-button
        int value = Integer.valueOf(num);

        display.setText(setNum(value));
    }
    public void operation(View v){
        TextView display = findViewById(R.id.display);
        Button btn = findViewById(v.getId());
        if (num1 == 0.0){
            display.setText(getString(R.string.missing_value));
    //https://stackoverflow.com/questions/7213924/access-string-xml-resource-file-from-java-android-code
        }
        else if (operation.equals("")){
            operation = btn.getText().toString();
            display.setText(""+num1+operation);
            first = false;
        }

    }
    public void equals(View v){
        String output = "";

        if (operation.equals("^")){
            answer = 1.0;
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
            answer = num1-num2;
        }
        else if (operation.equals("+")) {
            answer = num1+num2;
        }
        else if (operation.equals("!")) {
            answer = 1.0;
            for (int i = 1; i <= num1; i++) {
                answer*=i;
            }
        }
        output =  ""+answer;
        if (operation.equals("")){
            output = getString(R.string.incomplete_equation);
        }
        TextView display = findViewById(R.id.display);
        display.setText(output);
        num1 = answer;
        num2 = 0.0;
        answer = 0.0;
        operation = "";
        first = true;
        second = true;
    }
}