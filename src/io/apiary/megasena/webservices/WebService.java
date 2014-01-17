package io.apiary.megasena.webservices;

import org.apache.http.HttpResponse;

public interface WebService {

	public HttpResponse get(String url);
	
}
