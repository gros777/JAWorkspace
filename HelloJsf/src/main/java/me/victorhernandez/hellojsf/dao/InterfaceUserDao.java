package me.victorhernandez.hellojsf.dao;

import java.util.List;
import me.victorhernandez.hellojsf.model.*;

public interface InterfaceUserDao {
	void addUser(Usuario usuario);
	public List<Usuario> getAll();
}
