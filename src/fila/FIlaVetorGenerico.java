package fila;

public class FIlaVetorGenerico<E> {
	private E[] elementos;
	private int capacidade; // Tamanho máximo da fila
	private int inicio; // Índice do primeiro elemento
	private int fim; // Índice do último elemento
	private int tamanho; // Quantidade de elementos na fila

	// Construtor: cria uma fila com a capacidade fornecida
	public FIlaVetorGenerico(int capacidade) {
		this.capacidade = capacidade;
		this.elementos = (E[]) new Object[capacidade];
		this.inicio = 0;
		this.fim = -1;
		this.tamanho = 0;
	}

	// 1. insert ou enqueue
	public void enqueue(E valor) {
		// Verifica se a fila está cheia
		if (tamanho == capacidade) {
			System.out.println("A fila está cheia! Não é possível inserir " + valor);
			return;
		}
		// Incrementa 'fim' de forma circular
		fim = (fim + 1) % capacidade;
		elementos[fim] = valor;
		tamanho++;
	}

	// 2. remove ou dequeue
	public E dequeue() {
		// Verifica se a fila está vazia
		if (empty()) {
			System.out.println("A fila está vazia! Não há elemento para remover.");
			return null; // ou lance uma exceção, por exemplo: throw new RuntimeException("Fila vazia");
		}
		E valorRemovido = elementos[inicio];
		// Incrementa 'inicio' de forma circular
		inicio = (inicio + 1) % capacidade;
		tamanho--;
		return valorRemovido;
	}

	// 3. empty - verifica se a fila está vazia
	public boolean empty() {
		return (tamanho == 0);
	}

	// 4. size - retorna o tamanho atual da fila
	public int size() {
		return tamanho;
	}

	// 5. front - retorna o primeiro item da fila (sem removê-lo)
	public E front() {
		// Verifica se a fila está vazia
		if (empty()) {
			System.out.println("A fila está vazia! Não há elemento no início.");
			return null; // ou lance uma exceção
		}
		return elementos[inicio];
	}

	// Exemplo de uso
	public static void main(String[] args) {
		// Cria uma fila com capacidade para 5 elementos
		FIlaVetorGenerico<Pessoa> fila = new FIlaVetorGenerico<Pessoa>(5);

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    		System.out.println("Fila está vazia? " + fila.empty());

		fila.enqueue(new Pessoa("A"));
		fila.enqueue(new Pessoa("B"));
		fila.enqueue(new Pessoa("C"));
		fila.enqueue(new Pessoa("D"));
		fila.enqueue(new Pessoa("E"));
		System.out.println("Tamanho atual da fila: " + fila.size());
		System.out.println("Elemento (front): " + fila.front().nome);

		Pessoa removido = fila.dequeue();
		System.out.println("Elemento removido (dequeue): " + removido.nome);

		System.out.println("Elemento (front) após remoção: " + fila.front().nome);
		System.out.println("Tamanho atual da fila: " + fila.size());

		System.out.println("Fila está vazia? " + fila.empty());
	}
}
