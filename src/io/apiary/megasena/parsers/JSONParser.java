package io.apiary.megasena.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import io.apiary.megasena.model.Resultado;

public class JSONParser implements Parser<Resultado> {

	private JSONObject jsonObject;
	
	public JSONParser(String jsonBody) throws JSONException {
		jsonObject = new JSONObject(jsonBody);
	}
	
	@Override
	public Resultado convert() throws JSONException {
		Resultado resultado = new Resultado();
		resultado.setConcurso(jsonObject.getInt("concurso"));
		resultado.setDezena1(jsonObject.getInt("dezena1"));
		resultado.setDezena2(jsonObject.getInt("dezena2"));
		resultado.setDezena3(jsonObject.getInt("dezena3"));
		resultado.setDezena4(jsonObject.getInt("dezena4"));
		resultado.setDezena5(jsonObject.getInt("dezena5"));
		resultado.setDezena6(jsonObject.getInt("dezena6"));
		
		return resultado;
	}

}
