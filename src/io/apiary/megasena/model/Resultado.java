package io.apiary.megasena.model;

import android.content.ContentValues;
import android.provider.BaseColumns;

public class Resultado {

	public static final String TABLE_NAME = "tb_resultado";
	public static final String COLUMN_ID = BaseColumns._ID;
	public static final String CONCURSO = "tx_concurso";
	public static final String DEZENA_1 = "tx_dezena_1";
	public static final String DEZENA_2 = "tx_dezena_2";
	public static final String DEZENA_3 = "tx_dezena_3";
	public static final String DEZENA_4 = "tx_dezena_4";
	public static final String DEZENA_5 = "tx_dezena_5";
	public static final String DEZENA_6 = "tx_dezena_6";
	
	private Integer id;
	private Integer concurso;
	private Integer dezena1;
	private Integer dezena2;
	private Integer dezena3;
	private Integer dezena4;
	private Integer dezena5;
	private Integer dezena6;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConcurso() {
		return concurso;
	}

	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}

	public Integer getDezena1() {
		return dezena1;
	}

	public void setDezena1(Integer dezena1) {
		this.dezena1 = dezena1;
	}

	public Integer getDezena2() {
		return dezena2;
	}

	public void setDezena2(Integer dezena2) {
		this.dezena2 = dezena2;
	}

	public Integer getDezena3() {
		return dezena3;
	}

	public void setDezena3(Integer dezena3) {
		this.dezena3 = dezena3;
	}

	public Integer getDezena4() {
		return dezena4;
	}

	public void setDezena4(Integer dezena4) {
		this.dezena4 = dezena4;
	}

	public Integer getDezena5() {
		return dezena5;
	}

	public void setDezena5(Integer dezena5) {
		this.dezena5 = dezena5;
	}

	public Integer getDezena6() {
		return dezena6;
	}

	public void setDezena6(Integer dezena6) {
		this.dezena6 = dezena6;
	}
	
	public ContentValues getContentValues() {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CONCURSO, this.concurso);
		contentValues.put(DEZENA_1, this.dezena1);
		contentValues.put(DEZENA_2, this.dezena2);
		contentValues.put(DEZENA_3, this.dezena3);
		contentValues.put(DEZENA_4, this.dezena4);
		contentValues.put(DEZENA_5, this.dezena5);
		contentValues.put(DEZENA_6, this.dezena6);
		
		return contentValues;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Resultado)) {
			return super.equals(o);
		}
		
		Resultado resultado = (Resultado) o;
		return this.getConcurso().equals(resultado);
	}

}
