package esempi;

public class Overloading {

    public static void main(String[] args) {
        // in Java fare overloading significa ridefinire la stessa funzione con diversi parametri o tipi di ritorno
        // ad esempio esistono molte "versioni" del println, ognuna con un diverso tipo di parametro (es. int, char, String, ...)
        System.out.println(1);
        System.out.println(1.0);
        System.out.println('1');
        System.out.println("1");

        System.out.println(somma(1,2));
        System.out.println(somma("1", "2"));
    }

    // funzione che somma due interi
    public static int somma(int a, int b) {
        return a + b;
    }

    // funzione che "somma" due stringhe (overloading della funzione di somma dei due interi)
    public static String somma(String a, String b) {
        return a + " " + b;
    }
}
