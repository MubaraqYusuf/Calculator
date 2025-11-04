package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtDisplay;
    private double first = 0.0, second = 0.0, memory = 0.0;
    private String op = null;
    private boolean replaceNext = true;
    private final DecimalFormat fmt = new DecimalFormat("0.############");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);
    }

    // Digits and Dot
    public void onDigitClick(View v) {
        String d = ((Button) v).getText().toString();
        String cur = txtDisplay.getText().toString();

        if (replaceNext) {
            txtDisplay.setText(d.equals(".") ? "0." : d);
            replaceNext = false;
            return;
        }

        if (d.equals(".") && cur.contains(".")) return;
        if (cur.equals("0") && !d.equals(".")) txtDisplay.setText(d);
        else txtDisplay.setText(cur + d);
    }

    // Operators (+, −, ×, ÷, √)
    public void onOpClick(View v) {
        String symbol = ((Button) v).getText().toString();
        double val = getVal();

        if (symbol.equals("√")) {
            if (val < 0) {
                txtDisplay.setText("Error");
            } else txtDisplay.setText(fmt.format(Math.sqrt(val)));
            replaceNext = true;
            return;
        }

        first = val;
        op = symbol;
        replaceNext = true;
    }

    // Equal =
    public void onEqClick(View v) {
        if (op == null) return;
        second = getVal();
        double res = 0.0;

        switch (op) {
            case "+": res = first + second; break;
            case "−": res = first - second; break;
            case "×": res = first * second; break;
            case "÷":
                if (second == 0) {
                    txtDisplay.setText("Error");
                    op = null;
                    replaceNext = true;
                    return;
                }
                res = first / second; break;
        }
        txtDisplay.setText(fmt.format(res));
        first = res;
        op = null;
        replaceNext = true;
    }

    // Controls: Back, Clear, Sign
    public void onControlClick(View v) {
        int id = v.getId();
        String cur = txtDisplay.getText().toString();

        if (id == R.id.btnBack) {
            if (cur.length() > 1) txtDisplay.setText(cur.substring(0, cur.length() - 1));
            else txtDisplay.setText("0");
        } else if (id == R.id.btnClear) {
            txtDisplay.setText("0");
            first = second = 0.0; op = null;
            replaceNext = true;
        } else if (id == R.id.btnSign) {
            if (cur.equals("0") || cur.equals("Error")) return;
            txtDisplay.setText(cur.startsWith("-") ? cur.substring(1) : "-" + cur);
        }
    }

    // Memory Buttons
    public void onMemoryClick(View v) {
        int id = v.getId();
        double cur = getVal();

        if (id == R.id.btnMC) memory = 0.0;
        else if (id == R.id.btnMR) {
            txtDisplay.setText(fmt.format(memory));
            replaceNext = true;
        } else if (id == R.id.btnMPlus) memory += cur;
        else if (id == R.id.btnMMinus) memory -= cur;
    }

    private double getVal() {
        try { return Double.parseDouble(txtDisplay.getText().toString()); }
        catch (Exception e) { return 0.0; }
    }
}
