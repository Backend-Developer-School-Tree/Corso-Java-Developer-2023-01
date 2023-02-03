public class Cruciverba {

    /* questo metodo prende in input una matrice di caratteri e una parola sottoforma di stringa
    e verifica se la parola è contenuta all'interno della matrice (tipo cruciverba).
     */
    public static boolean cruciverba(char[][] matrice, String parola) {
        // cerco la prima lettera
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                // prendo l'i,j-esimo carattere della matrice
                char carattere_partenza = matrice[i][j];
                // controllo se coincida con la prima lettera della parola da cercare
                if (carattere_partenza != parola.charAt(0)) {
                    continue;
                }
                /* considero la casella in alto controllando che sia la seconda lettera della parola
                (lo faccio per tutte le 8 direzioni possibili)
                 */
                if (i >= parola.length()-1 && matrice[i-1][j] == parola.charAt(1)) { // è una direzione candidata
                    char carattere_attuale = matrice[i-1][j]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i-contatore][j];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione destra */
                if (matrice[0].length - j >= parola.length() && matrice[i][j+1] == parola.charAt(1)) { // è una direzione candidata
                    char carattere_attuale = matrice[i][j+1]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i][j+contatore];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione basso */
                if (matrice.length - i >= parola.length() && matrice[i+1][j] == parola.charAt(1)) { // è una direzione candidata
                    char carattere_attuale = matrice[i+1][j]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i+contatore][j];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione sinistra */
                if (j >= parola.length()-1 && matrice[i][j-1] == parola.charAt(1)) { // è una direzione candidata
                    char carattere_attuale = matrice[i][j-1]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i][j-contatore];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione alto a sinistra */
                if (i >= parola.length()-1 && j >= parola.length()-1 && matrice[i-1][j-1] == parola.charAt(1)) {
                    char carattere_attuale = matrice[i-1][j-1]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i-contatore][j-contatore];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione alto a destra  */
                if (i >= parola.length()-1 && matrice[0].length - j >= parola.length() && matrice[i-1][j+1] == parola.charAt(1)) {
                    char carattere_attuale = matrice[i-1][j+1]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i-contatore][j+contatore];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione basso a destra */
                if (matrice.length - i >= parola.length() && matrice[0].length - j >= parola.length()  && matrice[i+1][j+1] == parola.charAt(1)) {
                    char carattere_attuale = matrice[i+1][j+1]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i+contatore][j+contatore];
                    }
                    if (contatore == parola.length()) return true;
                }

                /* direzione basso a sinistra */
                if (matrice.length - i >= parola.length() && j >= parola.length()-1  && matrice[i+1][j-1] == parola.charAt(1)) {
                    char carattere_attuale = matrice[i+1][j-1]; // punto di partenza (il terzo carattere della parola)
                    int contatore = 1; // il numero di caratteri che ho controllato e che sono uguali
                    while (contatore < parola.length() && carattere_attuale == parola.charAt(contatore)) {
                        contatore++;
                        carattere_attuale = matrice[i+contatore][j-contatore];
                    }
                    if (contatore == parola.length()) return true;
                }
            }
        }
        return false;
    }

}
