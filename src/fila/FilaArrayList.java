package fila;

import java.util.ArrayList;

public class FilaArrayList {
    private ArrayList<Integer> elementos;

    public FilaArrayList() {
        // Inicializa a lista que representará nossa fila
        this.elementos = new ArrayList<>();
    }

    // 1. insert ou enqueue - insere itens ao final da fila
    public void enqueue(int valor) {
        elementos.add(valor);
    }

    // 2. remove ou dequeue - retira o primeiro item (índice 0)
    public int dequeue() {
        if (empty()) {
            System.out.println("A fila está vazia! Não há elemento para remover.");
            return -1; // ou lance uma exceção
        }
        // remove(0) remove o primeiro elemento e desloca os demais
        return elementos.remove(0);
    }

    // 3. empty - verifica se a fila está vazia
    public boolean empty() {
        return elementos.isEmpty();
    }

    // 4. size - retorna o tamanho atual da fila
    public int size() {
        return elementos.size();
    }

    // 5. front - retorna o primeiro item da fila (sem removê-lo)
    public int front() {
        if (empty()) {
            System.out.println("A fila está vazia! Não há elemento no início.");
            return -1; // ou lance uma exceção
        }
        return elementos.get(0);
    }

    // Exemplo de uso
    public static void main(String[] args) {
        // Cria uma fila
        FilaArrayList fila = new FilaArrayList();

        System.out.println("A fila está vazia? " + fila.empty());

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Elemento (front): " + fila.front());
        System.out.println("Tamanho atual da fila: " + fila.size());

        int removido = fila.dequeue();
        System.out.println("Elemento removido (dequeue): " + removido);

        System.out.println("Elemento (front) após remoção: " + fila.front());
        System.out.println("Tamanho atual da fila: " + fila.size());
        System.out.println("A fila está vazia? " + fila.empty());
    }
}

