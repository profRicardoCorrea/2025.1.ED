package recursao;

public class FatorialRecursivo {
    public static int fatorial(int n) {
        if (n == 0) { // Caso base
            return 1;
        } else { // Caso recursivo
            return n * fatorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fatorial(5)); // Saída: 120
    }
}