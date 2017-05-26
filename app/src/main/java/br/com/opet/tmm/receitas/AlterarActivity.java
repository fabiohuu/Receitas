package br.com.opet.tmm.receitas;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarActivity extends Activity {

    EditText Receitas;
    EditText Ingredientes;
    EditText Mododepreparo;
    EditText Quantpessoas;
    EditText Tempo;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        Receitas = (EditText)findViewById(R.id.editText4);
        Ingredientes = (EditText)findViewById(R.id.editText5);
        Mododepreparo = (EditText)findViewById(R.id.editText6);
        Quantpessoas = (EditText)findViewById(R.id.editText7);
        Tempo = (EditText)findViewById(R.id.editText8);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        Receitas.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.RECEITAS)));
        Ingredientes.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INGREDIENTES)));
        Mododepreparo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.MODODEPREPARO)));
        Quantpessoas.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.QUANTPESSOAS)));
        Tempo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TEMPO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), Receitas.getText().toString(),Ingredientes.getText().toString(),
                        Mododepreparo.getText().toString(),Quantpessoas.getText().toString(),Tempo.getText().toString());
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
