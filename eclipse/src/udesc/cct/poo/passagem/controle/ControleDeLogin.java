package udesc.cct.poo.passagem.controle;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ControleDeLogin {
	
	private Scanner scanner;
	private String algoritmo = "SHA-256";	
	private User admin = new User("admin", "admin@123");
	private User usuario = new User("user", "user@123");
	
	
	public void ControleDeLogin() throws Exception {}
	
	public void login(String inputUser, String inputSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		System.out.println(this.fazOSalt(this.admin.senha));
	
	}
	
	private String fazOSalt(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte MessageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hexString = new StringBuilder();
		
		for (byte b : MessageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		
		String senhaHex = hexString.toString();
		
		return senhaHex;		
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
