package com.example.goddionisio.aula02atividadepdm;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //tentando adicionar o git
    //COMENTARIO ADD PELO SITE GITHUB

    private EditText valorEdt01, valorEdt02;

    private int valorSoma01, valorSoma02;

    private Button btn01Soma02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //enable transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btn01Soma02 = (Button) findViewById(R.id.btn01Soma02);
        btn01Soma02.setOnClickListener(this);

        valorEdt01 = (EditText) findViewById(R.id.edtTxtValor01);
        valorEdt02 = (EditText) findViewById(R.id.edtTxtValor02);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) { // tem que pegar o valor no momento em que é iniciado a ação de clicar.
        if(v.getId() == R.id.btn01Soma02){
            valorSoma01 = Integer.parseInt((valorEdt01.getText().toString()));
            valorSoma02 = Integer.parseInt((valorEdt02.getText().toString()));

            getWindow().setExitTransition(new Explode());
            Intent it = new Intent(this, Resultado.class);
            it.putExtra("Soma","O soma dos seguintes valores é: "+ valorSoma01+"+"+valorSoma02+" = "+ (valorSoma01+valorSoma02));
            startActivity(it, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }

    }
}
