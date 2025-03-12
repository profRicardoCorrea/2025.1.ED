package recursao;

public class FatorialSemRecursao {
	public static int fatorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(fatorial(5)); // Saída: 120
    }
}
