package io.apiary.megasena;

import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.model.Resultado;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Resultado resultado = (Resultado) getIntent().getExtras().get(
				Resultado.INTENT_KEY);
		List<Aposta> apostas = (ArrayList<Aposta>) getIntent().getExtras().get(
				Aposta.INTENT_KEY);

		Log.d("GanheiNaMega", resultado.toString());
		for (Aposta a : apostas) {
			Log.d("GanheiNaMega", a.toString());
		}
	}

}
