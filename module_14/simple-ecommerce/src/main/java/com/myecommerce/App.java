package com.myecommerce;

import com.google.gson.Gson;
import com.myecommerce.model.Product;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static spark.Spark.*;

/*
* TODO:
*  1. Implementare ricerca prodotto per ID e per name 
*  2. Aggiungere persistenza (DB)
*  3. Bonus: modificare il codice per aggiungere JUnit (es creare classe DummyDB dove
* gestire i prodotti e testare quella classe)
* */
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

                post("/buy", (req, res) -> {
                    String productID = req.queryParams("id");
                    String quantity =req.queryParams("quantity"); //String perché se null mi potrebbe dare problemi

                    if(productID == null || quantity == null || productID.equals("") || quantity.equals("")){
                        res.status(400);
                        return "Malformed request";
                    }

                    // Ho convertito la stringa che arriva dall'esterno nel mio tipo numerico
                    long productIDConverted = Long.valueOf(productID);
                    int quantityConverted = Integer.valueOf(quantity);

                    Optional<Product> productOptional = products.stream()
                                                                .filter(prod -> prod.getId() == productIDConverted)
                                                                .findFirst();

                    // ID valido ma non esistente
                    if(productOptional.isEmpty()){
                        res.status(404);
                        return "Product not found";
                    }

                    // Controllo se quantità sufficiente
                    Product product = productOptional.get();
                    if(product.getStockAvailability()<quantityConverted){
                        res.status(404);
                        return "Product out of stock";
                    }

                    product.decreaseStock(quantityConverted);
                    res.status(200);

                    return "Ok";
                });

                //TODO: Modificare parse da long a String e implementare controllo su ID
                delete("/remove", (req, res) -> {
                    long productID = Long.valueOf(req.queryParams("id"));

                    // Controllo di esistenza del prodotto non necessario (se non esiste è già come lo volevamo)
                    products.removeIf( p -> p.getId() == productID );

                    res.status(200);
                    return "ok";
                });
            }

            );

            path("/products", () -> {
                get("/available", (req, res) -> {
                    res.type("application/json");
                    res.status(200);

                    return gson.toJson(products);
                });
            });
        });
    }
}