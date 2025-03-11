package pilha.torrrehanoi;

public class TorreHanoiSimples {

    /**
     * Move n discos da haste origem para a haste destino, usando auxiliar como apoio.
     *
     * @param n      número de discos
     * @param origem haste de origem
     * @param destino haste de destino
     * @param auxiliar haste auxiliar
     */
    public static void moverDiscos(int n, char origem, char destino, char auxiliar) {
        // Caso base: se há apenas 1 disco, move diretamente
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }
        // Passo 1: mover n-1 discos da origem para a haste auxiliar
        moverDiscos(n - 1, origem, auxiliar, destino);

        // Passo 2: mover o último disco (o maior) diretamente da origem para o destino
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);

        // Passo 3: mover os n-1 discos da haste auxiliar para a haste destino
        moverDiscos(n - 1, auxiliar, destino, origem);
    }

    public static void main(String[] args) {
        int n = 3; // Número de discos
        int qtd_movimentos=(int) (Math.pow(2, n) - 1);
        System.out.println("QTD Movimentos Necessarios:"+qtd_movimentos);
        moverDiscos(n, 'A', 'C', 'B');
        // Observação: 'A' é origem, 'C' é destino e 'B' é auxiliar
    }
}

