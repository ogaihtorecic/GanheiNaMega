package io.apiary.megasena.persistence;

import io.apiary.megasena.helpers.DBHelper;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public abstract class BasicDAO<E> implements GenericDAO<E> {

	protected transient SQLiteDatabase database;
	
	public BasicDAO() {
		database = DBHelper.getInstance().getWritableDatabase();
	}
	
	@Override
	public abstract void insert(E e);

	@Override
	public abstract void update(E e);

	@Override
	public abstract void delete(E e);

	@Override
	public abstract E get(Long id);

	@Override
	public abstract List<E> list();

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
