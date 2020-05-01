package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Pressure extends AppCompatActivity implements Serializable {

    private Button button2save;
    private Button button2next;
    private TextView upPressure;
    private TextView downPressure;
    private TextView puls;
    private TextView date;
    public ArrayList<Second> itog2;
    private static final String TAG2 = "my App2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        init2();
    }

    public void init2() {
        upPressure = findViewById(R.id.davlenieText);
        downPressure = findViewById(R.id.davlenieText2);
        puls = findViewById(R.id.pulsText);
        date = findViewById(R.id.DateText);
        button2save = findViewById(R.id.saveBtn2);
        button2next = findViewById(R.id.next2);
        button2save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG2, "Пользователь нажал кнопку сохранить");
                try {
                    String up = upPressure.getText().toString();
                    int up2 = Integer.parseInt(up);
                    String down = downPressure.getText().toString();
                    int down2 = Integer.parseInt(down);
                    String pulse = puls.getText().toString();
                    int pulse2 = Integer.parseInt(pulse);
                    String date2 = date.getText().toString();
                    Second s = new Second(up2, down2, pulse2, date2);
                    itog2 = new ArrayList<>();
                    itog2.add(s);
                } catch (Exception e2) {
                    System.out.println("Введено неверное значение");
                }
                Toast toast2 = Toast.makeText(getApplicationContext(), getString(R.string.forSaveBtn), Toast.LENGTH_LONG);
                toast2.show();
            }
        });

        button2next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG2, "Пользователь нажал кнопку далее");
                Intent intent2 = new Intent(getApplicationContext(), LolActivity.class);
                intent2.putExtra("firstObject", itog2);
                startActivity(intent2);
            }
        });
    }
}

class Second implements Serializable {
    int upPressure;
    int downPressure;
    int puls;
    String date;

    public Second(int upPressure, int downPressure, int puls, String date) {
        this.upPressure = upPressure;
        this.downPressure = downPressure;
        this.puls = puls;
        this.date = date;
    }

    public int getUpPressure() {
        return upPressure;
    }

    public int getDownPressure() {
        return downPressure;
    }

    public int getPuls() {
        return puls;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Верхнее давление: " + upPressure + "\n" +
                "Нижнее давление: " + downPressure + "\n" +
                "Пульс: " + puls + "\n" +
                "Дата замера: " + date + "\n";
    }
}