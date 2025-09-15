package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public enum CalculateStates{
        Add,
        Subtract,
        Multiply,
        Divide

    }
    void calculate(CalculateStates state) {
        Double d1 = 0.0;
        Double d2 = 0.0;
        Double answer = 0.0;

        EditText textN1 = (EditText) findViewById(R.id.editTextN1);
        EditText textN2 = (EditText) findViewById(R.id.editTextN2);
        // we actually don't need to get ans from screen
        EditText textANS = (EditText) findViewById(R.id.editTextNumAns);

        try {
            d1 = Double.parseDouble(textN1.getText().toString());
            d2 = Double.parseDouble(textN2.getText().toString());

            if (state == CalculateStates.Add) {
                answer = d1 + d2;

            } else if (state == CalculateStates.Subtract) {
                answer = d1 - d2;

            } else if (state == CalculateStates.Multiply) {
                answer = d1 * d2;

            } else if (state == CalculateStates.Divide) {
                answer = d1 / d2;
            }

        }

        catch (Exception e) {
            Log.w("M01_Calculator ADD BUTTON", "Add Selected with no inputs ... " + answer);
        }

        // Set the Answer into the the answer field
        textANS.setText(answer.toString());

        // log what we are doing
        Log.w("M01_Calculator ADD BUTTON", "Add Selected with => " + d1 + " + " + d2 + "=" + answer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.b_Add);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate(CalculateStates.Add);
            }
        });

        Button subtractButton = (Button) findViewById(R.id.b_Subtract);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate(CalculateStates.Subtract);
            }
        });

        Button multiplyButton = (Button) findViewById(R.id.b_Multiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate(CalculateStates.Multiply);
            }
        });

        Button divideButton = (Button) findViewById(R.id.b_Divide);
        divideButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate(CalculateStates.Divide);
            }
        });
    }

}
