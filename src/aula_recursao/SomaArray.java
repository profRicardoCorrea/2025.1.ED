package aula_recursao;

public class SomaArray {
    public static int soma(int[] array) {
        int soma = 0;
        for (int i = 0; i < array.length; i++) {
            soma += array[i];
        }
        return soma;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(soma(array)); // Saída: 15
    }
}
