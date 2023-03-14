package org.treeexpress;

import com.google.gson.Gson;
import org.treeexpress.model.Delivery;
import org.treeexpress.model.TreeExpressUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import static spark.Spark.*;

public class App {

    private static Gson gson = new Gson();

    static Map<Long, TreeExpressUser> treeExpressUsers = new HashMap<>();
    List<Delivery> deliveries = new ArrayList<>();

    public static void main( String[] args ) {
        port(8081); //8081 perché 8080 era già occupata :)

        path("/express", () -> {
            path("/treeexpressuser", () ->{
                post("/add", (req, res) -> {

                    //TODO: implementare controllo su ID
                    TreeExpressUser newExpressUser = gson.fromJson(req.body(),TreeExpressUser.class);

                    treeExpressUsers.put(newExpressUser.getId(), newExpressUser);

                    res.status(201); //201 --> creato
                    return "ok";
                });

                get("/all", (req, res) -> {

                    res.status(201); //201 --> creato
                    return gson.toJson(treeExpressUsers);
                });
            });
        });

    }
}
