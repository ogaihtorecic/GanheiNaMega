package io.apiary.megasena;

import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.persistence.ApostaDAO;
import io.apiary.megasena.persistence.GenericDAO;

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

		GenericDAO<Aposta> apostaDAO = new ApostaDAO();

		ArrayList<Aposta> arrayListAposta = (ArrayList<Aposta>) apostaDAO.list(); 
				
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apostas_list, menu);
		return true;
	}

}
