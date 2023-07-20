package com.androidappcoding.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button restart;
    int cound = 0;
    TextToSpeech textToSpeech;

    private ImageView imageView;
    private boolean ison = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        textView = findViewById(R.id.textView);
        restart = findViewById(R.id.restart);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.CANADA);
                }

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.click);
                mediaPlayer.start();

//                Random rnd = new Random();
//                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//                textView.setBackgroundColor(color);


                if (ison == true){
                    cound++;
                    textView.setText(""+cound);
                    imageView.setImageResource(R.drawable.offditle);
                    ison = false;
                }else {
                    cound++;
                    textView.setText(""+cound);
                    imageView.setImageResource(R.drawable.dijitalashbi);
                    ison = true;
                }

            }
        });



        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cound = 0;
                textView.setText(""+cound);
                textToSpeech.speak("restart"+textView.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });





    }
}