package com.example.homework3;

import androidx.annotation.NonNull;
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
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button button1;
    private Button button2;
    private TextView fio;
    private TextView vozrast;
    public ArrayList<Object> itog;
    public First f;
    private static final String TAG = "my App";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init1();
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void init1() {
        button1 = findViewById(R.id.saveBtn);
        button2 = findViewById(R.id.next);
        fio = findViewById(R.id.fio2);
        vozrast = findViewById(R.id.Vozrast2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                try {
                    String fio3 = fio.getText().toString();
                    String vozrast3 = vozrast.getText().toString();
                    int age2 = Integer.parseInt(vozrast3);
                    f = new First(fio3, age2);
                    itog = new ArrayList<>();
                    itog.add(f);
                } catch (Exception e) {
                    System.out.println("Введено неверное значение");
                }
                Toast toast1 = Toast.makeText(getApplicationContext(), getString(R.string.forSaveBtn), Toast.LENGTH_LONG);
                toast1.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку далее");
                Intent intent = new Intent(getApplicationContext(), Pressure.class);
                intent.putExtra("firstObject", itog);
                startActivity(intent);
            }
        });
    }
}

class First implements Serializable {
    String name;
    int age;

    First(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Object getName() {
        return name;
    }

    public Object getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ФИО: " + name +
                "\n" + "Возраст: " + age +
                "\n";
    }
}
