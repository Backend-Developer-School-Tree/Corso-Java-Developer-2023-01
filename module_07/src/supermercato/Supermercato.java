package supermercato;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Supermercato {

    Queue<Cliente> clienti = new PriorityQueue<>(10, Cliente::compareTo);


    public Queue<Cliente> getClienti() { return clienti; }

    public void addCliente(Cliente c) {
        if (!clienti.contains(c)) { // se il cliente non è già presente in coda
            boolean b = clienti.offer(c);
            if (!b) {
                System.out.println("C'è stato un problema nell'inserimento del cliente " + c.getNome() + " " + c.getCognome());
            }
            else {
                System.out.println("Inserimento del cliente andato a buon fine");
            }
        }
    }

    public void removeCliente() { clienti.poll(); }

    public void nextCliente() { clienti.peek(); }

    public void inCoda() { clienti.size(); }


}
