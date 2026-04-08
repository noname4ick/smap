package com.map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Map extends Application {
    @Override
    public void start(Stage stage) {
        HBox top = new HBox(10);
        Label name = new Label("Interactive map of Uzbekistan || Press the location names to get the information");
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font("Consolas", FontWeight.BOLD, 16));
        top.setPadding(new Insets(12));
        top.setStyle("-fx-background-color: #2C3E50");
        top.getChildren().add(name);
        //info
        HBox info = new HBox(10);
        info.setPadding(new Insets(12));
        info.setStyle(
                "-fx-background-color: white;" +
                        "-fx-padding:15;"+
                        "-fx-border-color: black;");

        WebView browser = new WebView();
        browser.setPrefSize(500,650);
        WebEngine engine =
                browser.getEngine();
        info.getChildren().add(browser);
        //Creating a map instance
        MapView mapView = new MapView(engine);
        //BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(mapView);
        root.setTop(top);
        root.setRight(info);
        Scene scene = new Scene(root, 1400, 650);
        stage.setTitle("Uzbekistan Regions");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

}
