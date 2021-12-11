package com.example.squaresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Solve(View view) {
        EditText editTextA = findViewById(R.id.NameA);
        EditText editTextB = findViewById(R.id.NameB);
        EditText editTextC = findViewById(R.id.NameC);
        TextView result = findViewById(R.id.textViewResult);
        result.setText("");
        String strCoefA = editTextA.getText().toString();
        String strCoefB = editTextB.getText().toString();
        String strCoefC = editTextC.getText().toString();
        String patternNumber = "^([-]?[0-9]+([.]{1}[0-9]+)?)$";
        double coefA, coefB, coefC, discriminant, x1, x2;
        if (Pattern.matches(patternNumber, strCoefA)) {
            if (Pattern.matches(patternNumber, strCoefB)) {
                if (Pattern.matches(patternNumber, strCoefC)) {
                    coefA = Double.parseDouble(strCoefA);
                    coefB = Double.parseDouble(strCoefB);
                    coefC = Double.parseDouble(strCoefC);
                    result.append("Введено квадратное уравнение:\n");
                    result.append(coefA + "x²");
                    result.append((coefB < 0) ? " - " : " + ");
                    result.append(Math.abs(coefB) + "x");
                    result.append((coefC < 0) ? " - " : " + ");
                    result.append(Math.abs(coefC) + " = 0\n\n");
                    discriminant = coefB * coefB - 4 * coefA * coefC;
                    if (discriminant > 0) {
                        result.append("Уравнение имеет два корня:\n");
                        x1 = (-coefB + Math.sqrt(discriminant)) / (2 * coefA);
                        x2 = (-coefB - Math.sqrt(discriminant)) / (2 * coefA);
                        result.append("x₁ = " + x1 + "\n");
                        result.append("x₂ = " + x2 + "\n");
                    }
                    else if (discriminant == 0) {
                        result.append("Уравнение имеет один корень:\n");
                        x1 = -coefB / (2 * coefA);
                        result.append("x = " + x1 + "\n");
                    }
                    else if (discriminant < 0) {
                        result.append("Уравнение не имеет вещественных корней");
                    }
                } else {
                    result.append("Коэффициент С введен неправильно");
                }
            } else {
                result.append("Коэффициент В введен неправильно");
            }
        } else {
            result.append("Коэффициент А введен неправильно");
        }
    }
}