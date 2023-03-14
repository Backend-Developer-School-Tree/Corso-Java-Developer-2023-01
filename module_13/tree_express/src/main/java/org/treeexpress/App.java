package org.treeexpress;

import com.google.gson.Gson;
import org.treeexpress.model.Delivery;
import org.treeexpress.model.DeliveryType;
import org.treeexpress.model.TreeExpressUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import static spark.Spark.*;

public class App {

    private static Gson gson = new Gson();

    static Map<Long, TreeExpressUser> treeExpressUsers = new HashMap<>();
    static List<Delivery> deliveries = new ArrayList<>();

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

                    res.status(200);
                    return gson.toJson(treeExpressUsers);
                });
            });


            path("/delivery", () ->{
                post("/create", (req, res) -> {

                    String senderId = req.queryParams("senderID");
                    String receiverId = req.queryParams("receiverID");

                    if(senderId == null || receiverId == null || senderId.equals("") || receiverId.equals("")){
                        res.status(400);
                        return "Sender or Receiver id not valid";
                    }

                    // Sto recuperando gli utenti dalla hashmap che ha Long come chiave, devo convertire
                    TreeExpressUser userSender = treeExpressUsers.get( Long.valueOf(senderId) );
                    TreeExpressUser userReceiver = treeExpressUsers.get( Long.valueOf(receiverId) );

                    String weightString = req.queryParams("weight");
                    if(weightString == null || weightString.equals("")){
                        res.status(400);
                        return "weightString not present";
                    }
                    double weight = Double.parseDouble(weightString);

                    //TODO: generare ID intero randomico
                    Delivery newDelivery = new Delivery(1L,weight, DeliveryType.SHIPPING,userSender, userReceiver );
                    deliveries.add(newDelivery);

                    res.status(201); //201 --> Created
                    return "ok";
                });

                get("/all", (req, res) -> {

                    res.status(200);
                    return gson.toJson(deliveries);
                });
            });
        });

    }
}
