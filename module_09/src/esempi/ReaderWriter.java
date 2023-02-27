package esempi;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class ReaderWriter {

    /**
     * Metodo inefficiente per leggere da file tramite la classe Scanner.
     * In precedenza utilizzata analogamente per leggere input da tastiera.
     *
     * La risorsa aperta (in questo caso l'oggetto scanner)
     * DEVE essere sempre chiuso in un blocco finally per assicurarsi
     * che non rimanga aperta in caso di eccezioni non/mal gestite!
     */
    public static void readByScanner(String filePath) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (FileNotFoundException e) {
            // TODO gestire eccezione !!!
        }
        finally { if (sc != null) sc.close(); }
    }

    /**
     * Metodo per leggere da file tramite la classe Scanner,
     * utilizzando try-with-resources per chiudere in automatico l'oggetto scanner nel blocco finally.
     */
    public static void readByScannerTryWithResources(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (FileNotFoundException e) {
            // TODO gestire eccezione !!!
        }
    }

    /**
     * Lettura standard da file tramite BufferedReader,
     * con chiusura automatica tramite try-with-resources.
     */
    public static void readByBufferedReader(String filePath) {
        // try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {     // pre  Java 7
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {        // post Java 7
            String line;
            // "salta" la prima riga del file
            br.readLine();
            // legge una riga del file e passa alla successiva finché ce ne sono da leggere nel file buffer
            while ((line = br.readLine()) != null)
                System.out.println(line);
        }
        catch (IOException e) {
            // TODO gestire eccezione !!!
        }
    }

    /**
     * Lettura di tutto il contenuto di un file senza BufferedReader e necessità di chiudere risorse.
     * Leggere una riga per volta è comunque l'utilizzo più consigliato
     * per non leggere interamente file di grandi dimensioni e caricare troppe informazioni in memoria.
     */
    public static void readAllLines(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println(lines);
        } catch (IOException e) {
            // TODO gestire eccezione !!!
        }
    }

    /**
     * Scrittura su file tramite BufferedWriter,
     * con chiusura automatica tramite try-with-resources.
     *
     * Il comportamento di default è quello di sovrascrivere il file se già esistente, o di crearlo altrimenti.
     */
    public static void writeLine(String filePath, String lineToWrite) {
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {     // pre  Java 7
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath))) {        // post Java 7
            bw.write(lineToWrite);
            bw.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scrittura su file tramite BufferedWriter in modalità append,
     * ovvero senza sovrascrivere il file ma aggiungendo in coda.
     *
     * Altre opzioni di apertura file sono disponibili nell'enum java.nio.file.StandardOpenOption.
     */
    public static void appendLine(String filePath, String lineToWrite) {
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {                       // pre  Java 7
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {     // post Java 7
            bw.write(lineToWrite);
            bw.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "module_09/src/esempi/test.txt";
        Path path = Paths.get("module_09/src/esempi/test.txt");                     // sconsigliabile utilizzare "/" per risalire al percorso
        Path path2 = Paths.get("module_09", "src", "esempi", "test.txt");    // metodo più robusto per generare un percorso ad un file

        writeLine(filePath, "ciao");
        appendLine(filePath, "ciaociao");

        readByScanner(filePath);
        readByBufferedReader(filePath);
        readAllLines(filePath);
    }
}
