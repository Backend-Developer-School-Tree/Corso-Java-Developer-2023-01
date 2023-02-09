# Esercizio Classifica Serie A 🏍

Progettare una classe Classifica che permetta di gestire la classifica di Serie A costruita a partire da 20 squadre di calcio. Ogni squadra di calcio ha i seguenti attributi:

* id
* nome
* rosa di giocatori
* punteggio
* gol fatti
* gol subiti

Ogni giocatore ha un id, un nome e un cognome. In particolare, deve essere possibile gestire le seguenti operazioni:

* esitoPartita(squadraCasa, golCasa, squadraOspite, golOspite): gestisce il punteggio delle due squadre in base all'esito
* getClassifica(): ritorna la classifica attuale, ordinata per punteggio
* getMigliorAttacco(): ritorna la squadra che ha segnato più gol
* getPeggiorDifesa(): ritorna la squadra che ha concesso più gol