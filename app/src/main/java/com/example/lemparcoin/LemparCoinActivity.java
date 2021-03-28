package com.example.lemparcoin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class LemparCoinActivity extends AppCompatActivity {
    private Button ButtonStart, ButtonRestart, ButtonExit;
    private TextView TextCoin;
    private ImageView ImageCoin;
    private LinearLayout WrapperButton;
    private Random randomThrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemparcoin);
        randomThrow = new Random();
        ButtonStart = (Button) findViewById(R.id.button);
        ButtonRestart = (Button) findViewById(R.id.ulang);
        ButtonExit = (Button) findViewById(R.id.exit);
        ImageCoin = (ImageView) findViewById(R.id.imageView);
        TextCoin = (TextView) findViewById(R.id.textView);
        WrapperButton = (LinearLayout) findViewById(R.id.layout_btn);

        ButtonStart.setOnClickListener(this::onClick);
        ButtonRestart.setOnClickListener(this::onBtnRestartClick);
        ButtonExit.setOnClickListener(this::onBtnExitClick);
    }

    private void onClick(View v) {
        if (randomThrow.nextDouble() > 0.5) {
            TextCoin.setText("Kepala");
            ImageCoin.setImageResource(R.drawable.head);
        } else {
            TextCoin.setText("Cross");
            ImageCoin.setImageResource(R.drawable.tail);
        }

        ButtonStart.setVisibility(v.INVISIBLE);
        WrapperButton.setVisibility(v.VISIBLE);
    }

    private void onBtnRestartClick(View v) {
        TextCoin.setText("");
        ImageCoin.setImageResource(R.drawable.question);
        ButtonStart.setVisibility(v.VISIBLE);
        WrapperButton.setVisibility(v.INVISIBLE);
    }

    private void onBtnExitClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LemparCoinActivity.this);
        builder.setTitle("Keluar Aplikasi");
        builder.setMessage("Yakin mau keluar Aplikasi.?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
