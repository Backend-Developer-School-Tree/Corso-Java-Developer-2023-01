## MONSTERS AND TREASURES

Vogliamo progettare un videogame con una struttura simile al famoso gioco da tavolo Dungeons&Dragons.
Il gioco sarà composto da una serie di avventure o campagne che un team di giocatori deve affrontare. Il gioco terminerà quando tutte le avventure
saranno completate.
Ogni avventura, da affrontare in sequenza una dopo l'altra, è composta da una mappa (una matrice nxn, la dimensione può variare da avventura ad avventura).
Ogni mappa avrà una coordinata di entrata e una di uscita (poste su un bordo della matrice) e contiene, in ogni coordinata, una delle seguenti:
- Uno spazio vuoto.
- Un muro (dove ovviamente i giocatori non potranno passare).
- Uno o più giocatori.
- Un mostro.
- Un tesoro.

Per terminare un'avventura i giocatori dovranno raccogliere tutti quanti i tesori, sconfiggendo ogni mostro che gli si pari davanti la strada. Fin quando
i tesori non saranno tutti raccolti, i giocatori non potranno uscire neanche se raggiungessero l'uscita.
Ogni giocatore/personaggio avrà un nome, un livello di esperienza, una razza, una classe, i punti vita totali, i punti vita che ha in quel momento del gioco,
degli equipaggiamenti, un insieme di oggetti (che chiameremo item) e delle abilità. Ogni giocatore inoltre avrà un punteggio per le seguenti specialità:
intelligenza, carisma, forza, costituzione, destrezza, stregoneria e saggezza. Per quanto riguarda i valori iniziali alla creazione del giocatore, si deve tirare un dado
a 6 facce e sommare il risultato ai valori di base dati dalla propria razza (umano, elfo, nano, ecc.) e dalla propria classe (un ladro avrà inizialmente
più destrezza di un mago, ma il mago ha sicuramente più punti iniziali di stregoneria rispetto a un guerriero). Successivamente, in base alle informazioni
sulla classe a cui appartiene, ad ogni livello che avanza questi attributi verranno modificati.

Una abilità è invece composta dai tipi di specialità coinvolti (per esempio un'abilità può sia essere una prova di destrezza sia di carisma), un danno e una
probabilità che vada a segno, che è un numero compreso tra 1 e 20 (quando usiamo un'abilità dovremo tirare un dado a 20 facce, quindi 1 vuol dire che va a 
segno una volta su 20, 20 che va a segno sempre).

Un equipaggiamento invece è un oggetto che si lega ai giocatori in maniera permanente e gli assicura un power-up sulle specialità. Per esempio uno scettro magico
può aumentare il punteggio di intelligenza e stregoneria, o una nuova spada può aggiungere punti di forza). Alcuni equipaggiamenti per bilanciare il proprio
potere su una specifica specialità possono abbassare il punteggio su altre. Ad esempio una spada molto potente ma estremamente pesante può aumentare di molto
i punti di forza sacrificando della destrezza. I tipi di equipaggiamento sono armatura, spada, pugnale, mazza, arco, copricapo, scettro, calzatura, copricapo.
Un personaggio può avere contemporaneamente solo:
- 1 armatura
- 1 calzatura
- 1 copricapo
- al massimo 3 di tutti gli altri equipaggiamenti.

Gli oggetti invece permettono di avere dei power-up consumabili (quindi dalla durata di al massimo qualche turno o fino alla fine del combattimento). Possono
anche svolgere funzioni di utilità, come curare o resuscitare un compagno morto durante il combattimento.

Un tesoro è un oggetto che può contenere più equipaggiamenti e oggetti. Una volta preso un tesoro il giocatore che lo prende per primo potrà scegliere
se distribuire il tesoro e come agli altri giocatori. Gli equipaggiamenti eventualmente in più saranno scartati a meno che il giocatore che ha trovato
il tesoro non decida di sostituirlo con un suo già presente o lo doni a un suo compagno. Sulla quantità di oggetti invece non c'è limite.

Ogni turno si svolge facendo giocare un giocatore alla volta (l'ordine è in base alla destrezza). Un giocatore ad ogni turno può cambiare di una posizione,
e se si trova muovendosi sulla casella di un mostro, deve necessariamente combatterci. Il combattimento termina quando nessun giocatore rimane in vita
oppure quando il mostro viene sconfitto. Mentre se ci si trova in una casella tesoro, questo viene trattato come scritto sopra.

In un combattimento il mostro attacca sempre per primo. Un mostro avrà un livello, dei punti vita, un quantitativo di esperienza che distribuirà ai giocatori
che hanno partecipato al combattimento se sconfitto. Inoltre anche lui avrà una serie di abilità e ha anche un set di specialità da usare per sconfiggere
il mostro. Ad esempio un mago oscuro è un mostro che per essere sconfitto ha bisogno di subire delle abilità con specialità stregoneria, saggezza o
intelligenza (se sei un guerriero ti mena prima che arrivi!). Un mostro può anche possedere dei tesori.

Un combattimento si svolge nelle seguenti fasi:
- Attaccano a turno mostro e giocatori coinvolti.
- Ad ogni turno il mostro può solo attaccare con le sue abilità, mentre i giocatori possono: attaccare, usare un oggetto o tentare la fuga. Purchè ogni
attacco vada a segno bisogna tirare un dado a 20 facce. Un oggetto si può usare sia su se stessi che su un altro compagno. Per la fuga bisogna tirare un dado
da 1 a 6 e la fuga riesce se esce 6. Gli attacchi o abilità che i giocatori possono fare al mostro come detto sono solo quelli che contengono almeno una delle
specialità che il mostro ha come caratteristica.
- Se uno dei giocatori termina i punti vita è morto, e può tornare in vita solo grazie all'uso di speciali oggetti da parte di un compagno. Se tutti i giocatori
muoiono è game over.
- Se il mostro muore vengono distribuiti ai giocatori la sua exp e i tesori. In questo caso il possessore dei tesori del mostro sarà quello che gli ha dato il
colpo di grazia.

Un giocatore può guadagnare esperienza nei seguenti modi:
- Sconfiggendo un mostro (in tal caso l'exp è distribuita equamente tra i giocatori).
- Tramite oggetti specifici.
- Terminando le singole avventure.

Come detto il gioco termina dopo aver terminato tutte le avventure!
