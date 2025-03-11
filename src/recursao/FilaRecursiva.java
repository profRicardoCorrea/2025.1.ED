package recursao;

public class FilaRecursiva {
    private int valor;                 // Valor armazenado neste nó
    private FilaRecursiva proximo;     // Referência para o próximo nó da fila

    // Construtor padrão
    public FilaRecursiva() {
        this.proximo = null;
    }

    // Construtor que define valor e encadeia o próximo nó
    public FilaRecursiva(int valor, FilaRecursiva proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }

    // ---------------------------------------------------------
    // 1. ENQUEUE (inserir ao final da fila)
    // ---------------------------------------------------------
    // Retorna o novo início da fila após inserir 'novoValor'.
    public static FilaRecursiva enqueue(FilaRecursiva inicio, int novoValor) {
        // Se a fila estiver vazia (inicio == null), 
        // o novo nó será o início e também o final.
        if (inicio == null) {
            return new FilaRecursiva(novoValor, null);
        }
        // Caso contrário, insere recursivamente ao final
        inicio.proximo = enqueue(inicio.proximo, novoValor);
        return inicio;
    }

    // ---------------------------------------------------------
    // 2. DEQUEUE (remover do início da fila)
    // ---------------------------------------------------------
    // Retorna o novo início após remover o nó que estava na frente.
    public static FilaRecursiva dequeue(FilaRecursiva inicio) {
        // Se a fila estiver vazia
        if (inicio == null) {
            System.out.println("A fila está vazia! Não há elemento para remover.");
            return null; // ou lançar exceção
        }
        // "Remover" o primeiro nó é simplesmente retornar "inicio.proximo"
        return inicio.proximo;
    }

    // ---------------------------------------------------------
    // 3. FRONT (consultar o primeiro elemento, sem remover)
    // ---------------------------------------------------------
    public static int front(FilaRecursiva inicio) {
        if (inicio == null) {
            System.out.println("A fila está vazia! Não há elemento na frente.");
            return -1; // ou lançar exceção
        }
        return inicio.valor;
    }

    // ---------------------------------------------------------
    // 4. SIZE (tamanho da fila)
    // ---------------------------------------------------------
    public static int size(FilaRecursiva inicio) {
        // Fila vazia?
        if (inicio == null) {
            return 0;
        }
        // Tamanho = 1 (este nó) + tamanho da subfila (recursão)
        return 1 + size(inicio.proximo);
    }

    // ---------------------------------------------------------
    // 5. EMPTY (verifica se a fila está vazia)
    // ---------------------------------------------------------
    public static boolean empty(FilaRecursiva inicio) {
        return (inicio == null);
    }

    // ---------------------------------------------------------
    // Exemplo de uso no método main
    // ---------------------------------------------------------
    public static void main(String[] args) {
        // 'inicio' será a referência para o primeiro nó da fila.
        // Se for null, significa fila vazia.
        FilaRecursiva inicio = null;

        System.out.println("A fila está vazia? " + empty(inicio));

        // ENQUEUE de alguns valores
        inicio = enqueue(inicio, 10);
        inicio = enqueue(inicio, 20);
        inicio = enqueue(inicio, 30);

        System.out.println("Tamanho da fila: " + size(inicio));
        System.out.println("Primeiro elemento (front): " + front(inicio));

        // DEQUEUE remove o primeiro elemento
        inicio = dequeue(inicio);
        System.out.println("Novo primeiro elemento após dequeue: " + front(inicio));
        System.out.println("Tamanho da fila agora: " + size(inicio));

        System.out.println("A fila está vazia? " + empty(inicio));
    }
}

