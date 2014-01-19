package io.apiary.megasena;

import io.apiary.megasena.helpers.AlarmHelper;
import io.apiary.megasena.helpers.DBHelper;
import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.persistence.ApostaDAO;
import io.apiary.megasena.persistence.GenericDAO;
import io.apiary.megasena.receivers.AlarmReceiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {

	private EditText etNumConcurso;
	private ToggleButton tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8, tb9, tb10,
			tb11, tb12, tb13, tb14, tb15, tb16, tb17, tb18, tb19, tb20, tb21,
			tb22, tb23, tb24, tb25, tb26, tb27, tb28, tb29, tb30, tb31, tb32,
			tb33, tb34, tb35, tb36, tb37, tb38, tb39, tb40, tb41, tb42, tb43,
			tb44, tb45, tb46, tb47, tb48, tb49, tb50, tb51, tb52, tb53, tb54,
			tb55, tb56, tb57, tb58, tb59, tb60;

	private ToggleButton[] tbArray = new ToggleButton[] { tb1, tb2, tb3, tb4,
			tb5, tb6, tb7, tb8, tb9, tb10, tb11, tb12, tb13, tb14, tb15, tb16,
			tb17, tb18, tb19, tb20, tb21, tb22, tb23, tb24, tb25, tb26, tb27,
			tb28, tb29, tb30, tb31, tb32, tb33, tb34, tb35, tb36, tb37, tb38,
			tb39, tb40, tb41, tb42, tb43, tb44, tb45, tb46, tb47, tb48, tb49,
			tb50, tb51, tb52, tb53, tb54, tb55, tb56, tb57, tb58, tb59, tb60 };

	private int[] ids = new int[] { R.id.toggleButton1, R.id.toggleButton2,
			R.id.toggleButton3, R.id.toggleButton4, R.id.toggleButton5,
			R.id.toggleButton6, R.id.toggleButton7, R.id.toggleButton8,
			R.id.toggleButton9, R.id.toggleButton10, R.id.toggleButton11,
			R.id.toggleButton12, R.id.toggleButton13, R.id.toggleButton14,
			R.id.toggleButton15, R.id.toggleButton16, R.id.toggleButton17,
			R.id.toggleButton18, R.id.toggleButton19, R.id.toggleButton20,
			R.id.toggleButton21, R.id.toggleButton22, R.id.toggleButton23,
			R.id.toggleButton24, R.id.toggleButton25, R.id.toggleButton26,
			R.id.toggleButton27, R.id.toggleButton28, R.id.toggleButton29,
			R.id.toggleButton30, R.id.toggleButton31, R.id.toggleButton32,
			R.id.toggleButton33, R.id.toggleButton34, R.id.toggleButton35,
			R.id.toggleButton36, R.id.toggleButton37, R.id.toggleButton38,
			R.id.toggleButton39, R.id.toggleButton40, R.id.toggleButton41,
			R.id.toggleButton42, R.id.toggleButton43, R.id.toggleButton44,
			R.id.toggleButton45, R.id.toggleButton46, R.id.toggleButton47,
			R.id.toggleButton48, R.id.toggleButton49, R.id.toggleButton50,
			R.id.toggleButton51, R.id.toggleButton52, R.id.toggleButton53,
			R.id.toggleButton54, R.id.toggleButton55, R.id.toggleButton56,
			R.id.toggleButton57, R.id.toggleButton58, R.id.toggleButton59,
			R.id.toggleButton60 };

	private Button btGravarAposta, btCancelarAposta, btBuscarApostas,
			btVerificar;

	private ProgressDialog progressDialog;
	
	private GenericDAO<Aposta> apostaDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bindViewComponents();
		registerViewListeners();

		DBHelper.initializeDB(getApplicationContext());
		apostaDAO = new ApostaDAO();
		
		AlarmHelper.configNextAlarm(getApplicationContext());
		
		setupProgressDialog();
	}

	private void setupProgressDialog() {
		this.progressDialog = new ProgressDialog(this);
		this.progressDialog.setCancelable(false);
		this.progressDialog.setMessage(getResources().getString(R.string.progress_msg));
	}

	private void bindViewComponents() {

		etNumConcurso = (EditText) this.findViewById(R.id.etNumConcurso);
		btGravarAposta = (Button) this.findViewById(R.id.btGravarAposta);
		btCancelarAposta = (Button) this.findViewById(R.id.btCancelarAposta);
		btBuscarApostas = (Button) this.findViewById(R.id.btBuscarApostas);
		btVerificar = (Button) this.findViewById(R.id.btVerificar);

		for (int i = 0; i < ids.length; i++) {
			tbArray[i] = (ToggleButton) this.findViewById(ids[i]);
		}
	}

	private void registerViewListeners() {

		btGravarAposta.setOnClickListener(this);
		btCancelarAposta.setOnClickListener(this);
		btBuscarApostas.setOnClickListener(this);
		btVerificar.setOnClickListener(this);
	}

	private boolean apostaValida() {
		int numeroDezenas = 0;

		if ("".equals(etNumConcurso.getText().toString())) {
			Toast.makeText(
					this,
					getResources().getString(
							R.string.aposta_invalida_num_concurso),
					Toast.LENGTH_LONG).show();
			return false;
		}

		for (int i = 0; i < ids.length && numeroDezenas <= 15; i++) {

			if (tbArray[i].isChecked()) {
				numeroDezenas++;
			}
		}

		if (numeroDezenas < 6 || numeroDezenas > 15) {
			Toast.makeText(
					this,
					getResources().getString(
							R.string.aposta_invalida_qtd_dezenas),
					Toast.LENGTH_LONG).show();
			return false;
		}

		return true;
	}

	private Aposta getAposta() {

		Aposta aposta = new Aposta();
		aposta.setConcurso(Integer.valueOf(etNumConcurso.getText().toString()
				.trim()));

		Set<Integer> setDezenas = aposta.getDezenas();

		for (int i = 0; i < tbArray.length && setDezenas.size() < 15; i++) {
			if (tbArray[i].isChecked()) {
				setDezenas.add(i + 1);
			}
		}

		return aposta;
	}

	private void gravarAposta() {

		if (apostaValida()) {

			new AsyncTask<Void, Void, Void>() {

				@Override
				protected Void doInBackground(Void... params) {
					apostaDAO.insert(getAposta());
					return null;
				}

				protected void onPostExecute(Void result) {
					Toast.makeText(
							MainActivity.this,
							MainActivity.this
									.getText(R.string.aposta_registrada)
									+ " "
									+ etNumConcurso.getText().toString(),
							Toast.LENGTH_LONG).show();
					limparCartaoAposta();
				};

			}.execute();

		}

	}

	private void limparCartaoAposta() {

		etNumConcurso.setText("");

		for (int i = 0; i < ids.length; i++) {
			tbArray[i].setChecked(false);
		}
	}

	private void buscarApostas() {

		new AsyncTask<Void, Void, List<Aposta>>() {

			protected void onPreExecute() {
				MainActivity.this.progressDialog.show();
			};
			
			@Override
			protected List<Aposta> doInBackground(Void... params) {
				return apostaDAO.list();
			}
			
			@Override
			protected void onPostExecute(List<Aposta> result) {
				super.onPostExecute(result);
				MainActivity.this.progressDialog.dismiss();
				Intent intent = new Intent(MainActivity.this, HistoricoApostasActivity.class);
				intent.putExtra(Aposta.INTENT_KEY, (ArrayList<Aposta>)result);
				startActivity(intent);
			}
		}.execute();

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.btGravarAposta:
			gravarAposta();
			break;

		case R.id.btCancelarAposta:
			limparCartaoAposta();
			break;

		case R.id.btBuscarApostas:
			buscarApostas();
			break;

		case R.id.btVerificar:
			sendBroadcast(new Intent(AlarmReceiver.ALARM_ACTION));
			break;

		default:
			break;
		}

	}
}
