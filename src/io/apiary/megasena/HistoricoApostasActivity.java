package io.apiary.megasena;

import io.apiary.megasena.model.Aposta;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HistoricoApostasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historico_apostas);

		ArrayList<Aposta> arrayListAposta = (ArrayList<Aposta>) getIntent()
				.getExtras().get(Aposta.INTENT_KEY);
		ApostaAdapter apostaAdapter = new ApostaAdapter(arrayListAposta, this);

		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(apostaAdapter);

	}

}
