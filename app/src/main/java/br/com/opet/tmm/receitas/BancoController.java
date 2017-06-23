package br.com.opet.tmm.receitas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Fábio, Lucas, Luis Gabriel  on 22/06/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDadoUsuario(String nome, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME_USUARIO, nome);
        valores.put(CriaBanco.SENHA_USUARIO, senha);

        resultado = db.insert(CriaBanco.TABELA_USUARIO, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public boolean carregaUsuario(String nome, String senha){
        Cursor cursor;
        String[] campos =  {banco.ID_USUARIO,banco.NOME_USUARIO,banco.SENHA_USUARIO};
        String where = CriaBanco.NOME_USUARIO + "=" + "'" + nome + "'" +" and " + CriaBanco.SENHA_USUARIO + "=" + "'" + senha + "'" ;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_USUARIO,campos,where, null, null, null, null, null);

        if(cursor!=null){
            if(cursor.getCount() > 0)
            {
                db.close();
                return true;
            }
        }
        db.close();
        return false;
    }

    public String insereDado(String Titulolista, String Itens, String Quantgastar, String Observacoes){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.TITULOLISTA, Titulolista);
        valores.put(CriaBanco.ITENS, Itens);
        valores.put(CriaBanco.QUANTGASTAR,Quantgastar);
        valores.put(CriaBanco.OBSERVACOES, Observacoes);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULOLISTA};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA, campos, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULOLISTA,banco.ITENS,banco.QUANTGASTAR,banco.OBSERVACOES,};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String Titulolista, String Itens, String Quantgastar, String Observacoes){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.TITULOLISTA, Titulolista);
        valores.put(CriaBanco.ITENS, Itens);
        valores.put(CriaBanco.QUANTGASTAR, Quantgastar);
        valores.put(CriaBanco.OBSERVACOES, Observacoes);

        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }


}
