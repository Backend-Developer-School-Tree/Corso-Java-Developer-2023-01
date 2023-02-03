import java.util.Arrays;

public class Ricorsione {
    public static void main(String[] args) {
        fattoriale(5);
        System.out.println(sommaIterativa(new int[]{1,2,3,4}));
        System.out.println(sommaRicorsiva(new int[]{1,2,3,4}));
        System.out.println(sommaRicorsiva2(new int[]{1,2,3,4}));
    }

    public static int fattoriale(int n) {
        if (n < 0) throw new RuntimeException("Valore non supportato");
        if (n == 0 || n == 1) return n;
        return n * fattoriale(n - 1);
    }

    public static int sommaIterativa(int[] array) {
        int tot = 0;
        for (int i = 0; i < array.length; i++) tot += array[i];
        return tot;
    }

    public static int sommaRicorsiva(int[] array) {
        if (array.length == 1) return array[0];
        return array[array.length - 1] + sommaRicorsiva(Arrays.copyOf(array, array.length - 1));
    }

    public static int sommaRicorsiva2(int[] array) {
        return sommaRicorsiva2(array, array.length - 1);
    }

    public static int sommaRicorsiva2(int[] array, int indice) {
        if (indice == 0) return array[0];
        return array[indice] + sommaRicorsiva2(array, indice - 1);
    }
}
