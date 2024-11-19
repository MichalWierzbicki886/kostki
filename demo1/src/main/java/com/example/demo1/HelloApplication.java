package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        Label l1 = new Label("Ile kostek rzucasz (3-10)");
        TextField amount_txt = new TextField();



        Button btn = new Button("Rzuć kostkami");
        HBox hbox = new HBox(15);
        VBox vBox = new VBox(10, l1, amount_txt, btn, hbox);
        AtomicInteger points = new AtomicInteger();

        btn.setOnAction(e -> {

            String smth = amount_txt.getText();
            try {
                int amount = Integer.parseInt(smth);
                if (amount >= 3 && amount <= 10) {


                    for (int i=0 ; i<amount ; i++){

                        Random random = new Random();
                        // Generate random number between 1 and 6 (inclusive)
                        int randNumber = random.nextInt(6) + 1;
                        points.addAndGet(randNumber);

                        String rand = Integer.toString(randNumber);

                        Label cos = new Label(rand);
                        hbox.getChildren().addAll(cos);

                    }
                    String points_str = Integer.toString(points.get());
                    Label point = new Label("points: " + points_str);
                    vBox.getChildren().add(point);

                } else {
                    showAlert("Błąd", "Liczba musi być w zakresie 3-10.");
                }
            } catch (NumberFormatException ex) {

                showAlert("Błąd", "Proszę wprowadzić liczbę.");
            }
        });



        Scene scene = new Scene(vBox, 700, 700);

        stage.setTitle("Aplikacja do rzutu kostkami");
        stage.setScene(scene);
        stage.show();
    }

    // Funkcja do wyświetlania alertów
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
