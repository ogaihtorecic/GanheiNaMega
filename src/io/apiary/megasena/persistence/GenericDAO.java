package io.apiary.megasena.persistence;

import java.util.List;

public interface GenericDAO<E> {

	public void insert(E e);
	
	public void update(E e);
	
	public void delete(E e);
	
	public E get(Long id);
	
	public List<E> list();
	
}
