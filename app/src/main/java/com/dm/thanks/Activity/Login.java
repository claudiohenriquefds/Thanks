package com.dm.thanks.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dm.thanks.Dao.User;
import com.dm.thanks.R;

public class Login extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText input_email = findViewById(R.id.input_email);
        EditText input_password = findViewById(R.id.input_password);
        Button button_signin = findViewById(R.id.button_signin);
        TextView button_signup = findViewById(R.id.button_signup);

        User user = new User(this);
        user.createAdmin();

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.checkEmailExists(input_email.getText().toString())){
                    if(user.checkUserPassword(input_email.getText().toString(), input_password.getText().toString())){
                        com.dm.thanks.Model.User userModel = user.get(input_email.getText().toString(), input_password.getText().toString());

                        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("user_id", userModel.getId());
                        editor.putInt("level_access", userModel.getLevel_access());
                        editor.commit();

                        levelAcess(userModel.getLevel_access());
                    }else{
                        Toast.makeText(Login.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Login.this, "Esse email não existe", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    public void levelAcess(int level_access){
        if(level_access == 1){
            Intent intent = new Intent(Login.this, Solicitations.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(Login.this, Solicitations.class);
            startActivity(intent);
            finish();
        }
    }
}