package io.apiary.megasena.services;

import io.apiary.megasena.model.Resultado;
import io.apiary.megasena.parsers.JSONParser;
import io.apiary.megasena.parsers.Parser;
import io.apiary.megasena.persistence.GenericDAO;
import io.apiary.megasena.persistence.ResultadoDAO;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class ResultService extends IntentService {

	public ResultService() {
		super("io.apiary.megasena.services.ResultService");
	}
	
	public ResultService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			String jsonBody = "";
			Parser<Resultado> parser = new JSONParser(jsonBody);
			Resultado resultado = parser.convert();
			GenericDAO<Resultado> dao = new ResultadoDAO();
			
			dao.beginTransaction();
			List<Resultado> resultados = dao.list();
			if(!resultados.contains(resultado)) {
				dao.insert(resultado);
			}
			dao.endTransactionSuccessfully();
			
			sendLocalBroadcast(ServiceActions.SUCCESS);
			
		} catch (ClientProtocolException e) {
			sendLocalBroadcast(ServiceActions.CONNECTION_FAIL);
		} catch (IOException e) {
			sendLocalBroadcast(ServiceActions.CONNECTION_FAIL);
		} catch (JSONException e) {
			sendLocalBroadcast(ServiceActions.SERVICE_FAIL);
		} catch (Exception e) {
			sendLocalBroadcast(ServiceActions.SERVICE_FAIL);
		}

	}
	
	private void sendLocalBroadcast(ServiceActions action) {
		final Intent intent = new Intent();
		intent.setAction(action.getAction());
		LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
	} 

}
