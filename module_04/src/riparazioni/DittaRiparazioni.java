package riparazioni;

public class DittaRiparazioni {

    private final ListaDiTecnici tecnici;
    private final ListaDiRiparazioni riparazioni;

    public DittaRiparazioni(Riparazione[] riparazioni, Tecnico[] tecnici) {
        this.tecnici = new ListaDiTecnici(tecnici);
        this.riparazioni = new ListaDiRiparazioni(riparazioni);
    }

    public ListaDiTecnici getTecnici(){
        return tecnici;
    }

    public boolean aggiungiRiparazione(Riparazione riparazione) {
        if (esisteRiparazioneDatoIndirizzo(riparazione.getIndirizzo()))
            return false;

        riparazioni.add(riparazione);
        return true;
    }

    public boolean aggiungiTecnico(Tecnico tecnico) {
        if (esisteTecnicoDatoNome(tecnico.getNome()))
            return false;

        tecnici.add(tecnico);
        return true;
    }

    private boolean esisteRiparazioneDatoIndirizzo(String indirizzo) {
        for (int i = 0; i < riparazioni.length(); i++)
            if (riparazioni.get(i).getIndirizzo().equals(indirizzo))
                return true;

        return false;
    }

    private boolean esisteTecnicoDatoNome(String nome) {
        for (int i = 0; i < tecnici.length(); i++)
            if (tecnici.get(i).getNome().equals(nome))
                return true;

        return false;
    }

    public Riparazione[] getRiparazioniInAttesa() {
        Riparazione[] inAttesa = new Riparazione[riparazioni.length()];
        int countInAttesa = 0;

        for (int i = 0; i < riparazioni.length(); i++) {
            if (riparazioni.get(i).getStato().equals(StatoRiparazione.IN_ATTESA))
            {
                inAttesa[countInAttesa] = riparazioni.get(i);
                countInAttesa++;
            }
        }

        return inAttesa;
    }

    public ListaDiRiparazioni getRiparazioni() { return riparazioni; }

    public Riparazione getRiparazioneMaxPriorita(){
        Riparazione risultato = null;

        for (int i = 0; i < riparazioni.length(); i++) {

            if (riparazioni.get(i).getStato().equals(StatoRiparazione.IN_ATTESA))
            {
                if (risultato == null)
                    risultato = riparazioni.get(i);
                else if (riparazioni.get(i).getPriorita() > risultato.getPriorita())
                    risultato = riparazioni.get(i);
            }
        }

        return risultato;
    }

    public boolean assegnaProssimaRiparazione(){
        Tecnico tecnicoLibero = null;
        for (int i = 0; i < tecnici.length(); i++) {
            if (tecnici.get(i).getStato().equals(StatoTecnico.DISPONIBILE))
            {
                tecnicoLibero = tecnici.get(i);
                break;
            }
        }

        if (tecnicoLibero == null)
            return false;

        Riparazione maxPriorita = getRiparazioneMaxPriorita();

        maxPriorita.setStato(StatoRiparazione.IN_CORSO);
        tecnicoLibero.setRiparazione(maxPriorita);

        return true;
    }

    public boolean setRiparazioneTerminata(String nomeTecnico) {
        Tecnico tecnico = cercaTecnicoPerNome(nomeTecnico);

        if (tecnico == null) {
            System.out.println("nome tecnico non trovato");
            return false;
        }

        if (tecnico.getRiparazione() == null) {
            System.out.println("il tecnico specificato non ha una riparazione in corso");
            return false;
        }

        tecnico.getRiparazione().setStato(StatoRiparazione.TERMINATA);
        tecnico.setRiparazione(null);

        return true;
    }

    private Tecnico cercaTecnicoPerNome(String nomeTecnico) {
        for (int i = 0; i < tecnici.length(); i++)
            if (tecnici.get(i).getNome().equals(nomeTecnico))
                return tecnici.get(i);

        return null;
    }

    public void mandaTecniciInFerie(ListaDiTecnici tecniciInFerie) {
        for (int i = 0; i < tecniciInFerie.length(); i++) {
            Tecnico t = cercaTecnicoPerNome(tecniciInFerie.get(i).getNome());
            if(t != null)
                t.vaiInFerie();
        }
    }

    public static void main(String[] args) {
        Tecnico[] tecnici = {new Tecnico("mario"), new Tecnico("giorgio")};
        Riparazione[] riparazioni = new Riparazione[]{
                new Riparazione("via roma", 4),
                new Riparazione("via milano", 4),
                new Riparazione("via milano2", 4),
                new Riparazione("via milano3", 4),
                new Riparazione("via milan4", 4),
                new Riparazione("via milano5", 4)
        };
        DittaRiparazioni d = new DittaRiparazioni(riparazioni, tecnici);

        System.out.println(d.getRiparazioni());
        System.out.println(d.getRiparazioneMaxPriorita());
        System.out.println(d.assegnaProssimaRiparazione());
        System.out.println(d.assegnaProssimaRiparazione());
        System.out.println(d.getRiparazioneMaxPriorita());
        System.out.println(!d.assegnaProssimaRiparazione());
    }

}
