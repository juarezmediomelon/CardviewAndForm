package com.mediomelon.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FormularioActivity extends AppCompatActivity {

    TextInputLayout layoutUsername;
    TextInputLayout layoutPassword;
    TextInputEditText txtUsername;
    TextInputEditText txtPassword;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        setToolbar();
        layoutUsername = findViewById(R.id.username_layout);
        layoutPassword = findViewById(R.id.password_layout);
        txtUsername = findViewById(R.id.username_text);
        txtPassword = findViewById(R.id.password_text);
        btnValidar = findViewById(R.id.btn_valid);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtUsername.getText().toString().isEmpty()){
                    layoutUsername.setError("correo electronico requerido");
                }else{
                    layoutUsername.setError(null);
                }
                if(txtPassword.getText().toString().isEmpty() || txtPassword.getText().toString().length() <= 6){
                    layoutPassword.setError("la contraseña debe tener al menos 6 caracteres");
                }else{
                    layoutPassword.setError(null);
                }
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

        toolbarArrow.setVisibility(View.VISIBLE); //muestra flecha hacia atras
        //toolbarLogo.setVisibility(View.VISIBLE);  //mostrar Logo
        toolbarTitle.setVisibility(View.VISIBLE);   //mostrar titulo
        toolbarTitle.setText("Mis Formularios");        //configurar titulo personalizado

        //click toolbar arrow back
        toolbarArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "atras", Toast.LENGTH_SHORT).show();
                //modifica la logica dependiendo de tu necesidad
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
