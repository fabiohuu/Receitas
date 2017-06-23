package br.com.opet.tmm.receitas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText editNome;
    EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editNome = (EditText) findViewById(R.id.tLogin);
        editSenha = (EditText) findViewById(R.id.tSenha);
    }

    public void cadUser(View v){
        Intent novatela = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(novatela);
    }

    public void logar(View v){
        BancoController crud = new BancoController(this);
        String nome = editNome.getText().toString();
        String senha = editSenha.getText().toString();

        boolean encontrou = crud.carregaUsuario(nome,senha);

        if(encontrou){
            Toast.makeText(this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent novatela = new Intent(LoginActivity.this, DashBoardActivity.class);
            startActivity(novatela);
        }else{
            Toast.makeText(this, "Usuario ou senha não conferem.!", Toast.LENGTH_SHORT).show();
        }


    }
}
