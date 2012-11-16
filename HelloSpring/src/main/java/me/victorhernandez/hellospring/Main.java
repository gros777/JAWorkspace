package me.victorhernandez.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.victorhernandez.hellospring.domain.Usuario;

public class Main {

	private Usuario usuario;

	public Main(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Pedirle a spring que construya la clase Main, 
		//y que ademas el mismo le inyecte de una sola vez el usuario
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"hellospring-beans.xml");
		Main execute = (Main) context.getBean("main");
		
		String info = "Nombre Usuario: " + execute.getUsuario().getNombre() 
				+ " Direcci—n: " + execute.getUsuario().getDireccion()
				+ " eMail: " + execute.getUsuario().getEmail();
		System.out.println(info);
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
