package service;

import assemblers.VueloAssembler;
import dao.DBManager;
import dto.DTOVuelo;

public class EntityDataService {

	private static EntityDataService instance;

	private EntityDataService() { }
	
	public static EntityDataService getInstance() {
		if (instance == null) {
			instance = new EntityDataService();
		}

		return instance;
	}

	public DTOVuelo getVuelo(String idVuelo) {
		return VueloAssembler.getInstance().entityToDTO(DBManager.getInstance().getVuelo(idVuelo));
	}

}
