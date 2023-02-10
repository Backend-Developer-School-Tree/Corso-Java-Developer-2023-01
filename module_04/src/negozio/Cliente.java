package negozio;

public class Cliente implements Comparable {

    // attributi
    private int eta;
    private Carrello carrello; // il carrello del cliente
    private int numeroPunti; // i punti sconto

    // costruttore
    public Cliente(int eta) {
        this.eta = eta;
        this.numeroPunti = 0;
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
        */
    public double checkout(DayOfWeek day, boolean sconto) {
        double conto = 0;
        for (int i = 0; i < carrello.getIndice(); i++) { // mi scorro il carrello (non tutto ma solo fino all'indice del carrello perchè so che è pieno fino a li
            Prodotto p = carrello.getProdotti()[i]; // prendo l'i-esimo prodotto dal carrello
            int q = carrello.getQuantita()[i]; // prendo l'i-esima quantità dell'i'-esimo prodotto nel carrello
            if (Supermercato.isDisponibile(p,q)) { // controllo se il prodotto in quella quantita sia ancora disponibile
                if (isSconto(day) && p.isFood()) { // se posso applicare lo sconto
                    double prezzo_scontato = (p.getPrezzo() / 100.0) * 80;
                    conto += q*prezzo_scontato; // lo calcolo aumentando il conto con il prezzo scontato
                }
                else {
                    conto += q*p.getPrezzo(); // lo calcolo per intero
                }
                Supermercato.rimuoviDopoAcquisto(p,q); // se si decremento la quantità del prodotto nel negozio
            }
            else { // altrimenti
                if (isSconto(day) && p.isFood()) {
                    double prezzo_scontato = (p.getPrezzo() / 100.0) * 80;
                    conto += p.getQuantity()*prezzo_scontato;
                }
                else {
                    conto += p.getQuantity()*p.getPrezzo();
                }

                Supermercato.rimuoviDopoAcquisto(p,p.getQuantity()); // "svuoto" le scorte di quel prodotto
            }
        }
        svuotaCarrello(); // svuoto il carrello
        numeroPunti += conto / 10;
        if (sconto) {
            double euro_scontati = numeroPunti / 10;
            return conto - euro_scontati;
        }
        return conto;
    }

    /*
    overload del metodo precedente, dove in questo caso il pagamento viene rateizzato
    e il metodo ritorna il costo della prima rata
     */
    public double checkout(DayOfWeek day, boolean sconto, int nMesi) {
        double prezzo_tot = checkout(day, sconto);
        return prezzo_tot / nMesi;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
