package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LolActivity extends AppCompatActivity {

    private Button button1save;
    private Button button2end;
    private TextView ves;
    private TextView steps;
    public ArrayList<Third> itog3;
    private static final String TAG3 = "my App3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lol);
        init3();
    }

    public void init3() {
        button1save = findViewById(R.id.saveBtn3);
        button2end = findViewById(R.id.result);
        ves = findViewById(R.id.VesNumber);
        steps = findViewById(R.id.ShagiNumber);
        button1save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG3, "Пользователь нажал кнопку сохранить");
                try {
                    String ves2 = ves.getText().toString();
                    double ves3 = Double.parseDouble(ves2);
                    String steps2 = steps.getText().toString();
                    int steps3 = Integer.parseInt(steps2);
                    Third t = new Third(ves3, steps3);
                    itog3 = new ArrayList<>();
                    itog3.add(t);
                } catch (Exception e3) {
                    System.out.println("Введено неверное значение");
                }
                Toast toast3 = Toast.makeText(getApplicationContext(), getString(R.string.forSaveBtn), Toast.LENGTH_LONG);
                toast3.show();
            }
        });

        button2end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG3, "Пользователь нажал кнопку выход");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });
    }
}

class Third {
    double ves;
    int steps;

    public Third(double ves, int steps) {
        this.ves = ves;
        this.steps = steps;
    }

    public double getVes() {
        return ves;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Вес: " + ves +
                "\n" + "Кол-во шагов: " + steps +
                "\n";
    }
}