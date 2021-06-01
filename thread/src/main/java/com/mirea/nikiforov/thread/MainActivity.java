package com.mirea.nikiforov.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float sred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoTextView = findViewById(R.id.textResult);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
// Меняем имя и выводим в текстовом поле
        mainThread.setName("MireaThread");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
    }

    public void onClickCount(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                EditText days =(EditText) findViewById(R.id.editDays);
                float fDays = Float.parseFloat(days.getText().toString());
                EditText couples =(EditText) findViewById(R.id.editCouples);
                float fCouples = Float.parseFloat(couples.getText().toString());
                sred = fCouples / fDays;
                TextView result = findViewById(R.id.textResult);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(String.valueOf(sred));
                    }
                });
            }
        }).start();
    }

}
