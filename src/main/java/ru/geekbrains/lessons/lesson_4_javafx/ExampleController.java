package ru.geekbrains.lessons.lesson_4_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class ExampleController {

  @FXML
  public Button btnClick;
  @FXML
  public Label LabelText;


  public void click(javafx.event.ActionEvent actionEvent) {
    System.out.println("Click!!!");
    LabelText.setText("JAVAFX Hello!");
    btnClick.setText("PRESSED");
    btnClick.setScaleX(5.0);
    btnClick.setScaleY(5.0);
  }
}
