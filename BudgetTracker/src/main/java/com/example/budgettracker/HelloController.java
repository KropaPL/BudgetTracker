package com.example.budgettracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label tytul;
    @FXML
    private Label kwota;
    @FXML
    private TextField tytulWartosc;
    @FXML
    private TextField kwotaWartosc;

    public void przychod(ActionEvent e ){
        tytul.setVisible(!tytul.isVisible());
        kwota.setVisible(!kwota.isVisible());
        tytulWartosc.setVisible(!tytulWartosc.isVisible());
        kwotaWartosc.setVisible(!kwotaWartosc.isVisible());
    }
    public void koszty(ActionEvent e ){
        tytul.setVisible(!tytul.isVisible());
        kwota.setVisible(!kwota.isVisible());
        tytulWartosc.setVisible(!tytulWartosc.isVisible());
        kwotaWartosc.setVisible(!kwotaWartosc.isVisible());
    }
    public void zapisz(ActionEvent e ){
        tytul.setVisible(!tytul.isVisible());
        kwota.setVisible(!kwota.isVisible());
        tytulWartosc.setVisible(!tytulWartosc.isVisible());
        kwotaWartosc.setVisible(!kwotaWartosc.isVisible());
    }
    public void usun(ActionEvent e ){
        tytul.setVisible(!tytul.isVisible());
        kwota.setVisible(!kwota.isVisible());
        tytulWartosc.setVisible(!tytulWartosc.isVisible());
        kwotaWartosc.setVisible(!kwotaWartosc.isVisible());
    }

}