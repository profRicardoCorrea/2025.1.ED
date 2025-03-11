package pilha;

public class PilhaVetor {
	 
	    private int[] elementos;  // Array para armazenar os valores da pilha
	    private int topo;         // Índice do último elemento inserido
	    
	    // Construtor - define o tamanho máximo da pilha
	    public PilhaVetor(int capacidade) {
	        this.elementos = new int[capacidade];
	        this.topo = -1; // indica que a pilha está inicialmente vazia
	    }
	    
	    // 1. push - coloca (empilha) um valor no topo da pilha
	    public void push(int valor) {
	        // Verifica se a pilha está cheia
	        if (topo == elementos.length - 1) {
	            System.out.println("A pilha está cheia! Não é possível inserir o elemento " + valor);
	            return;
	        }
	        topo++;
	        elementos[topo] = valor;
	    }
	    
	    // 2. pop - retira (desempilha) o valor do topo da pilha e o retorna
	    public int pop() {
	        // Verifica se a pilha está vazia
	        if (empty()) {
	            System.out.println("A pilha está vazia! Não há elemento para remover.");
	            // Em um cenário real, você poderia lançar uma exceção
	            return -1; 
	        }
	        int valorRemovido = elementos[topo];
	        topo--;
	        return valorRemovido;
	    }
	    
	    // 3. size - retorna o tamanho atual da pilha (quantos elementos estão armazenados)
	    public int size() {
	        return topo + 1; 
	    }
	    
	    // 4. stackpop (peek) - retorna o elemento do topo sem removê-lo
	    public int stackpop() {
	        // Verifica se a pilha está vazia
	        if (empty()) {
	            System.out.println("A pilha está vazia! Não há elemento no topo.");
	            // Em um cenário real, você poderia lançar uma exceção
	            return -1; 
	        }
	        return elementos[topo];
	    }
	    
	    // 5. empty - verifica se a pilha está vazia
	    public boolean empty() {
	        return (topo == -1);
	    }
	    
	    // Exemplo de uso
	    public static void main(String[] args) {
	        // Cria uma pilha com capacidade para 5 elementos
	    	PilhaVetor pilha = new PilhaVetor(5);
	        
	        System.out.println("Pilha está vazia? " + pilha.empty());
	        
	        pilha.push(10);
	        pilha.push(20);
	        pilha.push(30);
	        System.out.println("Elemento no topo (stackpop): " + pilha.stackpop());
	        System.out.println("Tamanho atual: " + pilha.size());
	        
	        int removido = pilha.pop();
	        System.out.println("Elemento removido (pop): " + removido);
	        
	        System.out.println("Elemento no topo agora: " + pilha.stackpop());
	        System.out.println("Tamanho atual: " + pilha.size());
	        
	        System.out.println("Pilha está vazia? " + pilha.empty());
	    }
	}
