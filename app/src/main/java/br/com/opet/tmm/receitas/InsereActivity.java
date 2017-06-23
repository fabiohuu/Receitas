package br.com.opet.tmm.receitas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsereActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText Titulolista = (EditText)findViewById(R.id.editText);
                EditText Itens = (EditText)findViewById((R.id.editText2));
                EditText Quantgastar = (EditText)findViewById(R.id.editText3);
                EditText Observacoes = (EditText)findViewById(R.id.editText4);
                String TitulolistaString = Titulolista.getText().toString();
                String ItensString = Itens.getText().toString();
                String QuantgastarString = Quantgastar.getText().toString();
                String ObservacoesString = Observacoes.getText().toString();
                String resultado;

                resultado = crud.insereDado(TitulolistaString,ItensString,QuantgastarString,ObservacoesString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
