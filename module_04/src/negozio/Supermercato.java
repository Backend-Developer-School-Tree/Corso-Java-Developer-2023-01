package negozio;

public class Supermercato {

    // attributi
    private static Prodotto[] prodotti = new Prodotto[100]; // i prodotti del supermercato

    // metodi
    public static Prodotto[] getProdotti() {
        return prodotti;
    }

    /*
    Questo metodo ritorna true se il prodotto p è disponibile in quantità q dentro il
    negozio.
     */
    public static boolean isDisponibile(Prodotto p, int q) {
        for (Prodotto prod : prodotti) { // mi scorro l'array di prodotti del negozio
            if (p.equals(prod)) { // controllo con equals se trovo il prodotto cercato
                if (prod.getQuantity() >= q) return true; // se la quantità è sufficiente ritorno true
                else return false; // altrimenti ritorno false
            }
        }
        return false;
    }
}
