package negozio;

public class Cliente {

    // attributi
    private int eta;
    private Carrello carrello; // il carrello del cliente

    // costruttore
    public Cliente(int eta) {
        this.eta = eta;
        carrello = new Carrello(this);
    }

    // getter e setter
    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    // metodi
    /* questo metodo aggiunge un prodotto p nel carrello del cliente in quantità q
     */
    public void addInCarrello(Prodotto p, int q) {
        /*
        1) controllare se il prodotto sia disponibile in tale quantità nel negozio
            1.1) se c'è disponibilità aggiungo nella prossima casella libera dei due array che compongono il carrello p e q
            1.2) altrimenti stampo un messaggio di errore
         */
        Prodotto[] prodottiNegozio = Supermercato.getProdotti();
        // controllo se il prodotto p è disponibile in quantità q dentro il supermercato
        if (Supermercato.isDisponibile(p,q)) {
            carrello.aggiungiProdotto(p,q);
        }
        else System.out.println("Prodotto non disponibile!");
    }

    /*
    questo metodo svuota il carrello del cliente
     */
    public void svuotaCarrello() {
        carrello.setProdotti(new Prodotto[100]);
        carrello.setQuantita(new int[100]);
        carrello.setIndice(0);
    }

    /*
    questo metodo ritorna true se il cliente ha diritto allo sconto in questo momento
     */
    public boolean isSconto(DayOfWeek day) {
        if (eta >= 60 && (day.equals(DayOfWeek.LUNEDI) || day.equals(DayOfWeek.MERCOLEDI))) return true;
        return false;
    }

    /*
    questo metodo permette di effettuare l'acquisto.
    0) inizializzo il conto
    1) controllo se i prodotti nel carrello sono ancora disponibili. Per fare ciò:
    faccio un for sui prodotti p e le rispettive quantità q:
        1.1) se quel prodotto p è ancora presente nel negozio in quantità q:
            1.1.1) confermo l'acquisto del prodotto p in quantità q, quindi vado a rimuovere dal
                        supermercato quella quantità di prodotto.
            1.1.2) aggiungo al conto totale il prezzo di p moltiplicato per q
        1.2) altrimenti:
            1.2.1) permetto l'acquisto solamente della quantità q rimanente qRimanente e aggiorno il supermercato
                        (che può essere zero e quindi non verrà calcolata in tal caso nel conto finale)
             1.2.2) aggiungo al conto il prezzo di p moltiplicato per qRimanente
      2) svuotare il carrello
      3) ritorno il conto finale

    public double checkout() {
        double conto = 0;
        for (int i = 0; i < carrello.getIndice(); i++) { // mi scorro il carrello (non tutto ma solo fino all'indice del carrello perchè so che è pieno fino a li
            Prodotto p = carrello.getProdotti()[i];
            int q = carrello.getQuantita()[i];
            if (Supermercato.isDisponibile(p,q)) {

            }
        }
    } */


}
