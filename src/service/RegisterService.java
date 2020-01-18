package service;

public class RegisterService {
private static RegisterService instance;
	
	private RegisterService() { }
	
	public static RegisterService getInstance() {
		if (instance == null) {
			instance = new RegisterService();
		}
	
		return instance;
	}
	
	public void registro(String id, String password, String authType) {
		
	}

}
