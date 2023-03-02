import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EsempiStream {

    public static void main(String[] args) throws IOException {

        List<Integer> numeri = new ArrayList<>();
        numeri.add(4);
        numeri.add(8);
        numeri.add(15);
        numeri.add(16);
        numeri.add(23);
        numeri.add(42);

        // se uso gli stream
        long count = numeri.stream().filter(x -> x > 15).count();
        System.out.println(count);

        // se uso la strategia classica
        int count2 = 0;
        for (Integer n : numeri) {
            if (n > 15) {
                count2++;
            }
        }
        System.out.println(count);

        // stream su un array
        String[] parole = { "ciao", "Java", "opinno", "coding", "programming", "Marco", "Tree", "coding" };
        Arrays.stream(parole).forEach(System.out::println);

        // massimo di un array
        int massimo = numeri.stream().max(Integer::compareTo).get();
        System.out.println("Il massimo è: " + massimo);

        System.out.println("-------------------------------------------------");
        System.out.println("Stampiamo tutte le parole che iniziano con la maiuscola:");
        // operazione di filtering: permette di filtrare in un nuovo stream gli elementi in base ad una proprietà (un predicato)
        List<String> paroleList = Arrays.asList(parole);
        // stampo tutte le parole che iniziano con la maiuscola
        paroleList.stream().filter( s -> Character.isUpperCase(s.charAt(0)) ).forEach(System.out::println);
        System.out.println("-------------------------------------------------");

        // operazione count: conta e ritorna sottoforma di long il numero di elementi dello stream
        System.out.println("Le parole che iniziano con la maiuscola sono:");
        long conteggio = paroleList.stream().filter( s -> Character.isUpperCase(s.charAt(0)) ).count();
        System.out.println(conteggio);

        System.out.println("------------------------------------------------");
        // utilizziamo uno stream per contare le righe di un file di testo
        try {
            System.out.println("Il file di testo contiene questo numero di righe:");
            long numeroRighe = Files.lines(Paths.get("module_11/resources/testuccio.txt")).count();
            System.out.println(numeroRighe);
            System.out.println("-----------------------------------------");
            System.out.println("Ora stampo riga per riga");
            Files.lines(Paths.get("module_11/resources/testuccio.txt")).forEach(System.out::println);
            // ora voglio stampare tutte le lunghezze di ogni singola riga
            System.out.println("-------------------------------------");
            System.out.println("Quanto è lunga ogni riga?");
            Files.lines(Paths.get("module_11/resources/testuccio.txt")).map(riga -> riga.length()).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------------");
        System.out.println("Ora stampiamo l'array di parole ordinato grazie a sorted():");
        paroleList.stream().sorted().forEach(System.out::println);
        System.out.println();
        System.out.println("Verifichiamo che la struttura originaria sia rimasta la stessa");
        System.out.println(paroleList);

        System.out.println("---------------------------------");
        System.out.println("tramite collect posso salvare i dati uscenti dallo stream dentro una collection");
        List<String> parole_ordinate = paroleList.stream().sorted().collect(Collectors.toList());
        System.out.println(parole_ordinate);
        System.out.println("----------------------------------");
        System.out.println("proviamo a vedere se il set elimina i duplicati");
        Set<String> paroleSet = paroleList.stream().collect(Collectors.toSet());
        System.out.println(paroleSet);

        System.out.println("--------------------------------------");
        System.out.println("voglio tornare una lista ordinata a partire di quella partenza senza i duplicati");
        List<String> paroleOrdinateNoDuplicati = paroleList.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList())
                                                                                        .stream().sorted().collect(Collectors.toList());
        System.out.println(paroleOrdinateNoDuplicati);

        System.out.println("---------------------------------------");
        System.out.println("uso il metodo distinct per eliminare i duplicati in uno stream (evitando il casino di prima)");
        paroleOrdinateNoDuplicati = paroleList.stream().distinct().collect(Collectors.toList());
        System.out.println(paroleOrdinateNoDuplicati);

        System.out.println("-----------------------------------------");
        System.out.println("utilizziamo la funzione limit() per leggere solamente alcune righe del file");
        Files.lines(Paths.get("module_11/resources/testuccio.txt")).limit(3).forEach(System.out::println);

        System.out.println("-----------------------------------------");
        System.out.println("salviamo in un nuovo array, usando map, tutte le stringhe in maiuscolo");
        List<String> maiuscole = paroleList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(maiuscole);

        System.out.println("----------------------------------------------");
        System.out.println("aggiungiamo il 20% di iva ad ognuno dei numeri precedenti e stampiamo");
        numeri.stream().map(n -> n*1.22).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        System.out.println("voglio mappare n con il suo fattoriale: creo quindi una funzione fattoriale in maniera imperativa tra le graffe");
        numeri.stream().map(n -> {
            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }).forEach(System.out::println);

        System.out.println("--------------------------------------------------");
        System.out.println("Torniamo una stringa con tutte le parole rese maiuscole concatenate con virgola e spazio");
        String concat = paroleList.stream().map(s -> s.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(concat);

        System.out.println("----------------------------------------------------");
        System.out.println("Prendiamo l'array di numeri e salviamo i risultati del fattoriale dentro una mappa numero = fattoriale(numero)");

        Map<Integer, Long> fattoriali = numeri.stream().collect(Collectors.toMap(Function.identity(), EsempiStream::fattoriale));
        System.out.println(fattoriali);

        System.out.println("------------------------------------------------------");
        System.out.println("Torniamo tramite un reduce il prodotto di tutti i numeri dell'array");
        int prodotto = numeri.stream().reduce(1, (a, b) -> a*b);
        System.out.println("il prodotto è: " + prodotto);

        System.out.println("------------------------------------");
        System.out.println("Concateniamo le stringhe con il reduce invece che con il Collectors.join");
        String concatena = paroleList.stream().reduce("", EsempiStream::concatena).substring(2);
        System.out.println(concatena);

        System.out.println("-----------------------------------");
        System.out.println("Testiamo i metodi anyMatch, allMatch, noneMatch");
        boolean first = numeri.stream().anyMatch(n -> n % 5 == 0);
        System.out.println("Esiste almento un numero divisibile per 5? " + first);
        // boolean second = paroleList.stream().map(p -> p.length()).allMatch(len -> len >= 4);
        boolean second = paroleList.stream().allMatch(p -> p.length() >= 4);
        System.out.println("Tutte le parole sono almeno lunghe 4? " + second);
        boolean third = paroleList.stream().noneMatch(p -> p.startsWith("j") || p.startsWith("J"));
        System.out.println("è vero che nessuna delle parole inizia con la j? " + third);

        System.out.println("---------------------------------------");
        System.out.println("Testiamo il findFirst()");
        Optional<String> result = paroleList.stream()
                .filter(s -> Character.isLowerCase(s.charAt(0)))
                .filter(s -> s.length() >= 5)
                .findFirst();
        System.out.println("La prima parola minuscola lunga almeno 5 è: " + result.get()); // result.get() perchè findFirst torna un Optional

        List<String> paroleList2 = Arrays.asList("Roma", "Barcelona", "Paris", "Milan", "Naples", "London");
        List<List<String>> tutteStringhe = Arrays.asList(paroleList, paroleList2);
        System.out.println(tutteStringhe);

        System.out.println("-------------------------------------");
        System.out.println("Voglio stampare tutte le stringhe in entrambi gli array che iniziano con la m o M");
        tutteStringhe.stream()
                .flatMap(array -> array.stream())
                .filter(s -> s.startsWith("M") || s.startsWith("m"))
                .forEach(System.out::println);


    }

    public static long fattoriale(int n) {
        if (n <= 1) return 1;
        else return n * fattoriale(n-1);
    }

    public static String concatena(String s1, String s2) {
        return s1 + ", " + s2;
    }

}
