# Esercizio Dictionary 🛵

Scrivere un programma che per gestire un dizionario. In particolare, ad ogni lettera
dell'alfabeto è associata una lista di parole che iniziano con quella lettera e ad
ogni parola è, a sua volta, associata una lista di significati diversi della parola.

Esempio:
- c -> calcio -> sport
- c -> calcio -> elemento chimico

Devono essere possibili almeno le seguenti operazioni:
- `inserisciParola`: inserisce una parola, con almeno un significato associato
- `aggiungiSignificato`: aggiunge il significato per una certa parola
- `toString`: ritorna una stringa contenente ogni parola e significato presente nel dizionario
  (in ordine lessicografico ascendente in base alla lettera) nella forma:

```
 lettera1:[parola1: (significato1;significato2;...;), parola2: (significato1;...;...;)]
 lettera2:[parola1: (significato1;significato2;...;), parola2: (significato1;...;...;)]
 ...
 letteraN:[parola1: (significato1;significato2;...;),parola2: (significato1;...;...;)]
```  

Suggerimenti sulle eccezioni da prevedere:
- `LetterNotPresentException`: lanciata nel caso la lettera da cercare o rimuovere non sia contenuta nella struttura dati
- `WordNotPresentException`: lanciata nel caso in cui la parola da cercare o rimuovere non sia contenuta
- `ElementAlreadyContainedException:` lanciata nel caso in cui la chiave da aggiungere sia già contenuta
