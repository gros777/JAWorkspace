package me.victorhernandez.struts2.pra.domain;

import java.io.Serializable;

public interface DomainObject extends Serializable{
	public void copyFrom(DomainObject origin);
}
