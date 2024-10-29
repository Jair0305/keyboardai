package com.jair.keyboardai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivarTeclado = findViewById(R.id.btnActivarTeclado);
        Button btnSeleccionarTeclado = findViewById(R.id.btnSeleccionarTeclado);
        Button btnConfiguracion = findViewById(R.id.btnConfiguracion);

        btnActivarTeclado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la configuración de teclados
                startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
                Toast.makeText(MainActivity.this, "Activa 'Mi Teclado' en la lista", Toast.LENGTH_LONG).show();
            }
        });

        btnSeleccionarTeclado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra el selector de método de entrada
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showInputMethodPicker();
                }
            }
        });

        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la configuración de idioma e ingreso
                startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS));
            }
        });
    }
}
