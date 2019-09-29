package com.mediomelon.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button goForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar(); //ADVERTENCIA por default el logo, el titulo y el boton atras estan ocultos

        //ver en que  variable de entorno nos encontramos
        TextView variableDeEntorno = findViewById(R.id.txtDevelopmentEnviroment);
        variableDeEntorno.setText(BuildConfig.BASE_URL);

        //ir a ejemplo de formulario
        goForm = findViewById(R.id.btnFormulario);
        goForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FormularioActivity.class);
                startActivity(intent);
            }
        });

    }
    //set Toolbar
    public void setToolbar() {
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        ImageView toolbarLogo = findViewById(R.id.toolbar_logo);
        Button toolbarArrow = findViewById(R.id.toolbar_arrow_back);
        Toolbar toolbar = findViewById(R.id.toolbar);   //bindeo de la vista
        setSupportActionBar(toolbar);           //soporte para versiones anteriores

        //toolbarArrow.setVisibility(View.VISIBLE); //muestra flecha hacia atras
        //toolbarLogo.setVisibility(View.VISIBLE);  //mostrar Logo
        toolbarTitle.setVisibility(View.VISIBLE);   //mostrar titulo
        toolbarTitle.setText("Mis Cuentas");        //configurar titulo personalizado

        //click toolbar arrow back
        toolbarArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "atras", Toast.LENGTH_SHORT).show();
                //modifica la logica dependiendo de tu necesidad
                finish();
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(intent);
            }
        });
    }
}
