package udesc.cct.poo.passagem.controle;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


import udesc.cct.poo.passagem.servicos.ServicoDeLocais;
import udesc.cct.poo.passagem.servicos.ServicoDePassagens;
import udesc.cct.poo.passagem.servicos.ServicoDeViagens;
import udesc.cct.poo.passagem.controle.ControleDeLogin;

public class ControleGeral{
    public final static int MARCAR_PASSAGEM = 1;
    public final static int SAIR = 0;

    private Scanner scanner;

    private ServicoDeLocais servicoDeLocais;
    private ServicoDeViagens servicoDeViagens;
    private ServicoDePassagens servicoDePassagens;
    private ControleDeLogin controleDeLogin;

    private ControleMarcarPassagem marcarPassagem;

    public ControleGeral(){
        this.scanner = new Scanner(System.in);
        this.servicoDeLocais = new ServicoDeLocais();
        this.servicoDeViagens = new ServicoDeViagens();
        this.servicoDePassagens = new ServicoDePassagens();
        this.controleDeLogin = new ControleDeLogin();

        this.marcarPassagem = new ControleMarcarPassagem(
        		this.scanner, 
        		this.servicoDeLocais, 
        		this.servicoDeViagens, 
        		this.servicoDePassagens);
    }

    public void iniciar() throws NoSuchAlgorithmException, UnsupportedEncodingException{
    	System.out.println("Insira o usu�rio: ");
    	String inputUser = this.scanner.nextLine();
    	System.out.println("Insira a sua senha:   ");
    	String inputSenha = this.scanner.nextLine();
    	
    	boolean loginEfetuado = this.controleDeLogin.login(inputUser, inputSenha);
    	
    	System.out.println(loginEfetuado);
    	
    	if (loginEfetuado == true ) {
    		
    		int escolha = -1;
            while(escolha != ControleGeral.SAIR){
                System.out.println("Escolha algo:");
                System.out.println( ControleGeral.MARCAR_PASSAGEM+") Marcar passagem");
                System.out.println( ControleGeral.SAIR+") Sair");
                escolha = this.scanner.nextInt();

                switch(escolha){
                    case ControleGeral.MARCAR_PASSAGEM:
                        this.marcarPassagem.iniciar();
                    break;
                    case ControleGeral.SAIR:
                    	System.out.println("Programa finalizado");
                    break;
                }
            }
    		
    	} else {
    		System.out.println("O usu�rio ou senha inseridos est� incorreto");
    	}
    	
        
    }
}
