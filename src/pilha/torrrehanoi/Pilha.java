package pilha.torrrehanoi;

public class Pilha {
    private int[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        this.elementos = new int[capacidade];
        this.topo = -1;
    }

    public void push(int valor) {
        if (topo == elementos.length - 1) {
            System.out.println("Pilha cheia! Não é possível inserir " + valor);
        } else {
            topo++;
            elementos[topo] = valor;
        }
    }

    public int pop() {
        if (empty()) {
            return -1; // ou lançar exceção
        }
        int valor = elementos[topo];
        topo--;
        return valor;
    }

    public int stackpop() { // ou peek()
        if (empty()) {
            return -1;
        }
        return elementos[topo];
    }

    public boolean empty() {
        return (topo == -1);
    }

    public int size() {
        return topo + 1;
    }
}

