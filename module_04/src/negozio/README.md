# Negozio 🏍

Creare un sistema in grado di gestire i prodotti venduti in un negozio. Si tratta di un negozio in
pieno centro storico, quindi potrà gestire al massimo 100 tipi diversi di prodotto. In particolare, il 
si tratta di un supermercato dove si vendono sia beni alimentari che non. Inoltre, il proprietario ha 
deciso di fare uno sconto del 20% sui prodotti di genere alimentare tutti i lunedì e mercoledì per 
i clienti con più di 60 anni.
Ogni prodotto ha un nome e un prezzo. E' ovviamente possibile acquistare più prodotti simultaneamente.
Deve essere possibile per il negoziante:
  - aggiungere un nuovo prodotto (Se un prodotto è già presente,
   va aggiornata solo la quantità rimanente)
  - rimuovere un prodotto 
  - ottenere la quantità rimanente di ogni prodotto

Deve essere possibile per il cliente: 
  - acquistare uno o più prodotti (ottenendo il totale da pagare)
  
Non deve essere possibile acquistare un prodotto se la quantità rimanente è 0.


Plus 1: implementare una logica di pagamento rateizzato che in base al numero di mesi e all'importo   
da pagare restituisca l'ammontare mensile della rata

Plus 2: "I regalissimi": ogni 10 euro spesi 1 punto regalo, ogni 10 punti regalo 1 euro di sconto