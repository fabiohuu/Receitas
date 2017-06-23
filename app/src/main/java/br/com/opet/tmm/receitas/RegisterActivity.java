package br.com.opet.tmm.receitas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends Activity {

    EditText editNome;
    EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editNome = (EditText) findViewById(R.id.tNome);
        editSenha = (EditText) findViewById(R.id.tPass);
    }

    public void cadastrarUsuario(View v){
        BancoController crud = new BancoController(this);
        String nome = editNome.getText().toString();
        String senha = editSenha.getText().toString();

        String resultado = crud.insereDadoUsuario(nome,senha);

        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
        Intent novatela = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(novatela);
    }
}
