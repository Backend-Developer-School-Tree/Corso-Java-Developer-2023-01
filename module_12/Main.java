import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        /* scriviamo un programma che legge da database e crea oggetti */
        List<Utente> utenti = new ArrayList<>();

        // 1) aprire una connessione
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aibnb", "postgres", "password");

        // 2) creo uno statement
        Statement statement = connection.createStatement();

        // 3) posso lanciare delle query e salvare il risultato in un resultSet
        ResultSet resultSet = statement.executeQuery("select nome, cognome from utente");

        // 4) leggo i dati
        while (resultSet.next()) {  // per ogni record (riga) della tabella risultato
            String nome = resultSet.getString("nome");
            String cognome = resultSet.getString("cognome");
            Utente u = new Utente(nome, cognome);
            utenti.add(u);
        }

        // chiudo lo statement
        statement.close();

        System.out.println(utenti);

        // provo ad aggiungere un utente
        Utente u = new Utente("Francesco", "Totti", "ciccio@gmail.com", "36985254");
        addUtente(u, connection);
    }

    public static void addUtente(Utente u, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO utente (nome,cognome,email, indirizzo) VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1, u.getNome());
        preparedStatement.setString(2, u.getCognome());
        preparedStatement.setString(3, u.getEmail());
        preparedStatement.setString(4, u.getIndirizzo());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
