package lista_encadeada;

//ListaSimplesmenteEncadeada.java
public class ListaSimplesmenteEncadeada<T> {

 private static class No<T> {
     T dado;
     No<T> proximo;

     No(T dado) {
         this.dado = dado;
         this.proximo = null;
     }
 }

 private No<T> cabeca;
 private int tamanho;

 public ListaSimplesmenteEncadeada() {
     this.cabeca = null;
     this.tamanho = 0;
 }

 /**
  * Adiciona um elemento ao final da lista.
  * @param dado O elemento a ser adicionado.
  */
 public void adicionar(T dado) {
     No<T> novoNo = new No<>(dado);
     if (estaVazia()) {
         cabeca = novoNo;
     } else {
         No<T> atual = cabeca;
         while (atual.proximo != null) {
             atual = atual.proximo;
         }
         atual.proximo = novoNo;
     }
     tamanho++;
 }

 /**
  * Adiciona um elemento no início da lista.
  * @param dado O elemento a ser adicionado.
  */
 public void adicionarNoInicio(T dado) {
     No<T> novoNo = new No<>(dado);
     novoNo.proximo = cabeca;
     cabeca = novoNo;
     tamanho++;
 }

 /**
  * Remove o primeiro elemento da lista.
  * @return O elemento removido.
  * @throws IllegalStateException se a lista estiver vazia.
  */
 public T removerDoInicio() {
     if (estaVazia()) {
         throw new IllegalStateException("A lista está vazia.");
     }
     T dadoRemovido = cabeca.dado;
     cabeca = cabeca.proximo;
     tamanho--;
     return dadoRemovido;
 }

  /**
  * Remove a primeira ocorrência do elemento especificado da lista, se presente.
  * @param dado O elemento a ser removido.
  * @return true se o elemento foi removido, false caso contrário.
  */
 public boolean remover(T dado) {
     if (estaVazia()) {
         return false;
     }

     if (cabeca.dado.equals(dado)) {
         removerDoInicio();
         return true;
     }

     No<T> atual = cabeca;
     while (atual.proximo != null && !atual.proximo.dado.equals(dado)) {
         atual = atual.proximo;
     }

     if (atual.proximo != null) { // Encontrou o elemento
         atual.proximo = atual.proximo.proximo;
         tamanho--;
         return true;
     }

     return false; // Elemento não encontrado
 }

 /**
  * Retorna o elemento na posição especificada na lista.
  * @param indice O índice do elemento a ser retornado (baseado em zero).
  * @return O elemento no índice especificado.
  * @throws IndexOutOfBoundsException se o índice for inválido.
  */
 public T get(int indice) {
     if (indice < 0 || indice >= tamanho) {
         throw new IndexOutOfBoundsException("Índice inválido: " + indice);
     }
     No<T> atual = cabeca;
     for (int i = 0; i < indice; i++) {
         atual = atual.proximo;
     }
     return atual.dado;
 }


 /**
  * Verifica se a lista está vazia.
  * @return true se a lista estiver vazia, false caso contrário.
  */
 public boolean estaVazia() {
     return cabeca == null; // ou tamanho == 0
 }

 /**
  * Retorna o número de elementos na lista.
  * @return O tamanho da lista.
  */
 public int tamanho() {
     return tamanho;
 }

 @Override
 public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("[");
     No<T> atual = cabeca;
     while (atual != null) {
         sb.append(atual.dado);
         if (atual.proximo != null) {
             sb.append(", ");
         }
         atual = atual.proximo;
     }
     sb.append("]");
     return sb.toString();
 }

 // Exemplo de uso (opcional)
 public static void main(String[] args) {
     ListaSimplesmenteEncadeada<String> lista = new ListaSimplesmenteEncadeada<>();
     lista.adicionar("A");
     lista.adicionar("B");
     lista.adicionarNoInicio("C");
     lista.adicionar("D");

     System.out.println("Lista: " + lista); // Saída: Lista: [C, A, B, D]
     System.out.println("Tamanho: " + lista.tamanho()); // Saída: Tamanho: 4
     System.out.println("Elemento no índice 2: " + lista.get(2)); // Saída: Elemento no índice 2: B

     lista.remover("B");
     System.out.println("Lista após remover 'B': " + lista); // Saída: Lista após remover 'B': [C, A, D]

     lista.removerDoInicio();
     System.out.println("Lista após remover do início: " + lista); // Saída: Lista após remover do início: [A, D]

     System.out.println("A lista está vazia? " + lista.estaVazia()); // Saída: A lista está vazia? false
     
     
     ListaSimplesmenteEncadeada<Pessoa> listaPessoa = new ListaSimplesmenteEncadeada<>();
     listaPessoa.adicionar(new Pessoa("Fuka",2));
     listaPessoa.adicionar(new Pessoa("Erty",3));
     listaPessoa.adicionarNoInicio(new Pessoa("Lik",4));
     listaPessoa.adicionar(new Pessoa("Fuka",1));
     System.out.println(listaPessoa.get(0).nome);
     System.out.println(listaPessoa.get(1).nome);
     System.out.println(listaPessoa.get(2).nome);
     System.out.println(listaPessoa.get(3).nome);
     System.out.println(listaPessoa.toString());
     listaPessoa.remover(new Pessoa("Lik",4));
     System.out.println(listaPessoa.toString());
     
 
 }
}
