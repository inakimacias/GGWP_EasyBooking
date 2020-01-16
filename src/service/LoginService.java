package service;

import dao.DBManager;
import gateways.ILoginGw;
import jdo.Usuario;

public class LoginService {
	
private static LoginService instance;
	
	private LoginService() { }
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}

	public Usuario login(String email, String password, String authService) {
		Usuario usuario = null;
		ILoginGw login = Factory.getInstance().createLoginGw(authService);
		if(login.autenticar(email, password)) {
			usuario = DBManager.getInstance().getUser(email);
		}
		return usuario;
	}

}
