package data.utilities;

import data.dto.DTOUsuario;
import data.jdo.Usuario;

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
		
		return dto;
	}
}
