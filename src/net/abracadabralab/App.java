package net.abracadabralab;

// JavaFX
// Ilja Spirts, 221RDB074, 12. grupa

import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class App extends Application {
  private static int attempts = 7;
  private static Random rnd = new Random();
  private static int number = rnd.nextInt(1, 100);

  @Override
  public void start(Stage primaryStage) {
    Label label1, label2;
    TextField textField;
    Button btnOk, btnNewGame;
    VBox vbox;
    Scene scene;

    label1 = new Label("Input number (1-100):");
    textField = new TextField();
    label2 = new Label("You have 7 attempts to guess a number");
    textField.setMaxWidth(250);

    btnOk = new Button("OK");
    btnNewGame = new Button("New Game");

    btnOk.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        int guessedNumber = 0;

        try {
          guessedNumber = Integer.parseInt(textField.getText());
          if (guessedNumber < 1 || guessedNumber > 100) {
            throw new Exception();
          }
        } catch (Exception ex) {
          label2.setText("error");
          return;
        }

        if (--attempts > 0) {
          if (guessedNumber < number) {
            label2.setText("My number is greater then yours");
          } else if (guessedNumber > number) {
            label2.setText("My number is lower then yours");
          } else {
            label2.setText("You win!");
          }
        } else {
          label2.setText("You lose!");
        }
      }
    });

    btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        textField.setText("");
        label2.setText("You have 7 attempts to guess a number");
        attempts = 7;
        number = rnd.nextInt(1, 100);
      }
    });

    vbox = new VBox(label1, textField, label2, btnOk, btnNewGame);
    vbox.setSpacing(20);
    vbox.setAlignment(Pos.CENTER);
    scene = new Scene(vbox, 300, 300);

    primaryStage.setTitle("Guess a number");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
