package negozio;

public class Supermercato {

    // attributi
    private static Prodotto[] prodotti = new Prodotto[100]; // i prodotti del supermercato

    // metodi
    public static Prodotto[] getProdotti() {
        return prodotti;
    }

    /*
    Questo metodo aggiunge un prodotto (o ne incrementa la quantità se presente) al negozio
     */
    public static void addProdotto(Prodotto p, int q) {
        // qui cerco il prodotto
        for (int i = 0; i < prodotti.length; i++) { // ciclo i prodotti
            if (p.equals(prodotti[i])) {
                prodotti[i].addQuantity(q);
                return;
            }
        }
        // se non lo trovo cerco un buco
        for (int i = 0; i < prodotti.length; i++) {
            if (prodotti[i] == null) {
                prodotti[i] = p;
                prodotti[i].setQuantity(q);
                return;
            }
        }
    }

    /*
    questo metodo rimuove un prodotto p all'interno dell'array dei prodotti
     */
    public static void removeProdotto(Prodotto p) {
        // cerco il prodotto
        for (int i = 0; i < prodotti.length; i++) { // ciclo i prodotti
            if (prodotti[i].equals(p)) {
                prodotti[i]  = null;
            }
        }
    }

    /*
    questo metodo stampa a video tutti i prodotti del negozio con le rispettive quantità
     */
    public static void stampaProdotti() {
        for (Prodotto p : prodotti) {
            if (p == null) continue;
            System.out.println(p.getNome() + " : " + p.getQuantity());
        }
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

    /*
    Questo metodo prende in input un prodotto p disponibile e una data quantità q
    e rimuove q prodotti di quel tipo dal negozio
     */
    public static void rimuoviDopoAcquisto(Prodotto p, int q) {
        for (Prodotto prod : prodotti) { // mi scorro l'array di prodotti
            if (prod.equals(p)) {
                prod.decreaseQuantity(q);
                break;
            }
        }
    }
}

