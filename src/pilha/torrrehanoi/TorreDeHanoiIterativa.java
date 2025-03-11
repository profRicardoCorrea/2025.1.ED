package pilha.torrrehanoi;

public class TorreDeHanoiIterativa {

    // Método auxiliar para imprimir o "movimento" que foi feito
    private static void exibirMovimento(int disco, char origem, char destino) {
        System.out.println("Movendo disco " + disco + " de " + origem + " para " + destino);
    }

    // Move um disco entre duas pilhas, respeitando a regra de "disco menor em cima de disco maior".
    // Retorna true se houve movimento do 'origem' -> 'destino', ou false se foi ao contrário.
    private static boolean moverEntreDuasPilhas(Pilha origem, Pilha destino, char nomeOrigem, char nomeDestino) {
        int topoOrigem = origem.stackpop(); // -1 se vazio
        int topoDestino = destino.stackpop(); // -1 se vazio

        // Caso 1: origem está vazia -> obrigatoriamente pega da 'destino' e move para 'origem'
        if (topoOrigem == -1) {
            // recoloca o pop do destino, pois apenas "olhamos"
            destino.pop(); // remove de fato
            origem.push(topoDestino);
            exibirMovimento(topoDestino, nomeDestino, nomeOrigem);
            return false; 
        }
        // Caso 2: destino está vazio -> move da 'origem' para 'destino'
        else if (topoDestino == -1) {
            origem.pop(); 
            destino.push(topoOrigem);
            exibirMovimento(topoOrigem, nomeOrigem, nomeDestino);
            return true; 
        }
        else {
            // Ambos têm discos: devolver "pop" real
            origem.pop();
            destino.pop();

            // Comparar para ver quem fica por cima
            if (topoOrigem > topoDestino) {
                // topoOrigem é maior -> então devolve topoOrigem para origem, 
                // e move topoDestino para origem
                origem.push(topoOrigem); // devolve
                origem.push(topoDestino);
                exibirMovimento(topoDestino, nomeDestino, nomeOrigem);
                return false;
            } else {
                // topoDestino é maior ou igual -> então devolve topoDestino para destino, 
                // e move topoOrigem para destino
                destino.push(topoDestino); 
                destino.push(topoOrigem);
                exibirMovimento(topoOrigem, nomeOrigem, nomeDestino);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3; // número de discos (pode trocar para testar)

        // Cria as 3 pilhas (hastes) com capacidade = n (ou mais, se desejar segurança)
        Pilha A = new Pilha(n);
        Pilha B = new Pilha(n);
        Pilha C = new Pilha(n);

        // Inicializa a pilha A com discos [n, n-1, ..., 2, 1] 
        // de forma que 1 seja o topo (o menor disco)
        for (int disco = n; disco >= 1; disco--) {
            A.push(disco);
        }

        // Se n é ímpar, a ordem de movimentos cíclicos é (A->C), (A->B), (B->C)
        // Se n é par, a ordem é (A->B), (A->C), (B->C)
        char pinoA = 'A';
        char pinoB = 'B';
        char pinoC = 'C';

        int totalMovimentos = (int) (Math.pow(2, n) - 1);

        if (n % 2 == 0) {
            // inverte pinoB e pinoC para seguir a convenção do método iterativo
            char tmp = pinoB;
            pinoB = pinoC;
            pinoC = tmp;
        }

        // Executa (2^n - 1) movimentos
        for (int i = 1; i <= totalMovimentos; i++) {
            if (i % 3 == 1) {
                // Move entre A e C
                moverEntreDuasPilhas(A, C, pinoA, pinoC);
            } else if (i % 3 == 2) {
                // Move entre A e B
                moverEntreDuasPilhas(A, B, pinoA, pinoB);
            } else {
                // Move entre B e C
                moverEntreDuasPilhas(B, C, pinoB, pinoC);
            }
        }
    }
}
