package io.apiary.megasena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {
	
	
	EditText etNumConcurso;
	ToggleButton  tb1,  tb2,  tb3,  tb4,  tb5,  tb6,  tb7,  tb8,  tb9, tb10,
	             tb11, tb12, tb13, tb14, tb15, tb16, tb17, tb18, tb19, tb20,
	             tb21, tb22, tb23, tb24, tb25, tb26, tb27, tb28, tb29, tb30,
	             tb31, tb32, tb33, tb34, tb35, tb36, tb37, tb38, tb39, tb40,
	             tb41, tb42, tb43, tb44, tb45, tb46, tb47, tb48, tb49, tb50,
	             tb51, tb52, tb53, tb54, tb55, tb56, tb57, tb58, tb59, tb60;
	
	ToggleButton[] tbArray = new ToggleButton[]{tb1,  tb2,  tb3,  tb4,  tb5,  tb6,  tb7,  tb8,  tb9, tb10,
									            tb11, tb12, tb13, tb14, tb15, tb16, tb17, tb18, tb19, tb20,
									            tb21, tb22, tb23, tb24, tb25, tb26, tb27, tb28, tb29, tb30,
									            tb31, tb32, tb33, tb34, tb35, tb36, tb37, tb38, tb39, tb40,
									            tb41, tb42, tb43, tb44, tb45, tb46, tb47, tb48, tb49, tb50,
									            tb51, tb52, tb53, tb54, tb55, tb56, tb57, tb58, tb59, tb60};
	
	int[] ids = new int[]{R.id.toggleButton1, R.id.toggleButton2, R.id.toggleButton3, R.id.toggleButton4, R.id.toggleButton5, R.id.toggleButton6, R.id.toggleButton7,R.id.toggleButton8, R.id.toggleButton9, R.id.toggleButton10,
			             R.id.toggleButton11, R.id.toggleButton12, R.id.toggleButton13, R.id.toggleButton14, R.id.toggleButton15, R.id.toggleButton16, R.id.toggleButton17,R.id.toggleButton18, R.id.toggleButton19, R.id.toggleButton20,
			             R.id.toggleButton21, R.id.toggleButton22, R.id.toggleButton23, R.id.toggleButton24, R.id.toggleButton25, R.id.toggleButton26, R.id.toggleButton27,R.id.toggleButton28, R.id.toggleButton29, R.id.toggleButton30,
			             R.id.toggleButton31, R.id.toggleButton32, R.id.toggleButton33, R.id.toggleButton34, R.id.toggleButton35, R.id.toggleButton36, R.id.toggleButton37,R.id.toggleButton38, R.id.toggleButton39, R.id.toggleButton40,
			             R.id.toggleButton41, R.id.toggleButton42, R.id.toggleButton43, R.id.toggleButton44, R.id.toggleButton45, R.id.toggleButton46, R.id.toggleButton47,R.id.toggleButton48, R.id.toggleButton49, R.id.toggleButton50,
			             R.id.toggleButton51, R.id.toggleButton52, R.id.toggleButton53, R.id.toggleButton54, R.id.toggleButton55, R.id.toggleButton56, R.id.toggleButton57,R.id.toggleButton58, R.id.toggleButton59, R.id.toggleButton60};
	
	Button btGravarAposta, btCancelarAposta, btBuscarApostas;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    
		bindViewComponents();
	}
	
	private void bindViewComponents() {
		
		etNumConcurso = (EditText) this.findViewById(R.id.etNumConcurso);
		btGravarAposta = (Button) this.findViewById(R.id.btGravarAposta);
		btCancelarAposta = (Button) this.findViewById(R.id.btCancelarAposta);
		btBuscarApostas = (Button) this.findViewById(R.id.btBuscarApostas);
		
		for (int i = 0; i < ids.length; i++) {
			tbArray[i] = (ToggleButton) this.findViewById(ids[i]);
		}
		
	}
	
	private void gravarAposta() {
		
	}
	
	private void cancelarAposta() {
		
	}
	
	private void buscarApostas() {
		
	}

	

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.btGravarAposta:		
			gravarAposta();			
			Toast.makeText(this, getResources().getString(R.string.aposta_registrada) +" "+ etNumConcurso.getText().toString(), Toast.LENGTH_LONG).show();			
			break;

		case R.id.btCancelarAposta:
			cancelarAposta();
			break;

		case R.id.btBuscarApostas:
			buscarApostas();
			break;
			
		default:
			break;
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
