package com.dm.thanks.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.dm.thanks.Adapter.Solicitation;
import com.dm.thanks.MainActivity;
import com.dm.thanks.R;

public class Solicitations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitations_user);

        ImageView button_logout = findViewById(R.id.button_logout);
        ListView list_solicitations = findViewById(R.id.list_solicitations);
        Solicitation solicitation = new Solicitation(this);
        list_solicitations.setAdapter(solicitation);

        solicitation.add(new com.dm.thanks.Model.Solicitation("Natal solidario", "Realizar um natal solidário a crianças carentes.", "teste", "350.00", "150.00", 1));

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Intent intent = new Intent(Solicitations.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}