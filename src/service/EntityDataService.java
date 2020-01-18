package service;

import assemblers.Assembler;
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

//	public DTOVuelo getVuelo(String idVuelo) {
//		return Assembler.getInstance().assemble(DBManager.getInstance().getVuelo(idVuelo));
//	}

}
