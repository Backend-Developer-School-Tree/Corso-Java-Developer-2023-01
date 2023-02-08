package negozio;

public class Carrello {

    private int indice;
    private Cliente cliente;
    private Prodotto[] prodotti;
    private int[] quantita;

    public Carrello(Cliente cliente) {
        this.cliente = cliente;
        this.prodotti = new Prodotto[100];
        this.quantita = new int[100];
        this.indice = 0;
    }

    // setter e getter
    public int getIndice() {
        return indice;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prodotto[] getProdotti() {
        return prodotti;
    }

    public void setProdotti(Prodotto[] prodotti) {
        this.prodotti = prodotti;
    }

    public int[] getQuantita() {
        return quantita;
    }

    public void setQuantita(int[] quantita) {
        this.quantita = quantita;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    // metodi
    public void aggiungiProdotto(Prodotto p, int q) {
        prodotti[indice] = p;
        quantita[indice] = q;
        this.indice++;
    }



}
