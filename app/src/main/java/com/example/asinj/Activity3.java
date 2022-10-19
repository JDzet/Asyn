package com.example.asinj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button back = findViewById(R.id.buttonBackCommon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Run(View view) {
        EditText oneTask = findViewById(R.id.editTextOneTaskCommon);
        EditText twoTask = findViewById(R.id.editTextTwoTaskCommon);

        String first = oneTask.getText().toString();
        String second = twoTask.getText().toString();

        TextView output = findViewById(R.id.textViewOutputCommon);
        output.setText("");

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_LONG);
            return;
        }

        for (int i = 1; i < Integer.parseInt(first) + 1; i++) {
            output.setText(output.getText()+ "задача 1 прошла " + i + " запрос\n");
        }
        output.setText(output.getText()+"Задача 1 успешно выполнена\n");

        for (int i = 1; i < Integer.parseInt(second) + 1; i++) {
            output.setText(output.getText()+"задача 2 прошла " + i + " запрос\n");
        }
        output.setText(output.getText()+"Задача 2 успешно выполнена\n");
    }
}