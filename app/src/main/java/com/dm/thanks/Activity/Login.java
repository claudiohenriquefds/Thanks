package com.dm.thanks.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.checkEmailExists(input_email.getText().toString())){
                    Toast.makeText(Login.this, "Usuário existe", Toast.LENGTH_SHORT).show();
                    if(user.checkUserPassword(input_email.getText().toString(), input_password.getText().toString())){
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putInt("user_id", user.getUser(input_email.getText().toString(), input_password.getText().toString())));
                        Intent intent = new Intent(Login.this, Solicitations.class);
                        startActivity(intent);
                        finish();
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
}