package com.villalobos.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {

    private String name;
    private TextView titulo,txtcantidad;
    private CheckBox opt1,opt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        titulo = findViewById(R.id.txttitulo);
        txtcantidad = findViewById(R.id.txtcantidad);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);

        name = getIntent().getStringExtra(MainActivity.NAME);
        titulo.setText("Order of "+name);

    }

    public void order(View view) {
        // opt1.isChecked(); => true si esta marcado
        // opt1.getText().toString();
        //Negocio only coffe $3
        //        crema: $1 - chocolate: $2
        Uri uri = Uri.parse("mailto: contact@coffee.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_TEXT, "contenido del correo");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order of "+name);
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }
    }

    public void call(View view) {
        Uri uri = Uri.parse("tel:969041664");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}