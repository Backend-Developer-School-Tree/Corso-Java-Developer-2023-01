# Gestore Veicoli 🛴

Scrivere un programma in grado di modellare la gestione di diversi tipi di veicoli: automobili e
autocarri. In particolare, create le classi Autocarro e Automobile entrambe con le seguenti
aratteristiche:
Ogni veicolo è caratterizzato da:
- Targa
- Numero di posti

Gli autocarri hanno una proprietà aggiuntiva: la capacità massima di carico (espressa in quintali). Le automobili, invece, il numero di porte.
Il metodo toString degli oggetti Automobile deve ritornare il numero di targa e il numero di porte, separati dal carattere «:».
Il metodo toString degli oggetti Autocarro, invece, deve ritornare il numero di targa e la massima capacità in quintali, separati dal carattere «:».

Deve essere possibile eseguire il seguente codice:

```
Automobile automobile = new AutoMobile("cf123rm", 4, 4);
gestione_veicoli.AutoCarro autoCarro = new AutoCarro("ca133sm", 4, 2);
```

Suggerimento: usate l’ereditarietà
