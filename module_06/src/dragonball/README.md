# DRAGONBALL

Vogliamo creare un videogioco basato sul famosissimo manga di Akira Toriyama, nel quale i vari
personaggi possono combattere tra di loro in una sorta di Torneo Tenkaichi.
Ogni personaggio ha un nome, dei punti vita, una lista di 4 possibili attacchi personalizzati e una
forza fisica. Inoltre ogni personaggio ha un valore compreso tra 0 ed 1 che rappresenta la sua
capacità di schivare attacchi e un valore compreso tra 0 ed 1 che rappresenta la sua resistenza fisica.
Ogni attacco possibile ha un nome, un valore rappresentante la quantità di danno, e un valore
compreso tra 0 ed 1 che rappresenta la probabilità che l’attacco vada a segno. Notare che per
calcolare la probabilità che un attacco A vada a segno su un personaggio P sarà data dal prodotto
della probabilità che l’attacco vada a segna con la probabilità che l’attacco venga schivato. Quindi
se per esempio il personaggio Goku utilizza il’attacco “Kaikoen” che ha probabilità 0.9 di successo
sul personaggio Freezer che ha probabilità 0.4 di schivare un attacco, la probabilità che l’attacco
vada a segno è:

- 0.90*0.40 = 0.36 (in pratica il 36% delle volte va a segno).

__Nota__: un diverso attacco può essere nel kit di più personaggi. Per esempio l’attacco “Kamehameha”
è un attacco sia di Goku che di Gohan che del Maestro delle Tartarughe ecc.

Torniamo ai personaggi. Essi possono essere di diverso tipo: Umano, Sayan, Namecciano, Cyborg,
Demone (per esempio Majin-bu) e Alieno (per esempio Freezer). Tutti i personaggi, a parte i 4
attacchi personali, hanno un attacco fisico di base, e una probabilità che esso vada a segno che
cambia a seconda del personaggio. Questo attacco fisico di base è a tutti gli effetti un attacco, e il
suo danno è uguale alla forza fisica del personaggio.
Vogliamo inoltre che i personaggi implementino l'interfaccia Comparable, facendo in modo che un personaggio
sia confrontato rispetto agli altri in base ai loro punti vita.
Creare infine una classe Combattimento che rappresenta un combattimento tra due personaggi.
Questa classe avrà tra gli attributi i personaggi stessi e implementerà al proprio interno un metodo
combatti() che simulerà un combattimento. Il metodo eseguirà i seguenti passaggi:

__1)__ Sceglie a caso il combattente che inizierà per primo.

__2)__ A turno, i combatteni scaglieranno un attacco preso random dalla lista dei suoi attacchi, calcolerà
randomicamente se l’attacco andrà a segno o meno, e se l’attacco va a segno infligge danno
all’avversario pari al danno che l’attacco infligge moltiplicato per la resistenza fisica dell’avversario
(quindi più questo valore per un personaggio è vicino allo 0 più è resistente, più e vicino ad 1 meno
è resistente). Ad esempio, se Goku riesce ad infliggere un attacco “Kamehameha” a Majin-Bu che
infligge 50 danni, se Majin-Bu ha una resistenza pari a 0.3 il danno inflitto sarà 50*0.3 = 15.

__3)__ Il combattimento termina quando uno dei due personaggi raggiungerà un numero di punti vita <=
0. In tal caso il combattimento finisce e i punti vita dei personaggi vengono ripristinati al massimo.

Creare una classe Main dove vengano creati dei personaggi, degli attacchi, e vengano simulati dei
combattimenti.

__Nota__: ovviamente se provate a fare più volte lo stesso combattimento potrete accorgervi di avere
risultati diversi: è normale vista la randomicità coinvolta!
