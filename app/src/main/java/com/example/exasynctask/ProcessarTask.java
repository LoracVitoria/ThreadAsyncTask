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
    ProgressBar pgbProgresso;

    public ProcessarTask(Button btnProcessar, TextView txtStatus, ProgressBar pgbProgresso) {
        this.btnProcessar = btnProcessar;
        this.txtStatus = txtStatus;
        this.pgbProgresso = pgbProgresso;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        txtStatus.setVisibility(View.INVISIBLE);
        pgbProgresso.setVisibility(View.VISIBLE);
        pgbProgresso.setProgress(0);
    }

    @Override
    protected void onPostExecute(Void unused) {
        btnProcessar.setEnabled(true);
        txtStatus.setText(R.string.finalizado);
        txtStatus.setVisibility(View.VISIBLE);
        pgbProgresso.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int p = values[0];
        pgbProgresso.setProgress(p);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for(int i=0; i<=max; i++){
            SystemClock.sleep(1000);
            publishProgress(i);
        }
        return null;
    }
}
