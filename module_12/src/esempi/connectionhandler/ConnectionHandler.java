package esempi.connectionhandler;

import java.sql.*;
import java.util.Properties;

public class ConnectionHandler implements AutoCloseable {

    public static final String DB_URL_PREFIX = "jdbc:postgresql://";
    /**
     * The host name of the server. Defaults to localhost.
     */
    public static final String DB_HOST = "localhost";
    /**
     * The port number the server is listening on.
     * Defaults to the PostgreSQL® standard port number (5432).
     */
    public static final String DB_PORT = "5432";
    /**
     * The database name.
     * The default is to connect to a database with the same name as the user name used to connect to the server.
     */
    public static final String DB_NAME = "AndiamoATeatro";
    /**
     * The database user on whose behalf the connection is being made.
     */
    public static final String DB_USER = "postgres";
    /**
     * The database user’s password.
     */
    public static final String DB_PASSWORD = "postgres";

    private final Properties databaseProps = new Properties();

    private static ConnectionHandler instance;

    private Connection connection;

    private ConnectionHandler() {
        this.databaseProps.setProperty("user", DB_USER);
        this.databaseProps.setProperty("password", DB_PASSWORD);

        // Explicitly loading the driver is no longer required since Java 1.6
        // https://jdbc.postgresql.org/documentation/use/#loading-the-driver
        // Class.forName("org.postgresql.Driver");
    }

    public static ConnectionHandler getInstance() {
        if (instance == null)
            instance = new ConnectionHandler();

        return instance;
    }

    public String getDatabaseUrl() { return DB_URL_PREFIX + DB_HOST + ":" + DB_PORT + "/" + DB_NAME; }

    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed())
            // se la connessione non esiste o è chiusa, ne viene creata una nuova
            this.connection = DriverManager.getConnection(getDatabaseUrl(), databaseProps);

        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
            this.connection = null;
        }
    }

    @Override
    public void close() throws SQLException { this.closeConnection(); }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        // utilizziamo il metodo getConnection invece di accedere direttamente al campo connection
        // per garantire che la connection esista e sia attiva
        Connection conn = getConnection();

        return conn.prepareStatement(query);
    }

    public static void main(String[] args) throws SQLException {
        // esistono vari modi per ottenere una connection con un DB postgresql
        String username = "postgres";
        String password = "postgres";
        Connection conn;

        // 1. specificando tutti i parametri nell'url
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro?user=" + username + "&password=" + password);

        // 2. specificando user e password come parametri del metodo getConnection
        // (eventuali altri parametri andranno comunque specificati nell'url)
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro", username, password);

        // 3. utilizzando un oggetto Properties
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AndiamoATeatro", props);

        PreparedStatement ps = conn.prepareStatement("SELECT id, nome, cognome FROM utente;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) System.out.println(rs.getString("nome"));

        conn.close();
        ps.close();
        rs.close();

        // <-------------------------------------------- ConnectionHandler -------------------------------------------->

        // gestiamo in maniera strutturata apertura/chiusura della connessione con il DB, garantendone l'univocità
        ConnectionHandler ch = ConnectionHandler.getInstance();
        ps = ch.getPreparedStatement("SELECT * FROM utente;");
        rs = ps.executeQuery();
        while (rs.next()) System.out.println(rs.getString("nome"));

        ch.closeConnection();
        ps.close();
        rs.close();

        // implementando l'interfaccia AutoClosable,
        // possiamo chiudere il tutto (PreparedStatement, ResultSet e Connection) anche tramite try-with-resources
        try (ConnectionHandler ch2 = ConnectionHandler.getInstance();
             PreparedStatement ps2 = ch2.getPreparedStatement("SELECT * FROM utente;");
             ResultSet rs2 = ps2.executeQuery())
        {
            while (rs2.next()) System.out.println(rs2.getString("nome"));
        }
        /*
        // la chiusura manuale di ogni risorsa aperta non è più necessaria (che andrebbe fatta in un finally)
        finally {
            ch2.closeConnection();
            ps2.close();
            rs2.close();
        }
         */
    }
}
