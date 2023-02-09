Distributore di Bevande 🛵

Scrivere un programma in grado di modellare la gestione di un distributore di bevande. Il distributore gestirà una lista di 2 tipi diversi di prodotti: Caffè e Cappuccino.
Progettare la classe DistributoreDiBevande costruito con un intero n che determina il numero di prodotti nel distributore
Ogni tipo di prodotto può avere un codice univoco e un prezzo uguali nel tempo (ossia per uno stesso tipo di prodotto).

La classe prevede i seguenti metodi:

- caricaProdotto: dato un Prodotto p in input, lo carica nel distributore
- inserisciImporto: permette di inserire un importo nella macchinetta
- scegliProdotto: dato in ingresso un codice di prodotto, restituisca il 
  prodotto associato a quel codice (se l’importo inserito lo consente) e 
  decrementi il saldo disponibile nel distributore
- saldoAttuale: restituisce il saldo attuale del distributore
- getResto: restituisce il resto dovuto e azzeri il saldo


Potete usare questo codice come test

```
Caffe caffe = new Caffe("caffe", 0.5);
Cappuccino cappuccino = new Cappuccino("cappuccino", 1);
DistributoreDiBevande distributoreDiBevande = new DistributoreDiBevande(10);
distributoreDiBevande.caricaProdotto(caffe);
distributoreDiBevande.caricaProdotto(caffe);
distributoreDiBevande.caricaProdotto(cappuccino);
distributoreDiBevande.caricaProdotto(caffe);
distributoreDiBevande.caricaProdotto(caffe);
distributoreDiBevande.caricaProdotto(cappuccino);
distributoreDiBevande.caricaProdotto(caffe);
System.out.println(distributoreDiBevande.saldoAttuale() == 0);
System.out.println(distributoreDiBevande.getResto() == 0);
distributoreDiBevande.inserisciImporto(0.4);
System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
distributoreDiBevande.inserisciImporto(0.2);
System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
System.out.println(distributoreDiBevande.saldoAttuale() == 0);
System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
distributoreDiBevande.inserisciImporto(2.0);
System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
System.out.println(distributoreDiBevande.scegliProdotto("cappuccino") != null);
System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
System.out.println(distributoreDiBevande.saldoAttuale() == 0);
System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
```

Suggerimento: usate l’ereditarietà

