package com.example.shopapp;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopMotoApp extends Application {
    public static Stage primaryStage;
    public static Scene customers;
    public static Scene kindMoto;
    public static Scene sales;


    @Override
    public void start(Stage stage) throws IOException {
        primaryStage=stage;
        customers=createScene("Customer-view.fxml");
        kindMoto=createScene("kind-moto-view.fxml");

        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);
        primaryStage.setTitle("Клиенты");

        customers.getStylesheets().add("base-styles.css");
        primaryStage.setScene(customers);
        primaryStage.show();
    }
    private Scene createScene(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ShopMotoApp.class.getResource(name));
        return new Scene(fxmlLoader.load());
    }
    public static void main(String[] args) {
        launch();
    }
}
