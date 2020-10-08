package main.java.pilha.ListaLigada;

public class PilhaLigada {
    private No cabeca;

    public PilhaLigada() {
        this.cabeca = new No(0);
        cabeca.setCabeca(true);
        cabeca.setProx(null);
    }

    public void add(int identificador){
        No novo = new No(identificador);
        novo.setCabeca(true);
        cabeca.setCabeca(false);
        novo.setProx(cabeca);
        cabeca = novo;
    }

    public int remove(){
        int identificador = cabeca.getIdentificador();
        No antiga = cabeca;
        cabeca.setCabeca(false);
        cabeca = cabeca.getProx();
        antiga.setProx(null);
        cabeca.setCabeca(true);
        return identificador;
    }
}
