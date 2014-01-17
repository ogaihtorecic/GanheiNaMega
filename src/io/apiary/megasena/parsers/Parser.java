package io.apiary.megasena.parsers;

public interface Parser<E> {

	public E convert() throws Exception;
	
}
