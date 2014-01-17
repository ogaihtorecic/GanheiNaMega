package io.apiary.megasena.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import android.content.ContentValues;
import android.provider.BaseColumns;

public class Aposta implements Serializable {

	public static final String TABLE_NAME = "tb_aposta";
	public static final String COLUMN_ID = BaseColumns._ID;
	public static final String CONCURSO = "tx_concurso";
	public static final String DEZENA_1 = "tx_dezena_1";
	public static final String DEZENA_2 = "tx_dezena_2";
	public static final String DEZENA_3 = "tx_dezena_3";
	public static final String DEZENA_4 = "tx_dezena_4";
	public static final String DEZENA_5 = "tx_dezena_5";
	public static final String DEZENA_6 = "tx_dezena_6";
	public static final String DEZENA_7 = "tx_dezena_7";
	public static final String DEZENA_8 = "tx_dezena_8";
	public static final String DEZENA_9 = "tx_dezena_9";
	public static final String DEZENA_10 = "tx_dezena_10";
	public static final String DEZENA_11 = "tx_dezena_11";
	public static final String DEZENA_12 = "tx_dezena_12";
	public static final String DEZENA_13 = "tx_dezena_13";
	public static final String DEZENA_14 = "tx_dezena_14";
	public static final String DEZENA_15 = "tx_dezena_15";
	public static final String ACERTOS = "tx_acertos";

	public static final String DEZENA_ = "tx_dezena_";
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer concurso;
	private Set<Integer> dezenas = new TreeSet<Integer>();
	private Integer acertos;

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

	public Set<Integer> getDezenas() {
		return dezenas;
	}

	public void setDezenas(Set<Integer> dezenas) {
		this.dezenas = dezenas;
	}

	public Integer getAcertos() {
		return acertos;
	}

	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}
	
	public ContentValues getContentValues() {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CONCURSO, this.concurso);
		contentValues.put(ACERTOS, this.acertos);
		
		int i = 1;
		for (Iterator<Integer> iterator = dezenas.iterator(); iterator.hasNext();) {
			Integer dezena = (Integer) iterator.next();
			contentValues.put(DEZENA_+ i++, dezena);
		}
		
		return contentValues;
	}

}
