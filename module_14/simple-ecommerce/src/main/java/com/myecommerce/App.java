package com.myecommerce;

import com.google.gson.Gson;
import com.myecommerce.model.Product;

import java.util.HashSet;
import java.util.Set;

import static spark.Spark.*;

public class App {

    private static Set<Product> products = new HashSet<>();

    private static Gson gson = new Gson();

    public static void main(String[] args) {

        /*DATI DI TEST PRE-CARICATI*/
        Product p1 = new Product(1L, 100, 9.99, "P1", "Product P1");
        products.add(p1);

        port(8080); //opzionale, indica su quale porta è in ascolto il mio processo 

        path("/ecommerce", () -> {
            path("/product", () -> {
                        post("/add", (req, res) -> {
                            Product newProduct = gson.fromJson(req.body(), Product.class);

                            /* Dall'esterno mi arriva un prodotto già presente -> Errore */
                            if (products.contains(newProduct)) {
                                res.status(400);
                                return "product already present";
                            }

                            products.add(newProduct);
                            res.status(201);
                            return "ok";
                        });
                    }
            );

            path("/products", () -> {
                get("/available", (req, res) -> {
                            res.type("application/json");
                            res.status(200);

                            return gson.toJson(products);
                        }
                );
            });
        });
    }
}
