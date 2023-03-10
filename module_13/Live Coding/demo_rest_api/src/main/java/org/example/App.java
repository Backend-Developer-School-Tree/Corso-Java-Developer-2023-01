package org.example;

import com.google.gson.Gson;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    private static Map<Integer, User> users = new HashMap<>(); //Simulo un DB con una mappa

    public static void main( String[] args ) {

        //Mi creo dei dati di test all'avvio del programma
        User u1 = new User( 1, "username1", "myEmail1@gmail.com");
        User u2 = new User( 2, "username2", "myEmail2@gmail.com");
        User u3 = new User( 3, "username3", "myEmail3@gmail.com");
        users.put(1, u1);
        users.put(2, u2);
        users.put(3, u3);

        // Porta su cui deve girare il processo, è opzionale nel caso prende la default
        port(8080);

        /*
        * Metodo get esposto verso l'esterno che si invoca
        * su endpoint /helloworld
        *
        * path --> è un prefisso per gli endpoint, tutto quello che viene dopo
        * inizia con quel percorso
        *
        * es: http://localhost:8080/api/test/helloworld
        * */
        path( "/api/v1/test", () ->{
            get("/helloworld", (req, res)->{
                return "Hello World nidificato!";
            });
        });
        // Senza nidificazione
        get("/helloworld", (req, res)->{
            return "Hello World!";
        });


        /*
        * Servizio web che torna un  utente dummy
        * */
        get("/user", (req, res)->{
            //mi aspetto nel sevizio una proprietà "id" dopo il ?
            int userId = Integer.valueOf(req.queryParams("id"));

            //Il secondo avrà &
            String username = req.queryParams("username");

            // Cerco nel Database utente con id e/o username che prendo da params
            User userResponse = users.get(userId);

            //Simulo che non ho trovato nessun utente nel database con un parametro 0
            if(userResponse==null){
                res.status(404);
                return new Gson().toJson("User not found");
            }

            //TODO: implementare ricerca per username

            res.type("application/json"); //il tipo di ritorno è json
            return new Gson().toJson(userResponse);
        });

        //Get all users
        get("/users", (req, res)->{
            res.type("application/json");
            return new Gson().toJsonTree(users.values());
        });

        //Delete di un record
        delete("/user", (req, res)->{
            //mi aspetto nel sevizio una proprietà "id" dopo il ?
            int userId = Integer.valueOf(req.queryParams("id"));

            users.remove(userId); //rimuovo dalla mappa

            res.type("application/json");
            return new Gson().toJson("Utente cancellato");
        });

        post("/user", (req, res)->{

            /**
             * req.body --> prendo i dati dal body della richiesta http
             * User.class --> classe per il mapping
             */
            User newUser = new Gson().fromJson(req.body(), User.class);
            newUser.setId(100); //TODO: rendere randomico

            users.put(newUser.getId(), newUser);

            res.type("application/json");
            return new Gson().toJson(newUser);
        });

        put("/user", (req, res)->{

            User user2update = new Gson().fromJson(req.body(), User.class);

            users.put(user2update.getId(), user2update);

            res.type("application/json");
            return new Gson().toJson(user2update);
        });

    }
}
