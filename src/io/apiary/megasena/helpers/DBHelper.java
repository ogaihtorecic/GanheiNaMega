package io.apiary.megasena.helpers;

import io.apiary.megasena.model.Aposta;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final String CREATE_TABLE = "CREATE TABLE ";
	private static final String OPEN_PARENTH = "(";
	private static final String AUTO_INCREMENT = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ";
	private static final String INTEGER_END = " INTEGER)";
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
		StringBuilder builder = new StringBuilder();
		builder.append(CREATE_TABLE);
		builder.append(Aposta.TABLE_NAME);
		builder.append(OPEN_PARENTH);
		builder.append(Aposta.COLUMN_ID + AUTO_INCREMENT);
		builder.append(Aposta.CONCURSO + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_1 + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_2 + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_3 + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_4 + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_5 + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_6 + INTEGER_NOTNULL);
		builder.append(Aposta.DEZENA_7 + INTEGER);
		builder.append(Aposta.DEZENA_8 + INTEGER);
		builder.append(Aposta.DEZENA_9 + INTEGER);
		builder.append(Aposta.DEZENA_10 + INTEGER);
		builder.append(Aposta.DEZENA_11 + INTEGER);
		builder.append(Aposta.DEZENA_12 + INTEGER);
		builder.append(Aposta.DEZENA_13 + INTEGER);
		builder.append(Aposta.DEZENA_14 + INTEGER);
		builder.append(Aposta.DEZENA_15 + INTEGER);
		builder.append(Aposta.ACERTOS + INTEGER_END);

		database.execSQL(builder.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {
		database.execSQL(DROP_TABLE + Aposta.TABLE_NAME);
	}

}
