package com.dm.thanks.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dm.thanks.Dao.User;
import com.dm.thanks.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText input_name = findViewById(R.id.input_name);
        EditText input_email = findViewById(R.id.input_email);
        EditText input_password = findViewById(R.id.input_password);
        Button button_signup = findViewById(R.id.button_signup);

        User user = new User(this);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_email.getText().equals("") || !input_name.getText().equals("") || !input_password.getText().equals("")){
                    if(!user.checkEmailExists(input_email.getText().toString())){
                        if(user.add(input_name.getText().toString(), input_email.getText().toString(), input_password.getText().toString())){
                            Toast.makeText(Register.this, "Conta cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Solicitations.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(Register.this, "Não foi possivel cadastrar a conta", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Usuário já existe", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Por favor, preencha os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}