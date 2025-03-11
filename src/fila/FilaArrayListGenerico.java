package fila;

import java.util.ArrayList;

public class FilaArrayListGenerico<E> {
    private ArrayList<E> elementos;

    public FilaArrayListGenerico() {
        // Inicializa a lista que representará nossa fila
        this.elementos = new ArrayList<>();
    }

    // 1. insert ou enqueue - insere itens ao final da fila
    public void enqueue(E valor) {
        elementos.add(valor);
    }

    // 2. remove ou dequeue - retira o primeiro item (índice 0)
    public E dequeue() {
        if (empty()) {
            System.out.println("A fila está vazia! Não há elemento para remover.");
            return null; // ou lance uma exceção
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
    public E front() {
        if (empty()) {
            System.out.println("A fila está vazia! Não há elemento no início.");
            return null; // ou lance uma exceção
        }
        return elementos.get(0);
    }

    // Exemplo de uso
    public static void main(String[] args) {
        // Cria uma fila
        FilaArrayListGenerico<Pessoa> fila = new FilaArrayListGenerico();

        System.out.println("A fila está vazia? " + fila.empty());

        fila.enqueue(new Pessoa("A"));
        fila.enqueue(new Pessoa("B"));
        fila.enqueue(new Pessoa("C"));
        fila.enqueue(new Pessoa("D"));
        fila.enqueue(new Pessoa("E"));

        System.out.println("Elemento (front): " + fila.front().nome);
        System.out.println("Tamanho atual da fila: " + fila.size());

        Pessoa removido = fila.dequeue();
        System.out.println("Elemento removido (dequeue): " + removido.nome);

        System.out.println("Elemento (front) após remoção: " + fila.front().nome);
        System.out.println("Tamanho atual da fila: " + fila.size());
        System.out.println("A fila está vazia? " + fila.empty());
    }
}

