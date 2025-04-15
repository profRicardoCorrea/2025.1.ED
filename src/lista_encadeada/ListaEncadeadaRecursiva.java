package lista_encadeada;

public class ListaEncadeadaRecursiva<T> {
	 // Classe interna Node que representa cada elemento da lista.
    private static class Node<T> {
        T info;
        Node<T> next;
        
        Node(T info) {
            this.info = info;
            this.next = null;
        }
    }
    
    // Ponteiro para o primeiro nó (cabeça da lista)
    private Node<T> head;
    // Ponteiro "atual" que indica o nó corrente
    private Node<T> current;
    
    // Construtor: inicializa a lista vazia.
    public ListaEncadeadaRecursiva() {
        head = null;
        current = null;
    }
    
    /**
     * Método add: adiciona uma informação no final da lista.
     * Se a lista estiver vazia, cria o primeiro nó e atualiza o ponteiro atual.
     */
    public void add(T info) {
        if (head == null) {
            head = new Node<>(info);
            current = head; // ponteiro atual aponta para o primeiro nó
        } else {
            addRec(head, info);
        }
    }
    
    // Método auxiliar recursivo para percorrer a lista até o final e adicionar o novo nó.
    private void addRec(Node<T> node, T info) {
        if (node.next == null) {
            node.next = new Node<>(info);
        } else {
            addRec(node.next, info);
        }
    }
    
    /**
     * Método insert: insere uma informação em uma determinada posição (índice 0-base).
     * Se pos for 0 ou se a lista estiver vazia, o novo nó se torna a nova cabeça da lista.
     * Caso pos seja maior que o tamanho atual, a inserção ocorrerá no final da lista.
     */
    public void insert(T info, int pos) {
        head = insertRec(head, info, pos);
        // Se a inserção ocorreu na posição zero, atualiza o ponteiro current.
        if (pos == 0) {
            current = head;
        }
    }
    
    // Método auxiliar recursivo para inserir o novo nó na posição correta.
    private Node<T> insertRec(Node<T> node, T info, int pos) {
        if (pos <= 0 || node == null) {
            // Cria um novo nó e o insere antes do nó atual
            Node<T> newNode = new Node<>(info);
            newNode.next = node;
            return newNode;
        } else {
            node.next = insertRec(node.next, info, pos - 1);
            return node;
        }
    }
    
    /**
     * Método delete: deleta o nó apontado pelo ponteiro atual (current).
     * Se current apontar para a cabeça da lista, atualiza a cabeça.
     * Caso contrário, busca recursivamente o nó anterior para ajustar os ponteiros.
     */
    public void delete() {
        if (head == null || current == null) {
            // Lista vazia ou ponteiro atual inválido; nada a deletar.
            return;
        }
        
        if (current == head) {
            // Se o nó atual é o primeiro, basta avançar a cabeça para o próximo nó.
            head = head.next;
            current = head;
        } else {
            // Encontra o nó imediatamente anterior ao current de forma recursiva.
            Node<T> prev = findPrevious(head, current);
            if (prev != null) {
                prev.next = current.next;
                // Atualiza o ponteiro current para o próximo nó ou reinicia para o início se estiver no fim.
                current = (prev.next != null) ? prev.next : head;
            }
        }
    }
    
    // Método auxiliar recursivo para encontrar o nó anterior de "child" a partir de "node".
    private Node<T> findPrevious(Node<T> node, Node<T> child) {
        if (node == null || node.next == null) {
            return null;
        }
        if (node.next == child) {
            return node;
        }
        return findPrevious(node.next, child);
    }
    
    /**
     * Método info: retorna a informação do nó apontado pelo ponteiro atual.
     * Caso não haja nó atual (lista vazia), retorna null.
     */
    public T info() {
        if (current != null) {
            return current.info;
        }
        return null;
    }
    
    /**
     * Método next: desloca o ponteiro atual para o próximo nó, se existir.
     * Se current for o último elemento, nada acontece.
     */
    public void next() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }
    
    /**
     * Método last: reinicia o ponteiro atual para o início da lista.
     */
    public void last() {
        current = head;
    }
    
    // Método extra que imprime a lista completa, útil para testes e depuração.
    public void printList() {
        printRec(head);
        System.out.println();
    }
    
    // Impressão recursiva da lista.
    private void printRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.info + " ");
            printRec(node.next);
        }
    }
    
    // Método main para testes simples.
    public static void main(String[] args) {
        // Cria uma lista de inteiros
        ListaEncadeadaRecursiva<Integer> lista = new ListaEncadeadaRecursiva<>();
        
        // Adiciona elementos ao final da lista
        lista.add(10);
        lista.add(20);
        lista.add(30);
        System.out.print("Após add: ");
        lista.printList();  // Saída esperada: 10 20 30
        
        // Insere um elemento (15) na posição 1 (entre 10 e 20)
        lista.insert(15, 1);
        System.out.print("Após insert(15, 1): ");
        lista.printList();  // Saída esperada: 10 15 20 30
        
        // Reinicia o ponteiro atual para o início e avança uma posição
        lista.last();
        lista.next();  // O ponteiro atual deve apontar para o 15
        System.out.println("Info atual: " + lista.info());  // Saída esperada: 15
        
        // Deleta o nó apontado pelo ponteiro atual (15)
        lista.delete();
        System.out.print("Após delete (removendo 15): ");
        lista.printList();  // Saída esperada: 10 20 30
        
        // Verifica o nó atual após a deleção
        System.out.println("Info atual após delete: " + lista.info());
    }
}
