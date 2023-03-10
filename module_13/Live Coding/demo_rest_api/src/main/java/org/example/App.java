package org.example;

import com.google.gson.Gson;
import org.example.model.User;

import static spark.Spark.*;

public class App
{
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );

        // Porta su cui deve girare il processo, è opzionale nel caso prende la default
        port(8080);

        /*
        * Metodo get esposto verso l'esterno che si invoca
        * su endpoint /helloworld
        *
        * es: http://localhost:8080/helloworld
        * */
        get("/helloworld", (req, res)->{
            return "Hello World!";
        });

        /*
        * Servizio web che torna un utente dummy
        * */
        get("/user", (req, res)->{
            User u1 = new User(1, "username1", "myEmail@gmail.com");
            return new Gson().toJson(u1);
        });
    }
}
