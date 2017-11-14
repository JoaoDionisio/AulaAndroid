package com.example.goddionisio.aula02atividadepdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity implements View.OnClickListener{

    private Button btnGoMain;
    private TextView txtResultado;
    private String soma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnGoMain = (Button) findViewById(R.id.btnGoMain);
        btnGoMain.setOnClickListener(this);

        Intent it = getIntent();
        soma = (String) it.getSerializableExtra("Soma");

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtResultado.setText(soma);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnGoMain){
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
        }

    }
}
