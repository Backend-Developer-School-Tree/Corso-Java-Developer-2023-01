package esempiGenerics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Coppia<String> coppia = new Coppia<>("ciao", "buondi");
        System.out.println(coppia.getX().getClass());

        // se non dichiaro un tipo tra le parentesi angolari, il tipo generico T viene trattato come il tipo Object
        Coppia coppiaGenerica = new Coppia<>();
        coppiaGenerica.setX(10);
        coppiaGenerica.setY("ciao");

        // avendo due segnaposto nella dichiarazione della classe CoppiaDiversa
        CoppiaDiversa<String, String> coppiaParole = new CoppiaDiversa<>("prima_parola", "seconda_parola");
        CoppiaDiversa<String, Integer> coppiaDiversa = new CoppiaDiversa<>("parolina", 10);

    }

    public static <T extends Persona> void returnQualcosa(T oggetto) {
        Studente studente = (Studente) oggetto;
        System.out.println(studente.getMatricola());
    }

}
