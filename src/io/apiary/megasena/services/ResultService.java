package io.apiary.megasena.services;

import io.apiary.megasena.model.Resultado;
import io.apiary.megasena.parsers.JSONParser;
import io.apiary.megasena.parsers.Parser;
import io.apiary.megasena.webservices.WebService;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import android.app.IntentService;
import android.content.Intent;

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
			WebService webService = new WebServiceREST();
			HttpResponse response = webService.get(WebServiceREST.DEFAULT_URL);
			String requestBody = EntityUtils.toString(response.getEntity(),
					HTTP.UTF_8);

			Parser<Resultado> parser = new JSONParser(requestBody);
			Resultado resultado = parser.convert();

			sendBroadcast(ServiceActions.SUCCESS, resultado);

		} catch (ClientProtocolException e) {
			sendBroadcast(ServiceActions.CONNECTION_FAIL, null);
		} catch (IOException e) {
			sendBroadcast(ServiceActions.CONNECTION_FAIL, null);
		} catch (JSONException e) {
			sendBroadcast(ServiceActions.SERVICE_FAIL, null);
		} catch (Exception e) {
			sendBroadcast(ServiceActions.SERVICE_FAIL, null);
		}

	}

	private void sendBroadcast(ServiceActions action, Resultado resultado) {
		final Intent intent = new Intent();
		intent.setAction(action.getAction());

		if (resultado != null) {
			intent.putExtra(Resultado.INTENT_KEY, resultado);
		}

		sendBroadcast(intent);
	}

}
