package com.example.cashgre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLaunchActivity = findViewById(R.id.buttonIngresar);
        btnLaunchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to launch the TargetActivity
                Intent intent = new Intent(MainActivity.this, InstruccionesActivity.class);
                startActivity(intent);
            }
        });

        Button btnLaunchRegisterActivity = findViewById(R.id.btnRegistro);
        btnLaunchRegisterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to launch the TargetActivity
                Intent intent = new Intent(MainActivity.this, RegistroUsuarioActivity.class);
                startActivity(intent);
            }
        });

        Button btnLaunchRecoverPasswordActivity = findViewById(R.id.btnPassword);
        btnLaunchRecoverPasswordActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to launch the TargetActivity
                Intent intent = new Intent(MainActivity.this, RecuperarContrasenaActivity.class);
                startActivity(intent);
            }
        });
    }
}