# Esercizio Dictionary 🛵

Scrivere un programma che per gestire un dizionario. In particolare, ad ogni lettera
dell'alfabeto è associata una lista di parole che iniziano con quella lettera e ad
ogni parola è, a sua volta, associata una lista di significati diversi della parola.

Esempio:
- c -> calcio -> sport
- c -> calcio -> elemento chimico

Devono essere possibili le seguenti operazioni:
- inserisci parola (con almeno un significato associato)
- aggiungi significato per una certa parola
- stampa dizionario, che ritorna una stringa contenente ogni parola e significato
  (in ordine lessicografico ascendente in base alla lettera) nella forma:

```
 lettera1:[parola1: (significato1;significato2;...;), parola2: (significato1;...;...;)]
 lettera2:[parola1: significato1;significato2;...;), parola2: (significato1;...;...;)]
 ...
 letteraN:[parola1: significato1;significato2;...;),parola2: (significato1;...;...;)]
```  