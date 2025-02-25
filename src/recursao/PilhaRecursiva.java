package recursao;

public class PilhaRecursiva  {

    private int valor;                 // Valor armazenado neste nó
    private PilhaRecursiva subPilha;   // Referência para o próximo nó (resto da pilha)

    // Construtor padrão (pode ser usado em cenários personalizados)
    public PilhaRecursiva() {
        this.subPilha = null;
    }

    // Construtor para criar um nó com valor e a "subPilha" ligada
    public PilhaRecursiva(int valor, PilhaRecursiva subPilha) {
        this.valor = valor;
        this.subPilha = subPilha;
    }

    // ------------------------------------
    // 1. PUSH (empilhar)
    // ------------------------------------
    // Retorna um novo topo de pilha que contém "novoValor", 
    // encadeado com o topo anterior.
    public static PilhaRecursiva push(PilhaRecursiva topo, int novoValor) {
        // Cria um novo nó, cujo subPilha aponta para o 'topo' antigo
        return new PilhaRecursiva(novoValor, topo);
    }

    // ------------------------------------
    // 2. POP (desempilhar)
    // ------------------------------------
    // Retorna o "novo topo" após remover o nó do topo anterior.
    public static PilhaRecursiva pop(PilhaRecursiva topo) {
        // Se a pilha estiver vazia, apenas avisa (ou lança exceção) e retorna null
        if (topo == null) {
            System.out.println("Pilha vazia! Não há o que desempilhar.");
            return null; // ou poderia lançar uma exceção
        }
        // "Remover" o topo é simplesmente avançar para topo.subPilha
        return topo.subPilha;
    }

    // ------------------------------------
    // 3. STACKPOP / TOP
    // ------------------------------------
    // Retorna o valor do topo, sem removê-lo.
    public static int stackpop(PilhaRecursiva topo) {
        if (topo == null) {
            System.out.println("Pilha vazia! Não há elemento no topo.");
            return -1; // ou lançar exceção
        }
        return topo.valor;
    }

    // ------------------------------------
    // 4. SIZE (tamanho)
    // ------------------------------------
    // Retorna a quantidade de nós na pilha, via recursão.
    public static int size(PilhaRecursiva topo) {
        // Se for nulo, a pilha está vazia; tamanho = 0
        if (topo == null) {
            return 0;
        }
        // Tamanho é 1 (este nó) + tamanho da subPilha
        return 1 + size(topo.subPilha);
    }

    // ------------------------------------
    // 5. EMPTY (verifica se está vazia)
    // ------------------------------------
    public static boolean empty(PilhaRecursiva topo) {
        // Se topo == null, então não há nós
        return (topo == null);
    }

    // -----------------------------------------------------------------------
    // Exemplo de uso/teste no método main
    // -----------------------------------------------------------------------
    public static void main(String[] args) {

        // A pilha será representada pela referência 'topo'.
        // Se for null, significa que está vazia.
        PilhaRecursiva topo = null;

        // A pilha está vazia no início
        System.out.println("Pilha está vazia? " + empty(topo));

        // PUSH de alguns valores
        topo = push(topo, 10);
        topo = push(topo, 20);
        topo = push(topo, 30);

        System.out.println("Tamanho da pilha: " + size(topo));
        System.out.println("Topo da pilha (stackpop): " + stackpop(topo));

        // POP remove o elemento do topo
        topo = pop(topo);
        System.out.println("Novo topo após pop: " + stackpop(topo));
        System.out.println("Tamanho agora: " + size(topo));

        // Verifica novamente se está vazia
        System.out.println("Pilha está vazia? " + empty(topo));
    }
}
 
