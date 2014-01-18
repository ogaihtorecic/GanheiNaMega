package io.apiary.megasena;

import io.apiary.megasena.model.Aposta;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class HistoricoApostasActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historico_apostas);
		
		TextView tvNumConcurso = (TextView) this.findViewById(R.id.lb_num_concurso);
		TextView tvDezenas = (TextView) this.findViewById(R.id.lb_dezenas);

		ArrayList<Aposta> arrayListAposta = (ArrayList<Aposta>) getIntent().getExtras().get(Aposta.INTENT_KEY); 
				
		/*
		for (Employee employee : arrayListEmployee) {
			Log.d("EmployeeListActivity", employee.getName());
			Log.d("EmployeeListActivity", employee.getLastName());
			Log.d("EmployeeListActivity", employee.getPassword());
		}*/
				
		ListView listView = (ListView) findViewById(R.id.listView);

		ApostaAdapter apostaAdapter = new ApostaAdapter(arrayListAposta, this);
		
		listView.setAdapter(apostaAdapter);
		
	}

}
