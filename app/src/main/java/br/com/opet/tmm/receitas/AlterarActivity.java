package br.com.opet.tmm.receitas;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarActivity extends Activity {

    EditText Titulolista;
    EditText Itens;
    EditText Quantgastar;
    EditText Observacoes;
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

        Titulolista = (EditText)findViewById(R.id.editText4);
        Itens = (EditText)findViewById(R.id.editText5);
        Quantgastar = (EditText)findViewById(R.id.editText6);
        Observacoes = (EditText)findViewById(R.id.editText7);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        Titulolista.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULOLISTA)));
        Itens.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ITENS)));
        Quantgastar.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.QUANTGASTAR)));
        Observacoes.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.OBSERVACOES)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), Titulolista.getText().toString(),Itens.getText().toString(),
                        Quantgastar.getText().toString(),Observacoes.getText().toString());
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
