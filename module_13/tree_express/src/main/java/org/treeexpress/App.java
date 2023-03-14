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

    Map<Long, TreeExpressUser> treeExpressUser = new HashMap<>();
    List<Delivery> deliveries = new ArrayList<>();

    public static void main( String[] args ) {

        path("/express", () -> {
            path("/treeexpressuser", () ->{
                post("add", (req, res) -> {

                    return "ok";
                });
            });
        });

    }
}
