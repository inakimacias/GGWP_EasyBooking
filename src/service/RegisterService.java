package service;

import dao.DBManager;
import gateways.ILoginGw;
import jdo.Usuario;

public class RegisterService {
private static RegisterService instance;
	
	private RegisterService() { }
	
	public static RegisterService getInstance() {
		if (instance == null) {
			instance = new RegisterService();
		}
	
		return instance;
	}
	
	public boolean registro(String id, String password, String authType) {
		ILoginGw igw = Factory.getInstance().createLoginGw(authType);
		if(igw.autenticar(id, password)) {
			Usuario u = new Usuario();
			u.setEmail(id);
			try {
				DBManager.getInstance().guardarUsuario(u);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;		
	}
}
