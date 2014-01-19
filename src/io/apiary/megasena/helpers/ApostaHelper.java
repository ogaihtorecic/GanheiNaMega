package io.apiary.megasena.helpers;

import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.model.Resultado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApostaHelper {

	public static List<Aposta> extractWinners(Resultado resultado,
			List<Aposta> list) {
		
		List<Aposta> resultList = new ArrayList<Aposta>();
		for (int i = 0; i < list.size(); i++) {
			Aposta a = list.get(i);
			int acertos = 0;
			if (a.getConcurso().equals(resultado.getConcurso())) {
				if(a.getDezenas().contains(resultado.getDezena1())) {
					acertos++;
				}
				if(a.getDezenas().contains(resultado.getDezena2())) {
					acertos++;
				}
				if(a.getDezenas().contains(resultado.getDezena3())) {
					acertos++;
				}
				if(a.getDezenas().contains(resultado.getDezena4())) {
					acertos++;
				}
				if(a.getDezenas().contains(resultado.getDezena5())) {
					acertos++;
				}
				if(a.getDezenas().contains(resultado.getDezena6())) {
					acertos++;
				}
				if(acertos > 0) {
					a.setAcertos(acertos);
					resultList.add(a);
				}
			}
		}

		Collections.sort(resultList, new Comparator<Aposta>() {
			@Override
			public int compare(Aposta aposta1, Aposta aposta2) {
				return aposta2.getAcertos() - aposta1.getAcertos();
			}
		});
		
		return resultList;
	}

}
