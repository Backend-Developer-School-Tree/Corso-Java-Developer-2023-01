# Compagnia Shared Mobility 🛵

<p align="center">
<img src="https://enjoy.eni.com/social_tagging_1200x630.jpg" class="center">
</p>


Una compagnia di [shared mobility](https://en.wikipedia.org/wiki/Shared_transport) vuole creare un'infrastruttura software per gestire i propri servizi e la proprio flotta. Il tipo di veicoli che offre agli utenti sono: automobili, moto scooter, biciclette, monopattini elettrici, furgoncini. La compagnia da un ID univoco interno ad ogni veicolo ma automobili, furgoncini e motorini hanno anche una targa.

Eccetto le biciclette che non hanno bisogno di essere rifornite, automobili, scooter e furgoncini hanno bisogno di **carburante** mentre i monopattini elettrici hanno bisogno di **elettricità**. Inoltre biciclette e motorini hanno bisogno degli adeguati **caschi** per essere utilizzati mentre furgoni, automobili e scooter dell'adeguata **patente di guida**.

La compagnia vuole poter conoscere per ogni veicolo la sua **posizione geografica**, se in un determinato momento è **affittato** o disponibile e infine lo stato del carburante o batteria (a seconda del tipo di veicolo).

Un utente può affittare un veicolo pagando una certa tariffa al minuto (i prezzi li scegliete voi), **non è possibile affittare un veicolo per meno di 5 minuti.**

Per quanto riguarda gli **utenti**, la compagnia vuole registrare i seguenti dati anagrafici:

* Nome 
* Cognome
* Data di nascita
* Codice fiscale

Oltre questi dati, l'azienda vuole dare un id univoco ad ogni utente, sapere quali patenti di guida possiede, se possiede un casco e permettere agli utenti di aggiungere del credito da spendere per gli affitti. 

Il sistema deve permettere ad un utente di registrarsi, cercare veicoli disponibili, affittare un veicolo, lasciare e cioè restituire un veicolo.


Realizzate le classi e le funzionalità di questo sistema e fatevi un main dove testate il tutto.

# DISCLAIMER

Ovviamente un reale sistema del genere richiederebbe per gestire i dati un database che ancora non vi abbiamo spiegato. Createvi quindi una classe "Database" con all'interno liste degli oggetti che utilizzerete per questo sistema (lista utenti, lista automobili etc...).

La traccia poi non è molto precisa su alcuni punti, questo perché vogliamo sia darvi la massima libertà per affrontare il problema e soprattutto darvi una situazione abbastanza realistica del mondo del lavoro reale, capita spesso che non soltanto vi possiate interfacciare con una persona non tecnica ma spesso il cliente non sa nemmeno di preciso cosa vuole veramente, sta a voi fare le domande giuste per arrivare ad un ottimo prodotto. 

# Modalità di lavoro

Questo è un esercizio pensato per essere fatto in **gruppo** perciò ci aspettiamo una soluzione per ogni stanza. È obbligatorio creare una repository su cui aggiungere come collaboratore ogni membro del team. Massima libertà su come spartirvi il lavoro. Non è obbligatorio ma **fortemente gradito** un disegno con lo schema delle classi (va bene anche su carta, basta che si capisce).   

## Suggerimenti

HINT 1: Non esiste "la soluzione" di questo esercizio, è possibile tirare fuori due schemi di classi molto diversi tra di loro ed entrambi validi, esistono però soluzioni sbagliate che possono creare problemi di vario tipo. 

HINT 2: Se avete una domanda da fare sul sistema, fatela sul canale discord, è più veloce e potrebbe essere d'aiuto per altri gruppi.

HINT 3: Se pensate che una certa libreria esterna può esservi utile per risolvere un determinato problema...Usatela!

## Bonus stage: design patterns

- Implementare, tramite il design pattern Observer/Observable, un sistema che notifichi all'utente quando sia terminato un noleggio, stampando su console un messaggio che lo avvisi e indicando il prezzo del noleggio terminato.
- Per tutte le entità del database (utente, veicolo, ecc) implementare il design pattern Builder, e farne uso in tutti i metodi che aggiungono entità nel database (inserire un utente, inserire un veicolo, ecc.).

## Bonus stage 2: lettura/scrittura file

Aggiornare la classe Database per poter gestire un "database" in formato CSV, ovvero una serie di file di testo,
uno per ogni entità del sistema (es. utenti, veicoli, ecc), in cui in ogni riga contiene le informazioni relative ad una
specifica istanza di quell'entità separate da virgole (es. nel file degli utenti, ogni riga conterrà le informazioni di un diverso utente).
Esempio:
```
ID,Nome,Cognome,Data di nascita
1,Mario,Rossi,15/11/1968
2,Luigi,Mario,26/03/1989
3,Francesco,Totti,27/09/1976
```
La classe dovrà quindi prevedere le seguenti funzionalità:
- Creazione a partire da dei percorsi a dei file CSV 
    - nel caso siano già esistenti, caricando in memoria le informazioni che contengono
    - altrimenti, creando dei nuovi file su cui scrivere successivamente
- Aggiornamento del contenuto dei file ad ogni operazione di modifica (es. inserisci utente, rimuovi utente, modifica utente, ecc)
 
Inoltre, è necessario implementare, tramite il design pattern Singleton, l'univocità delle istanze della classe Database, così da evitare conflitti di lettura/scrittura sul nostro "database" in formato CSV.  
