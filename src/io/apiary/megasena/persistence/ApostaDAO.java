package io.apiary.megasena.persistence;

import io.apiary.megasena.helpers.DBHelper;
import io.apiary.megasena.model.Aposta;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

}
