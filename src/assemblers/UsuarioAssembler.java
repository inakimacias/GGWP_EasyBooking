package assemblers;

import dto.DTOUsuario;
import jdo.Usuario;

public class UsuarioAssembler {

	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public DTOUsuario entityToDTO(Usuario usuario) {
		DTOUsuario dto = new DTOUsuario();
		
		dto.setEmail(usuario.getEmail());
		dto.setPassword(usuario.getPassword());
		
		return dto;
	}
}
