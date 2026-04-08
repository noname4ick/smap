package com.map;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;

public class MapView extends Pane {

    public MapView(WebEngine engine) {

        Image map = new Image("img_no_background.png");

        ImageView imageView = new ImageView(map);

        imageView.setFitWidth(900);
        imageView.setFitHeight(600);

        getChildren().add(imageView);

        Label tashkent = createRegionLabel(
                630,
                290,
                "Tashkent",engine
        );
        Label andijon = createRegionLabel(
                770,
                310,
                "Andijon",engine
        );
        Label namangan = createRegionLabel(
                700,
                300,
                "Namangan",engine
        );
        Label fergana = createRegionLabel(
                720,
                335,
                "Fergana",engine
        );
        Label srdr = createRegionLabel(
                600,
                340,
                "Syrdarya",engine
        );
        Label qshq = createRegionLabel(
                480,
                460,
                "Kashkadarya",engine
        );
        Label srnd = createRegionLabel(
                540,
                520,
                "Surkhandarya",engine
        );
        Label smk = createRegionLabel(
                500,
                400,
                "Samarkand",engine
        );
        Label khrzm = createRegionLabel(
                280,
                300,
                "Khorezm",engine
        );
        Label navoi = createRegionLabel(
                420,
                240,
                "Navoiy",engine
        );
        Label bkhr = createRegionLabel(
                390,
                380,
                "Bukhara",engine
        );
        Label krktn = createRegionLabel(
                180,
                130,
                "Karakalpakstan",engine
        );
        Label jzzx = createRegionLabel(
                560,
                360,
                "Jizzakh",engine
        );

        getChildren().addAll(
                tashkent,
                andijon,
                namangan,
                fergana,
                smk,
                srdr,
                khrzm,
                krktn,
                qshq,
                bkhr,
                navoi,
                srnd,
                jzzx
        );
    }
    private Label createRegionLabel(
            double x,
            double y,
            String regionName,
            WebEngine engine) {

        Label lbl = new Label(regionName);
        lbl.setFont(Font.font("Consolas",FontWeight.BOLD,12));
        lbl.setLayoutX(x);
        lbl.setLayoutY(y);
        if(regionName.equals("Syrdarya")){
            regionName = "Sirdaryo_Region";
        }
        String finalRegionName = regionName;
        lbl.setOnMouseClicked(e -> {
            engine.load("https://en.wikipedia.org/wiki/"+ finalRegionName);
        });

        return lbl;
    }
}