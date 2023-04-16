package com.eitsistemas.coordenadas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GRUPO5 extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView progressText;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_r_u_p_o5);
        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);

        Activity activity = GRUPO5.this;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               if(i <=100){
                   progressText.setText(""+i);
                   progressBar.setProgress(i);
                   i++;
                   handler.postDelayed(this,40);
                   if(i ==100){
                       Intent intent = new Intent(GRUPO5.this, MenuPrincipal.class);
                       activity.startActivity(intent);
                       finish();
                   }

               }

               else{
                   handler.removeCallbacks(this);
               }

            }

        },200);


    }
}