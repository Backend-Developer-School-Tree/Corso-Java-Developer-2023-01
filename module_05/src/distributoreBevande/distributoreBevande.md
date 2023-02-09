
Skip to content
Pull requests
Issues
Codespaces
Marketplace
Explore
@MrSosu
Backend-Developer-School-Tree /
Corso-Java-Backend-2022-02
Public

Fork your own copy of Backend-Developer-School-Tree/Corso-Java-Backend-2022-02

Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights

    Settings

Corso-Java-Backend-2022-02/modulo5/distributore bevande/
in
main

1

Distributore di Bevande 🛵

2

​

3

Scrivere un programma in grado di modellare la gestione di un distributore di bevande. Il distributore gestirà una lista di 2 tipi diversi di prodotti: Caffè e Cappuccino.

4

Progettare la classe DistributoreDiBevande costruito con un intero n che determina il numero di prodotti nel distributore

5

Ogni tipo di prodotto può avere un codice univoco e un prezzo uguali nel tempo (ossia per uno stesso tipo di prodotto).

6

​

7

La classe prevede i seguenti metodi:

8

​

9

- caricaProdotto: dato un Prodotto p in input, lo carica nel distributore

10

- inserisciImporto: permette di inserire un importo nella macchinetta

11

- scegliProdotto: dato in ingresso un codice di prodotto, restituisca il

12

prodotto associato a quel codice (se l’importo inserito lo consente) e

13

decrementi il saldo disponibile nel distributore

14

- saldoAttuale: restituisce il saldo attuale del distributore

15

- getResto: restituisce il resto dovuto e azzeri il saldo

16

​

17

​

18

Potete usare questo codice come test

19

​

20

```

21

Caffe caffe = new Caffe("caffe", 0.5);

22

Cappuccino cappuccino = new Cappuccino("cappuccino", 1);

23

DistributoreDiBevande distributoreDiBevande = new DistributoreDiBevande(10);

24

distributoreDiBevande.caricaProdotto(caffe);

25

distributoreDiBevande.caricaProdotto(caffe);

26

distributoreDiBevande.caricaProdotto(cappuccino);

27

distributoreDiBevande.caricaProdotto(caffe);

28

distributoreDiBevande.caricaProdotto(caffe);

29

distributoreDiBevande.caricaProdotto(cappuccino);

30

distributoreDiBevande.caricaProdotto(caffe);

31

System.out.println(distributoreDiBevande.saldoAttuale() == 0);

32

System.out.println(distributoreDiBevande.getResto() == 0);

33

distributoreDiBevande.inserisciImporto(0.4);

34

System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);

35

distributoreDiBevande.inserisciImporto(0.2);

36

System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);

37

System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);

38

System.out.println(distributoreDiBevande.saldoAttuale() == 0);

39

System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);

40

distributoreDiBevande.inserisciImporto(2.0);

41

System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);

42

System.out.println(distributoreDiBevande.scegliProdotto("cappuccino") != null);

43

System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);

44

System.out.println(distributoreDiBevande.saldoAttuale() == 0);

45

System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);

Attach files by dragging & dropping, selecting or pasting them.
Styling with Markdown is supported
@MrSosu
Commit changes
Commit summary
Optional extended description
Commit directly to the main branch.
Create a new branch for this commit and start a pull request. Learn more about pull requests.
Footer
© 2023 GitHub, Inc.
Footer navigation

    Terms
    Privacy
    Security
    Status
    Docs
    Contact GitHub
    Pricing
    API
    Training
    Blog
    About

