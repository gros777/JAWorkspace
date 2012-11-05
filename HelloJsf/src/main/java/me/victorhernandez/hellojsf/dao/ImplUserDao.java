package me.victorhernandez.hellojsf.dao;

import java.util.ArrayList;
import java.util.List;

import me.victorhernandez.hellojsf.model.Usuario;

public class ImplUserDao implements InterfaceUserDao {
	
	private List<Usuario> usuarios;
	
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			usuarios = new ArrayList<Usuario>();
		}
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public ImplUserDao() {
		
	}


	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub

		if(usuarios == null){
			usuarios = new ArrayList<Usuario>();
		}
		return usuarios;
	}

}
