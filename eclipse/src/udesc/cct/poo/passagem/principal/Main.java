package udesc.cct.poo.passagem.principal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import udesc.cct.poo.passagem.controle.ControleGeral;

public class Main{
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        ControleGeral controleGeral = new ControleGeral();
        controleGeral.iniciar();
    }
}
