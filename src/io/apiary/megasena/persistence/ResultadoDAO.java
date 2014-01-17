package io.apiary.megasena.persistence;

import io.apiary.megasena.model.Resultado;

import java.util.List;

public class ResultadoDAO extends BasicDAO<Resultado> {

	@Override
	public void insert(Resultado resultado) {
		database.insertOrThrow(Resultado.TABLE_NAME, null, resultado.getContentValues());
	}

	@Override
	public void update(Resultado e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Resultado e) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resultado get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
