package com.example.exasynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {
    Button btnProcessar;
    TextView txtStatus;
    TextView txtContador;

    public ProcessarTask(Button btnProcessar, TextView txtStatus, TextView txtContador) {
        this.btnProcessar = btnProcessar;
        this.txtStatus = txtStatus;
        this.txtContador = txtContador;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        txtStatus.setVisibility(View.INVISIBLE);
        txtContador.setVisibility(View.VISIBLE);
        txtContador.setText("10");
    }

    @Override
    protected void onPostExecute(Void unused) {
        btnProcessar.setEnabled(true);
        txtStatus.setText(R.string.finalizado);
        txtStatus.setVisibility(View.VISIBLE);
        txtContador.setVisibility(View.INVISIBLE);
    }

//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        int p = values[0];
//        pgbProgresso.setProgress(p);
//    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for(int i=0; i<=max; i++){
            txtContador.setText(max--);
            SystemClock.sleep(1000);
            publishProgress(i);
        }
        return null;
    }
}
