package gateways;

import jdo.Usuario;

public interface ILoginGw {
	public Usuario autenticar(String nick, String password);
}
