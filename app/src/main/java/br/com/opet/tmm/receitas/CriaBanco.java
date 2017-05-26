package br.com.opet.tmm.receitas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Fábio, Lucas, Luis Gabriel on 25/05/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "Receitas";
    public static final String ID = "_id";
    public static final String RECEITAS = "Receitas";
    public static final String INGREDIENTES = "Ingredientes";
    public static final String MODODEPREPARO = "MododePreparo";
    public static final String QUANTPESSOAS = "QuantPessoas";
    public static final String TEMPO = "Tempo";
    public static final int VERSAO = 7;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement, "
                + RECEITAS + " text, "
                + INGREDIENTES + " text, "
                + MODODEPREPARO + " text, "
                + QUANTPESSOAS + " text, "
                + TEMPO + " text"
                +")";
        Log.i("banco",sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
