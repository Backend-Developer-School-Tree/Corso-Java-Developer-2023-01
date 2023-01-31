import java.util.Random;

public class EstrattoreVolontari {

    final static String[] CORSISTI = {
            "Abdallah Iwaza",
            "Alberto Armando Barbato",
            "Alessandro Martino",
            "Alessia Biondo",
            "Alfio Pappalardo",
            "Alfonso Cecere",
            "Angelica Dargenio",
            "Daniela Potenza",
            "Danilo Carretta",
            "Davide Campagna",
            "Flavio Cassarà",
            "Giancarlo Guacci",
            "Giuseppe Campo",
            "Giuseppe Dambone",
            "Giuseppe De Santis",
            "Giuseppe Marino",
            "Hamza Youssef",
            "Hoda Eldesoky",
            "Ida Fatma Grillo",
            "Lucrezia Arestia",
            "Luigi Fortunato",
            "Marco Sotera",
            "Marioalberto Mazzoni",
            "Marziano Alessandro Di Giusto",
            "Michele Damone",
            "Michele Fiormarino",
            "Sandro Fioretto",
            "Stefano Ingletti",
            "Vincenzo Barrano"
    };

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Il volontario per l'esercizio di oggi è: " + CORSISTI[rand.nextInt(CORSISTI.length)]);
    }

}
