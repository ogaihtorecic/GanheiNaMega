package io.apiary.megasena;

import io.apiary.megasena.helpers.GenericHelper;
import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.model.Resultado;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Resultado resultado = (Resultado) getIntent().getExtras().get(
				Resultado.INTENT_KEY);
		List<Aposta> apostas = (ArrayList<Aposta>) getIntent().getExtras().get(
				Aposta.INTENT_KEY);

		TextView tvConcurso = (TextView) findViewById(R.id.tvConcurso);
		tvConcurso.setText(GenericHelper.fillWithZeros(resultado.getConcurso()
				.toString(), "000", 4));

		TextView tvDezena1 = (TextView) findViewById(R.id.tvDezena1);
		tvDezena1.setText(GenericHelper.fillWithZeros(resultado.getDezena1()
				.toString(), "0", 2));

		TextView tvDezena2 = (TextView) findViewById(R.id.tvDezena2);
		tvDezena2.setText(GenericHelper.fillWithZeros(resultado.getDezena2()
				.toString(), "0", 2));

		TextView tvDezena3 = (TextView) findViewById(R.id.tvDezena3);
		tvDezena3.setText(GenericHelper.fillWithZeros(resultado.getDezena3()
				.toString(), "0", 2));

		TextView tvDezena4 = (TextView) findViewById(R.id.tvDezena4);
		tvDezena4.setText(GenericHelper.fillWithZeros(resultado.getDezena4()
				.toString(), "0", 2));

		TextView tvDezena5 = (TextView) findViewById(R.id.tvDezena5);
		tvDezena5.setText(GenericHelper.fillWithZeros(resultado.getDezena5()
				.toString(), "0", 2));

		TextView tvDezena6 = (TextView) findViewById(R.id.tvDezena6);
		tvDezena6.setText(GenericHelper.fillWithZeros(resultado.getDezena6()
				.toString(), "0", 2));

		AcertosAdapter acertosAdapter = new AcertosAdapter(apostas, resultado, this);

		ListView listView = (ListView) findViewById(R.id.lvApostas);
		listView.setAdapter(acertosAdapter);
	}
}
