import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("**** SYSTEM STARTUP ****");

        Scatola<Integer> scatolaDiInteri = new Scatola<>(42); 
        System.out.println(scatolaDiInteri.getDescrizioneOggetto());
        
        Scatola<Double> scatolaDiDouble = new Scatola<>(42.0); 
        System.out.println(scatolaDiDouble.getDescrizioneOggetto());

        Scatola<String> scatolaDiString = new Scatola<>("42"); 
        System.out.println(scatolaDiString.getDescrizioneOggetto());

        // posso avere ArrayList<String> con String dentro l'operatore diamond, non è un errore
        // ma è comunque una ripetizione
        List<String> strings = new ArrayList<>(); 
        strings.add("");

        // Lista non parametrizzata 
        List listObj = new ArrayList();
        listObj.get(0); //.get(0) mi torna un tipo Object che devo castare esplicitamente

        System.out.println("**** SYSTEM SHUTDOWN ****");
    }
}
