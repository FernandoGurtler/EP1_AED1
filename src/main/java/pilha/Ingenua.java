package main.java.pilha;

public class Ingenua {
    protected final int MAX = 1000000;
    protected Integer[] pilha;

    public Ingenua() {
        this.pilha = new Integer[MAX];
    }

    public void add(int newElement) {
        int i;
        for (i = 0; this.pilha[i] != null; i++) ;
        pilha[i] = newElement;

    }

    public int remove() {
        int i;
        for (i = 0; pilha[i] != null; i++) ;
        int tmp = pilha[i - 1];
        pilha[i - 1] = null;
        return tmp;
    }
}
