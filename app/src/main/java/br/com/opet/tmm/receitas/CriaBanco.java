package br.com.opet.tmm.receitas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Fábio, Lucas, Luis Gabriel on 22/06/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "Remember";
    public static final String ID = "_id";
    public static final String TITULOLISTA = "Titulo_da_Lista";
    public static final String ITENS = "Itens";
    public static final String  QUANTGASTAR = "Valor_para_compra";
    public static final String OBSERVACOES = "Observacoes";

    public static final String TABELA_USUARIO = "Usuario";
    public static final String ID_USUARIO = "_id";
    public static final String NOME_USUARIO = "Nome_do_Usuario";
    public static final String SENHA_USUARIO = "Senha_do_Usuario";

    public static final int VERSAO = 14;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement, "
                + TITULOLISTA + " text, "
                + ITENS + " text, "
                + QUANTGASTAR + " text, "
                + OBSERVACOES + " text"
                +")";
        Log.i("banco",sql);
        db.execSQL(sql);
        sql = "CREATE TABLE "+TABELA_USUARIO+"("
                + ID_USUARIO + " integer primary key autoincrement, "
                + NOME_USUARIO + " text, "
                + SENHA_USUARIO + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIO);
        onCreate(db);
    }
}
