package supermercato;

public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Marco", "Adriani", 29);
        Cliente c2 = new Cliente("Anna", "Rossi", 80);
        Cliente c3 = new Cliente("Pippo", "Franco", 85);
        Cliente c4 = new Cliente("Giulia", "Verdi", 24);
        Cliente c5 = new Cliente("Gianni", "Fragola", 70);

        Supermercato supermercato = new Supermercato();
        supermercato.addCliente(c1);
        System.out.println(supermercato.getClienti());
        supermercato.addCliente(c2);
        System.out.println(supermercato.getClienti());
        supermercato.addCliente(c3);
        System.out.println(supermercato.getClienti());
        supermercato.addCliente(c4);
        System.out.println(supermercato.getClienti());
        supermercato.addCliente(c5);

        System.out.println(supermercato.getClienti());
    }

}
