package com.example.budgettracker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Image icon = new Image("C:\\Users\\natal\\Desktop\\kurs\\BudgetTracker\\src\\main\\resources\\com\\example\\budgettracker\\images\\coffeebean.png");
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setHeight(900);
        stage.getIcons().add(icon);
        stage.setTitle("BudgetTracker");


        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
