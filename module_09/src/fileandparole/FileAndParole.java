package fileandparole;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Questa classe contiene una serie di metodi per elaborare file di testo
 */
public class FileAndParole {

    /**
     * Questo metodo prende in input il nome di un file di testo contenente una sequenza
     * di parole e stampa riga per riga le parole stesse.
     *
     * @param file nome di un file di testo
     */
    public static void stampaParole(Path file) throws IOException {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String parola = s.next();
            System.out.println(parola);
        }
    }

    /**
     * Questo metodo prende in input il nome di un file di testo contenente parole
     * (tutte minuscole e senza punteggiatura) e ritorna un dizionario contenente come chiavi
     * le parole e come valore le occorrenze delle parole nel testo.
     *
     * @param file nome di un file di testo
     * @return un dizionario contenente le occorrenze delle parole
     */
    public static Map<String, Integer> occorrenzeParole(Path file) throws IOException {
        Scanner s = new Scanner(file);
        Map<String, Integer> diz = new HashMap<>();
        while (s.hasNext()) {
            String parola = s.next();
            if (!diz.containsKey(parola)) {
                diz.put(parola, 1);
            } else {
                Integer val = diz.get(parola);
                diz.put(parola, val + 1);
            }
        }
        return diz;
    }

    /**
     * Questo metodo prende in input il nome di un file di testo contenente parole
     * (tutte minuscole e senza punteggiatura) e ritorna un dizionario contenente come chiavi
     * le parole e come valore le occorrenze delle parole nel testo.
     *
     * @param file nome di un file di testo
     * @return un dizionario contenente le occorrenze delle parole in minuscolo e tolta la punteggiature
     */
    public static Map<String, Integer> occorrenzeParoleTesto(Path file) throws IOException {
        Scanner s = new Scanner(file);
        Map<String, Integer> diz = new HashMap<>();
        while (s.hasNext()) {
            String parole = s.nextLine();
            String[] split = parole.split("\\W+");
            for (String parola: split) {
                if (!diz.containsKey(parola)){
                    diz.put(parola, 1);
                }
                else {
                    Integer val = diz.get(parola);
                    diz.put(parole, val + 1);
                }
            }
        }
        return diz;
    }

}
