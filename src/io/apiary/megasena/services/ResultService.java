package io.apiary.megasena.services;

import io.apiary.megasena.model.Resultado;
import io.apiary.megasena.parsers.JSONParser;
import io.apiary.megasena.parsers.Parser;

import java.io.IOException;

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
			String jsonBody = "{'concurso': 1565, 'dezena1': 12, 'dezena2': 22, 'dezena3': 35, 'dezena4': 41, 'dezena5': 48, 'dezena6': 56}";
			Parser<Resultado> parser = new JSONParser(jsonBody);
			Resultado resultado = parser.convert();
			
			sendLocalBroadcast(ServiceActions.SUCCESS, resultado);
			
		} catch (ClientProtocolException e) {
			sendLocalBroadcast(ServiceActions.CONNECTION_FAIL, null);
		} catch (IOException e) {
			sendLocalBroadcast(ServiceActions.CONNECTION_FAIL, null);
		} catch (JSONException e) {
			sendLocalBroadcast(ServiceActions.SERVICE_FAIL, null);
		} catch (Exception e) {
			sendLocalBroadcast(ServiceActions.SERVICE_FAIL, null);
		}

	}
	
	private void sendLocalBroadcast(ServiceActions action, Resultado resultado) {
		final Intent intent = new Intent();
		intent.setAction(action.getAction());
		
		if(resultado != null) {
			intent.putExtra(Resultado.INTENT_KEY, resultado);
		}
		
		LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
	} 

}
