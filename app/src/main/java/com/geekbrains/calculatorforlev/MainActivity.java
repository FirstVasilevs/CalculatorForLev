package com.geekbrains.calculatorforlev;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView tvResult;
    private TextView tvHistory;
    private static final String CALCULATOR_IN_BUNDLE = "CALCULATOR_IN_BUNDLE";

    public MainActivity(Calculator calculator, TextView tvResult, TextView tvHistory) {
        this.calculator = calculator;
        this.tvResult = tvResult;
        this.tvHistory = tvHistory;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setOnClickListener();
    }

    private void setOnClickListener() {

        findViewById(R.id.button_reset).setOnClickListener(view -> doOperation("reset"));
        findViewById(R.id.button_erase).setOnClickListener(view -> doOperation("erase"));
        findViewById(R.id.button_equal).setOnClickListener(view -> doOperation("equal"));
        findViewById(R.id.button_dot).setOnClickListener(view -> doOperation("dot"));
        findViewById(R.id.button_plus).setOnClickListener(view -> doOperation("addition"));
        findViewById(R.id.button_minus).setOnClickListener(view -> doOperation("subtraction"));
        findViewById(R.id.button_div).setOnClickListener(view -> doOperation("division"));
        findViewById(R.id.button_mult).setOnClickListener(view -> doOperation("multiplication"));
        findViewById(R.id.button_percent).setOnClickListener(view -> doOperation("percent"));

        findViewById(R.id.button_0).setOnClickListener(view -> numberButtonClick("0"));
        findViewById(R.id.button_1).setOnClickListener(view -> numberButtonClick("1"));
        findViewById(R.id.button_2).setOnClickListener(view -> numberButtonClick("2"));
        findViewById(R.id.button_3).setOnClickListener(view -> numberButtonClick("3"));
        findViewById(R.id.button_4).setOnClickListener(view -> numberButtonClick("4"));
        findViewById(R.id.button_5).setOnClickListener(view -> numberButtonClick("5"));
        findViewById(R.id.button_6).setOnClickListener(view -> numberButtonClick("6"));
        findViewById(R.id.button_7).setOnClickListener(view -> numberButtonClick("7"));
        findViewById(R.id.button_8).setOnClickListener(view -> numberButtonClick("8"));
        findViewById(R.id.button_9).setOnClickListener(view -> numberButtonClick("9"));
        findViewById(R.id.button_twoZero).setOnClickListener(view -> numberButtonClick("00"));


    }

    private void numberButtonClick(String currentSymbol) {
        calculator.addSymbol(currentSymbol);
        tvResult.setText(calculator.getValue());

    }

    private void doOperation(final String operation) {

        switch (operation) {
            case "reset":
                calculator.reset();
                break;
            case "erase":
                calculator.erase();
                break;
            case "equal":
                calculator.equal();
                break;
            case "addition":
                calculator.addition();
                break;
            case "subtraction":
                calculator.subtraction();
                break;
            case "division":
                calculator.division();
                break;
            case "multiplication":
                calculator.multiplication();
                break;
            case "dot":
                calculator.dot();
                tvResult.setText(calculator.getValue());
                return;
        }
        tvResult.setText(calculator.getValue());
        tvHistory.setText(calculator.getHistoryString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CALCULATOR_IN_BUNDLE,calculator);
    }
}