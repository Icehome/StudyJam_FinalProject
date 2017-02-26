package com.studyjame.finalprojectforstudyjam.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_push_me).setOnClickListener(this);
        findViewById(R.id.btn_map).setOnClickListener(this);
        findViewById(R.id.btn_call_me).setOnClickListener(this);
        findViewById(R.id.btn_web).setOnClickListener(this);
        findViewById(R.id.btn_email).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_push_me:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Дякуємо з довіру :)", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.btn_map:
                String geoUriString = "geo:49.4449307,32.0652663,15z";
                Uri geo = Uri.parse(geoUriString);
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoIntent);
                break;
            case R.id.btn_call_me:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+38063 404 2325"));
                startActivity(intent);
                break;
            case R.id.btn_web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/klouny_ck_ua"));
                startActivity(intent);
                break;
            case R.id.btn_email:
                Intent emailIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"icehome.ck@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ваше питання");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Суть вашого звернення чи питання...");
                startActivity(emailIntent);
                break;
        }

    }
}