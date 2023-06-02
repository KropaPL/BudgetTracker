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
        Image icon = new Image(getClass().getResourceAsStream("/com/example/budget/Images/coffeebean.png"));
        stage.getIcons().add(icon);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        String backgroundImageUrl = getClass().getResource("/com/example/budget/Images/ziarenkakawy.png").toExternalForm();
        scene.getRoot().setStyle("-fx-background-image: url('" + backgroundImageUrl + "'); -fx-background-size: cover;");
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