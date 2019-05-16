package udesc.cct.poo.passagem.controle;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ControleDeLogin {
	
	private User admin = new User("admin", "admin@123");
	private User usuario = new User("user", "user@123");
	
	
	public void ControleDeLogin() throws Exception {}
	
	public boolean login(String inputUser, String inputSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		System.out.println(inputUser + " " + this.admin.login);	
		
		if (inputUser.equals(this.admin.login) || inputUser.contentEquals(this.usuario.login)) { 
			this.admin.senha = this.fazOSalt(this.admin.senha);
			this.usuario.senha = this.fazOSalt(this.usuario.senha);
			inputSenha = this.fazOSalt(inputSenha);
			
			if (inputSenha.equals(this.admin.senha)|| inputSenha.equals(this.usuario.senha)) {
				return true;
			} else {
				return false;
			}			
		}
		
		return false;
	}
	
	private String fazOSalt(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		senha = senha + "salt";
		
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
