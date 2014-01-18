package io.apiary.megasena.persistence;

import io.apiary.megasena.model.Aposta;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

public class ApostaDAO extends BasicDAO<Aposta> {

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
		Cursor cursor = database.query(Aposta.TABLE_NAME, null, null, null, null, null, Aposta.COLUMN_ID + " DESC");
		List<Aposta> apostas = new ArrayList<Aposta>();
		while(cursor.moveToNext()) {
			Aposta aposta = new Aposta();
			aposta.setId(cursor.getInt(cursor.getColumnIndex(Aposta.COLUMN_ID)));
			aposta.setAcertos(cursor.getInt(cursor.getColumnIndex(Aposta.ACERTOS)));
			aposta.setConcurso(cursor.getInt(cursor.getColumnIndex(Aposta.CONCURSO)));
			
			for (int i = 1; i < 16; i++) {
				Integer dezena = cursor.getInt(cursor.getColumnIndex(Aposta.DEZENA_ + i));
				if(dezena != null && dezena != 0) {
					aposta.getDezenas().add(dezena);
				}
			}
			apostas.add(aposta);
		}
		return apostas;
	}
}
