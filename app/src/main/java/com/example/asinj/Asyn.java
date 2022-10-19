package com.example.asinj;

import android.os.AsyncTask;
import android.widget.TextView;

public class Asyn extends AsyncTask<Integer, String, String> {

    TextView text;

    public Asyn(TextView text) {this.text = text;}

    @Override
    protected String doInBackground(Integer... integers) {
        if (integers.length < 2) {
            return "Введите данные";
        }
        for (int i = 1; i <= integers[1]; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
            publishProgress("задача " + integers[0] + " прошла " + i + " запрос");
        }
        return "Задача " + integers[0] + " успешно выполнена";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        text.setText(text.getText() + "\n" + values[0]);
    }

    @Override
    protected void  onPostExecute(String s) {text.setText(text.getText() + "\n" + s);}
}
