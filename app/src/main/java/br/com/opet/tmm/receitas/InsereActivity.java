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
                EditText Receitas = (EditText)findViewById(R.id.editText);
                EditText Ingredientes = (EditText)findViewById((R.id.editText2));
                EditText Mododepreparo = (EditText)findViewById(R.id.editText3);
                EditText Quantpessoas = (EditText)findViewById(R.id.editText4);
                EditText Tempo = (EditText)findViewById((R.id.editText5));
                String ReceitasString = Receitas.getText().toString();
                String IngredientesString = Ingredientes.getText().toString();
                String MododepreparoString = Mododepreparo.getText().toString();
                String QuantpessoasString = Quantpessoas.getText().toString();
                String TempoString = Tempo.getText().toString();
                String resultado;

                resultado = crud.insereDado(ReceitasString,IngredientesString,MododepreparoString,QuantpessoasString,TempoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
