package me.victorhernandez.struts2.pra.dao;

import java.util.List;

import me.victorhernandez.struts2.pra.domanin.DomainObject;


public interface GenericDao<T extends DomainObject> {

	public T get(Long id);
    public List<T> getAll();
    public void save(T object);
    public void delete(T object);

}
