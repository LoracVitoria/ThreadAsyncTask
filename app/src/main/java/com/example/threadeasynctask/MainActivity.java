package com.example.threadeasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProcessar;
    private TextView txtStatus;
    private TextView txtContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProcessar = findViewById(R.id.btnProcessar);
        txtStatus = findViewById(R.id.txtStatus);
        txtContador = findViewById(R.id.txtContador);

        btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ProcessarTask task = new ProcessarTask(btnProcessar,txtStatus,txtContador);
        task.execute(10);
    }
}