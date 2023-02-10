package negozio;

public class Prodotto  {

    // attributi
    private String nome;
    private double prezzo;
    private int quantity;
    private boolean food;

    public Prodotto(String nome, double prezzo, int quantity, boolean food) {
        this.nome = nome;
        this.prezzo = prezzo; // qui è da mettere una eccezione per controllare se prezzo >= 0
        this.quantity = quantity; // qui è da mettere una eccezione per controllare se quantity >= 0
        this.food = food;
    }

    // getter e setter
    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isFood() {
        return food;
    }

    // metodi
    // questo metodo aggiunge una quantità quantity del prodotto alla quantità precedente
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    /* questo metodo decrementa la quantità di un prodotto */
    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }

    // questo metodo aggiorna di 1 la quantità disponibile del prodotto
    public void addSingleQuantity() {
        this.quantity++;
    }

    // ritorna true se i due oggetti hanno lo stesso nome
    @Override
    public boolean equals(Object obj) {
        // controlliamo se il parametro obj sia null oppure sia della classe Prodotto
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Prodotto new_p = (Prodotto) obj; // questa operazione si chiama casting
        if (this.nome.equals(new_p.nome)) return true;
        return false;
    }
}
