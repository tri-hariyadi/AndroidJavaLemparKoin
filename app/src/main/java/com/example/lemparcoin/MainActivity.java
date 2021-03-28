package com.example.lemparcoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Animation app_rotate;
    private ImageView LogoApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogoApp = (ImageView) findViewById(R.id.logo_coin);
        app_rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        LogoApp.startAnimation(app_rotate);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, LemparCoinActivity.class);
                startActivity(i);
                finish();
            }
        },2500);
    }
}