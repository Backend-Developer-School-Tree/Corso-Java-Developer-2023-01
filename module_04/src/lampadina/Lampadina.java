package lampadina;

public class Lampadina {

    private static boolean hasElectricity;
    private StatoLampadina stato;
    /**
     * Numero di click possibili rimasti prima della rottura della lampadina
     */
    private int clickCount;

    /**
     * Costruisce un oggetto lampadina a partire da un numero massimo di click possibili prima della rottura
     * @param maxClickCount numero massimo di click possibili prima della rottura
     */
    public Lampadina(int maxClickCount) {
        this.clickCount = maxClickCount;
        stato = StatoLampadina.SPENTA;
    }

    /**
     * Cambia lo stato dell'elettricità condivisa da tutte le lampadine all'interno dell'impianto
     * @return true se c'è elettricità dopo il cambio, o false altrimenti
     */
    public static boolean toggleElectricity() {
        hasElectricity = !hasElectricity;
        return hasElectricity;
    }

    /**
     * Ritorna lo stato corrente della lampadina
     */
    public StatoLampadina getStato() {
        if (stato == StatoLampadina.ROTTA) return stato;
        if (!hasElectricity) return StatoLampadina.SPENTA;
        return stato;
    }

    /**
     * Cambia lo stato da accesa a spenta o da spenta ad accesa, in base allo stato attuale.
     * Oppure rompe la lampadina dopo un numero di click predefinito.
     * @return true se il cambio di stato è andato a buon fine, false altrimenti
     */
    public boolean click() {
        if (!hasElectricity) return false;
        if (stato.equals(StatoLampadina.ROTTA)) return false;
        if (clickCount == 0) stato = StatoLampadina.ROTTA;
        else {
            switch (stato) {
                case ACCESA -> stato = StatoLampadina.SPENTA;
                case SPENTA -> stato = StatoLampadina.ACCESA;
            }
            clickCount--;
        }
        return true;
    }

}
