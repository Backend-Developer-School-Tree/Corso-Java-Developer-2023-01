package negozio;

public class Test {

    public static void main(String[] args) {
        // creo dei prodotti
        Prodotto p1 = new Prodotto("Mela", 0.25, 15, true);
        Prodotto p2 = new Prodotto("Sapone mani", 1.50, 5, false);
        Prodotto p3 = new Prodotto("Riso", 1, 10, true);
        Prodotto p4 = new Prodotto("Vino bianco", 4.20, 8, true);
        Prodotto p5 = new Prodotto("Deodorante", 3, 4, false);

        // creo due clienti
        Cliente c1 = new Cliente(65);
        Cliente c2 = new Cliente(29);
        Cliente c3 = new Cliente(50);

        // aggiungo i prodotti al negozio
        Supermercato.addProdotto(p1, p1.getQuantity());
        Supermercato.addProdotto(p2, p2.getQuantity());
        Supermercato.addProdotto(p3, p3.getQuantity());
        Supermercato.addProdotto(p4, p4.getQuantity());
        Supermercato.addProdotto(p5, p5.getQuantity());

        // riempiamo i carrelli dei clienti
        c1.addInCarrello(p1, 6);
        c1.addInCarrello(p2, 1);
        c1.addInCarrello(p3, 2);

        c2.addInCarrello(p1, 6);
        c2.addInCarrello(p2, 1);
        c2.addInCarrello(p3, 2);

        c3.addInCarrello(p1, 10);

        System.out.println("----------------------------------");
        c1.getCarrello().stampaCarrello();
        System.out.println("----------------------------------");
        c2.getCarrello().stampaCarrello();
        System.out.println("----------------------------------");
        c3.getCarrello().stampaCarrello();
        System.out.println("----------------------------------");

        Supermercato.stampaProdotti();
        System.out.println("----------------------------------");

        System.out.println(c1.checkout(DayOfWeek.MERCOLEDI, false));
        System.out.println(c2.checkout(DayOfWeek.MERCOLEDI, false));

        System.out.println("----------------------------------");

        Supermercato.stampaProdotti();

        System.out.println("----------------------------------");

        System.out.println(c3.checkout(DayOfWeek.MERCOLEDI, false));
        System.out.println("----------------------------------");
        Supermercato.stampaProdotti();

        Comparable[] array_oggetti_comparabili = {p1, p2, c1, c2};
        Comparable oggetto_comparabile = p1;
    }

}

