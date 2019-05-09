package udesc.cct.poo.passagem.modelos;

public class Passagem{
    private Passageiro passageiro;
    private Viagem viagem;
    private Local origem;
    private Local destino;

    public Passagem(Viagem viagem, Local origem, Local destino,Passageiro passageiro){
        this.viagem = viagem;
        this.origem = origem;
        this.destino = destino;
        this.passageiro = passageiro;
    }
    
    public Viagem getViagem() {
    	return this.viagem;
    }
    
    public Local getOrigem() {
    	return this.origem;
    }
    
    public Passageiro getPassageiro() {
    	return this.passageiro;
    }
    
    public Local getDestino() {
    	return this.destino;
    }
}
