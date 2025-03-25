package recursao;

public class SomaArrayRecursivo {
    public static int soma(int[] array, int index) {
        if (index == array.length) { // Caso base
            return 0;
        } else { // Caso recursivo
            return array[index] + soma(array, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(soma(array, 0)); // Saída: 15
    }
}
