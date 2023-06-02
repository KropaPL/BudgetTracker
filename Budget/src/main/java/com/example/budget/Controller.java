package com.example.budget;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    float pokazanerazem = 0;
    File currentFile;
    Image tlo = new Image(getClass().getResourceAsStream("/com/example/budget/Images/ziarenkakawy.png"));
    List<Pane> kontenery = new ArrayList<>();
    @FXML
    private Button przychod, koszt, zapisz, wyczysc;
    @FXML
    private TextField tytul, kwota;
    @FXML
    private DatePicker data;
    @FXML
    private AnchorPane zbior, tloglowne;
    @FXML
    private Text wynik;
    @FXML
    private ScrollPane zbiorek;
    @FXML
    private Label komunikat, komunikat2;

    @FXML
    protected void onbtnprzychod() {
        if (tytul.getText().equals("") || kwota.getText().equals("") || data.getValue() == null || tytul.getText().length() > 30) {
            komunikat.setVisible(true);
            if (tytul.getText().length() > 30) {
                komunikat.setVisible(false);
                komunikat2.setVisible(true);
            }
        } else {
            komunikat.setVisible(false);
            komunikat2.setVisible(false);
            double containerHeight = 40; // Wysokość kontenera
            double spacing = 10; // Odstęp między kontenerami

            Pane nowy = new AnchorPane();
            kontenery.add(nowy);
            nowy.setPrefHeight(containerHeight);
            nowy.setPrefWidth(315);
            nowy.setStyle("-fx-background-color: #F3EDE5;\n" +
                    "-fx-border-color: #B27C47;\n" +
                    "-fx-border-width: 2px;\n" +
                    "-fx-border-radius: 1px;" +
                    "-fx-background-size: cover");

            nowy.setLayoutX(5);

            Label pokazanytytul = new Label();
            pokazanytytul.setText(tytul.getText());
            Label pokazanakwota = new Label();
            pokazanakwota.setText(kwota.getText());
            Label pokazanadata = new Label();
            pokazanadata.setText(String.valueOf(data.getValue()));

            double newY = zbior.getChildren().size() * (containerHeight + spacing) + 10;
            nowy.setLayoutY(newY);

            nowy.getChildren().add(pokazanytytul);
            pokazanytytul.setLayoutX(5);
            pokazanytytul.setLayoutY(10);
            nowy.getChildren().add(pokazanakwota);
            pokazanakwota.setLayoutX(270);
            pokazanakwota.setLayoutY(10);
            nowy.getChildren().add(pokazanadata);
            pokazanadata.setLayoutX(160);
            pokazanadata.setLayoutY(10);

            pokazanerazem += Float.parseFloat(kwota.getText());
            zbior.getChildren().add(nowy);

            wynik.setText(String.format("%.2f", pokazanerazem));
            Group viewportContent = new Group(zbior);
            zbiorek.setContent(viewportContent);
        }
    }

    @FXML
    protected void onbtnkoszt() {
        if (tytul.getText().equals("") || kwota.getText().equals("") || data.getValue() == null || tytul.getText().length() > 30) {
            komunikat.setVisible(true);
            if (tytul.getText().length() > 30) {
                komunikat.setVisible(false);
                komunikat2.setVisible(true);
            }
        } else {
            komunikat.setVisible(false);
            komunikat2.setVisible(false);
            double containerHeight = 40; // Wysokość kontenera
            double spacing = 10; // Odstęp między kontenerami

            Pane nowy = new AnchorPane();
            kontenery.add(nowy);
            nowy.setPrefHeight(containerHeight);
            nowy.setPrefWidth(315);
            nowy.setStyle("-fx-background-color: #F3EDE5;\n" +
                    "-fx-border-color: #B27C47;\n" +
                    "-fx-border-width: 2px;\n" +
                    "-fx-border-radius: 1px;" +
                    "-fx-background-size: cover");

            nowy.setLayoutX(5);

            Label pokazanytytul = new Label();
            pokazanytytul.setText(tytul.getText());
            Label pokazanakwota = new Label();
            pokazanakwota.setText(kwota.getText());
            Label pokazanadata = new Label();
            pokazanadata.setText(String.valueOf(data.getValue()));

            double newY = zbior.getChildren().size() * (containerHeight + spacing) + 10;
            nowy.setLayoutY(newY);

            nowy.getChildren().add(pokazanytytul);
            pokazanytytul.setLayoutX(5);
            pokazanytytul.setLayoutY(10);
            nowy.getChildren().add(pokazanakwota);
            pokazanakwota.setLayoutX(270);
            pokazanakwota.setLayoutY(10);
            nowy.getChildren().add(pokazanadata);
            pokazanadata.setLayoutX(160);
            pokazanadata.setLayoutY(10);

            pokazanerazem -= Float.parseFloat(kwota.getText());
            zbior.getChildren().add(nowy);

            wynik.setText(String.format("%.2f", pokazanerazem));
            Group viewportContent = new Group(zbior);
            zbiorek.setContent(viewportContent);
        }
    }

    @FXML
    protected void onbtnzapisz() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zapisz jako");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik tekstowy (*.txt)", "*.txt"));
        Stage stage = (Stage) zbior.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            currentFile = file;
            try (PrintWriter writer = new PrintWriter(file)) {
                for (Pane kontener : kontenery) {
                    Label tytulLabel = (Label) kontener.getChildren().get(0);
                    Label kwotaLabel = (Label) kontener.getChildren().get(1);
                    Label dataLabel = (Label) kontener.getChildren().get(2);

                    String tytul = tytulLabel.getText();
                    String kwota = kwotaLabel.getText();
                    String data = dataLabel.getText();

                    writer.println(tytul + "," + kwota + "," + data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onbtnwyczysc() {
        if (currentFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                writer.write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        pokazanerazem = 0;
        kontenery.clear();
        zbior.getChildren().clear();
        wynik.setText("0");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kontenery = new ArrayList<>();
        wynik.setText("0");
        zbiorek.setContent(zbior);
        zbiorek.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        komunikat.setVisible(false);
        komunikat2.setVisible(false);


        Platform.runLater(() -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Wczytaj plik");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik tekstowy (*.txt)", "*.txt"));
            Stage stage = (Stage) zbior.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 3) {
                            String tytul = parts[0];
                            String kwota = parts[1];
                            String data = parts[2];

                            double containerHeight = 40; // Wysokość kontenera
                            double spacing = 10; // Odstęp między kontenerami

                            Pane nowy = new AnchorPane();
                            kontenery.add(nowy);
                            nowy.setPrefHeight(containerHeight);
                            nowy.setPrefWidth(315);
                            nowy.setStyle("-fx-background-color: #F3EDE5;\n" +
                                    "-fx-border-color: #B27C47;\n" +
                                    "-fx-border-width: 2px;\n" +
                                    "-fx-border-radius: 1px;" +
                                    "-fx-background-size: cover");

                            nowy.setLayoutX(5);

                            Label pokazanytytul = new Label();
                            pokazanytytul.setText(tytul);
                            Label pokazanakwota = new Label();
                            pokazanakwota.setText(kwota);
                            Label pokazanadata = new Label();
                            pokazanadata.setText(data);

                            double newY = zbior.getChildren().size() * (containerHeight + spacing) + 10;
                            nowy.setLayoutY(newY);

                            nowy.getChildren().add(pokazanytytul);
                            pokazanytytul.setLayoutX(5);
                            pokazanytytul.setLayoutY(10);
                            nowy.getChildren().add(pokazanakwota);
                            pokazanakwota.setLayoutX(270);
                            pokazanakwota.setLayoutY(10);
                            nowy.getChildren().add(pokazanadata);
                            pokazanadata.setLayoutX(160);
                            pokazanadata.setLayoutY(10);

                            pokazanerazem += Float.parseFloat(kwota);
                            zbior.getChildren().add(nowy);
                        }
                    }
                    reader.close();
                    wynik.setText(String.format("%.2f", pokazanerazem));
                    Group viewportContent = new Group(zbior);
                    zbiorek.setContent(viewportContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
