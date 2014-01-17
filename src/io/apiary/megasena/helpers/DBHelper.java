package io.apiary.megasena.helpers;

import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.model.Resultado;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final String CREATE_TABLE = "CREATE TABLE ";
	private static final String OPEN_PARENTH = "(";
	private static final String AUTO_INCREMENT = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ";
	private static final String INTEGER_END = " INTEGER);";
	private static final String INTEGER_NOTNULL_END = " INTEGER NOT NULL);";
	private static final String INTEGER = " INTEGER,";
	private static final String INTEGER_NOTNULL = " INTEGER NOT NULL,";
	private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";

	private static final String DATABASE_NAME = "megasena.db";
	private static final int VERSION = 1;

	private static DBHelper dbHelper;

	private DBHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	public static void initializeDB(Context context) {
		dbHelper = new DBHelper(context);
	}

	public static DBHelper getInstance() {
		return dbHelper;
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(createTableAposta());
		database.execSQL(createTableResultado());
	}

	private String createTableResultado() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(CREATE_TABLE);
		builder.append(Resultado.TABLE_NAME);
		builder.append(OPEN_PARENTH);

		builder.append(Resultado.COLUMN_ID);
		builder.append(AUTO_INCREMENT);

		builder.append(Resultado.CONCURSO);
		builder.append(INTEGER_NOTNULL);

		builder.append(Resultado.DEZENA_1);
		builder.append(INTEGER_NOTNULL);

		builder.append(Resultado.DEZENA_2);
		builder.append(INTEGER_NOTNULL);

		builder.append(Resultado.DEZENA_3);
		builder.append(INTEGER_NOTNULL);

		builder.append(Resultado.DEZENA_4);
		builder.append(INTEGER_NOTNULL);

		builder.append(Resultado.DEZENA_5);
		builder.append(INTEGER_NOTNULL);

		builder.append(Resultado.DEZENA_6);
		builder.append(INTEGER_NOTNULL_END);
		
		return builder.toString();
	}

	private String createTableAposta() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(CREATE_TABLE);
		builder.append(Aposta.TABLE_NAME);
		builder.append(OPEN_PARENTH);

		builder.append(Aposta.COLUMN_ID);
		builder.append(AUTO_INCREMENT);

		builder.append(Aposta.CONCURSO);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_1);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_2);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_3);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_4);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_5);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_6);
		builder.append(INTEGER_NOTNULL);

		builder.append(Aposta.DEZENA_7);
		builder.append(INTEGER);

		builder.append(Aposta.DEZENA_8);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_9);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_10);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_11);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_12);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_13);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_14);
		builder.append(INTEGER);
		
		builder.append(Aposta.DEZENA_15);
		builder.append(INTEGER);
		
		builder.append(Aposta.ACERTOS);
		builder.append(INTEGER_END);

		return builder.toString();
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(DROP_TABLE);
		stringBuilder.append(Aposta.TABLE_NAME);
		database.execSQL(stringBuilder.toString());
	}

}
