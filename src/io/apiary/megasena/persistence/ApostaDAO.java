package io.apiary.megasena.persistence;

import io.apiary.megasena.helpers.DBHelper;
import io.apiary.megasena.model.Aposta;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ApostaDAO implements GenericDAO<Aposta> {

	private transient SQLiteDatabase database;
	
	public ApostaDAO() {
		database = DBHelper.getInstance().getWritableDatabase();
	}
	
	@Override
	public void insert(Aposta aposta) {
		database.insertOrThrow(Aposta.TABLE_NAME, null, aposta.getContentValues());
	}

	@Override
	public void update(Aposta e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aposta e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aposta get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aposta> list() {
		Cursor cursor = database.query(Aposta.TABLE_NAME, null, null, null, null, null, null);
		List<Aposta> apostas = new ArrayList<Aposta>();
		while(cursor.moveToNext()) {
			Aposta aposta = new Aposta();
			aposta.setId(cursor.getInt(cursor.getColumnIndex(Aposta.COLUMN_ID)));
			aposta.setAcertos(cursor.getInt(cursor.getColumnIndex(Aposta.ACERTOS)));
			aposta.setConcurso(cursor.getInt(cursor.getColumnIndex(Aposta.CONCURSO)));
			
			for (int i = 1; i < 16; i++) {
				Integer dezena = cursor.getInt(cursor.getColumnIndex(Aposta.DEZENA_ + i));
				if(dezena != null) {
					aposta.getDezenas().add(dezena);
				}
			}
			apostas.add(aposta);
		}
		return apostas;
	}

	@Override
	public void beginTransaction() {
		database.beginTransaction();
		
	}

	@Override
	public void endTransaction() {
		database.endTransaction();
		
	}

	@Override
	public void endTransactionSuccessfully() {
		database.setTransactionSuccessful();
		database.endTransaction();
	}

}
