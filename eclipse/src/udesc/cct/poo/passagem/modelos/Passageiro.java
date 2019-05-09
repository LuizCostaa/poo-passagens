package udesc.cct.poo.passagem.modelos;
public class Passageiro{
    private String nome;
    private String cpf;

    public Passageiro(String nome,String cpf){
        this.nome = nome;
        this.cpf  = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }
}
