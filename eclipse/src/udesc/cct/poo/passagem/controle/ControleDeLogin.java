package udesc.cct.poo.passagem.controle;
import java.util.Scanner; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ControleDeLogin {
	
	private Scanner scanner;
	private String algoritmo = "SHA-256";	
	private User admin = new User("admin", "admin@123");
	private User usuario = new User("user", "user@123");
	
	
	public void ControleDeLogin() throws Exception {
		
	}
	
	public void login() {
		String user = this.scanner.toString();
		String senha = this.scanner.toString();
		
		User login = new User(user, senha);
	}
	
	public void teste() throws Exception {
		
		String data = "admin";
		String algorithm = "SHA-256";
		System.out.println(generateHash(data, algorithm));
		
	}

	private static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.reset();
		byte[] hash = digest.digest(data.getBytes());
		return bytesToStringHex(hash);
	}
	
	private final static char[] hexArray = "teste123".toCharArray();
	
	public static String bytesToStringHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0xFF];
		}
		return new String(hexChars);
	}
}

class User {
	String login;
	String senha;
	
	User(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
}
