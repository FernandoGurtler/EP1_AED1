package main.java.pilha.ListaLigada;

public class No {

    boolean cabeca;
    private No prox;
    private int identificador;

    public No(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public boolean isCabeca() {
        return cabeca;
    }

    public void setCabeca(boolean cabeca) {
        this.cabeca = cabeca;
    }

    @Override
    public String toString() {
        return Integer.toString(identificador);
    }
}
