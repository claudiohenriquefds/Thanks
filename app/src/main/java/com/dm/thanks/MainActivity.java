package com.dm.thanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.dm.thanks.Activity.Login;
import com.dm.thanks.Activity.Solicitations;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showLogin();
            }
        }, 2000);
    }

    protected void showLogin(){
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);

        if(sharedPreferences.getInt("user_id", 0) == 0){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(MainActivity.this, Solicitations.class);
            startActivity(intent);
            finish();
        }
    }
}