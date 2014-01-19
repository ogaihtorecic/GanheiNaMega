package io.apiary.megasena.services;

import io.apiary.megasena.webservices.WebService;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class WebServiceREST implements WebService {

	private static final int CONN_TIMEOUT = 30000;
	private static final int SOCKET_TIMEOUT = 10000;
	public static final String DEFAULT_URL = "http://megasena.apiary.io/resultado";

	private DefaultHttpClient defaultHttpClient;

	public WebServiceREST() {
		final HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, CONN_TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIMEOUT);
		defaultHttpClient = new DefaultHttpClient(httpParameters);
	}

	@Override
	public HttpResponse get(String url) throws ClientProtocolException,
			IOException {
		HttpGet httpGet = new HttpGet(url);
		return this.defaultHttpClient.execute(httpGet);
	}

}
