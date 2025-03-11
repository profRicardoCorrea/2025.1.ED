package pilha;

import java.util.ArrayList;

public class PilhaArrayList {
	private ArrayList<Integer> elementos;

	public PilhaArrayList() {
		// Inicia a lista vazia
		this.elementos = new ArrayList<>();
	}

	// 1. push - coloca (empilha) um valor no topo da pilha
	public void push(int valor) {
		elementos.add(valor);
	}

	// 2. pop - retira (desempilha) o valor do topo da pilha e o retorna
	public int pop() {
		if (empty()) {
			System.out.println("A pilha está vazia! Não há elemento para remover.");
			return -1; // ou pode lançar uma exceção
		}
		// O topo está no último índice da lista
		return elementos.remove(elementos.size() - 1);
	}

	// 3. size - retorna o tamanho atual da pilha
	public int size() {
		return elementos.size();
	}

	// 4. stackpop (peek) - retorna o elemento do topo sem removê-lo
	public int stackpop() {
		if (empty()) {
			System.out.println("A pilha está vazia! Não há elemento no topo.");
			return -1; // ou pode lançar uma exceção
		}
		return elementos.get(elementos.size() - 1);
	}

	// 5. empty - verifica se a pilha está vazia
	public boolean empty() {
		return elementos.isEmpty();
	}

	// Exemplo de uso
	public static void main(String[] args) {
		PilhaArrayList pilha = new PilhaArrayList();

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
