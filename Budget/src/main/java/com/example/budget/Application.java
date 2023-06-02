package com.example.budget;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Image icon = new Image("C:\\Users\\natal\\Desktop\\kurs\\BudgetTracker\\Budget\\src\\main\\resources\\com\\example\\budget\\Images\\coffeebean.png");
        stage.getIcons().add(icon);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("BudgetTracker");
        stage.setHeight(450);
        stage.setWidth(620);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}