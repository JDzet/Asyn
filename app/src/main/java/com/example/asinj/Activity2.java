package com.example.asinj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button back = findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Run(View view) {
        EditText oneTask = findViewById(R.id.editTextOneTask);
        EditText twoTask = findViewById(R.id.editTextTwoTask);

        String first = oneTask.getText().toString();
        String second = twoTask.getText().toString();

        TextView output = findViewById(R.id.textViewOutput);
        output.setText("");

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_LONG);
            return;
        }

        Asyn firstTask = new Asyn(output);
        firstTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1, Integer.parseInt(first));

        Asyn secondTask = new Asyn(output);
        secondTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 2, Integer.parseInt(second));
    }
}