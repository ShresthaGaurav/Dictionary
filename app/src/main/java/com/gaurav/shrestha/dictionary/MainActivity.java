package com.gaurav.shrestha.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView LoadingD;
private ProgressBar ProBar;
private Handler handler = new Handler();
int initialPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadingD =findViewById(R.id.tv);
        ProBar=findViewById(R.id.prob);
        RunProBar();
    }
    public void RunProBar(){
        initialPoint=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (initialPoint<100){
                    initialPoint+=10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ProBar.setProgress(initialPoint);
                            LoadingD.setText("Loading completed " + initialPoint + "%");
                        }});
                try{
                    Thread.sleep(200);

                        } catch (InterruptedException i){
                    i.printStackTrace();
                    }if(initialPoint>=100){
                    Stop();

                    }

                }

            }
        }).start();

    }

    private void Stop() {

        Intent intent= new Intent(MainActivity.this,WindowofDictionary.class);
        startActivity(intent);
        finish();

    }


}
