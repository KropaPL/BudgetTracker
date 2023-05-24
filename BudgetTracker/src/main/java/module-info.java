module com.example.budgettracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.budgettracker to javafx.fxml;
    exports com.example.budgettracker;
}