package com.itproger.converter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label thirdLineResult; // toGrams || toMillimetres

    @FXML
    private Label secondLineResult; // toKilograms || toCentimeters

    @FXML
    private Label firstLineResult; // toTons || toMetres

    @FXML
    private TextField enterField;

    @FXML
    private MenuItem firstLineMenuItem;

    @FXML
    private MenuItem secondLineMenuItem;

    @FXML
    private MenuItem thirdLineMenuItem;

    @FXML
    private MenuButton chooseMeasure_btn;

    @FXML
    private Text infoLine1;

    @FXML
    private Text infoLine2;

    @FXML
    private Text infoLine3;

    @FXML
    private MenuButton menu_btn;

    @FXML
    void distanceMeasureActivate(ActionEvent event) {
        String metres = "Метры";
        String centimetres = "Сантиметры";
        String millimetres = "Миллиметры";

        infoLine1.setText("Значение в метрах:");
        firstLineMenuItem.setText(metres);
        infoLine2.setText("Значение в сантиметрах:");
        secondLineMenuItem.setText(centimetres);
        infoLine3.setText("Значение в милиметрах:");
        thirdLineMenuItem.setText(millimetres);
        menu_btn.setText("Расстояние");
        chooseMeasure_btn.setText("Метры");
    }

    @FXML
    void weightMeasureActivate(ActionEvent event) {
        String tons = "Тонны";
        String kilograms = "Килограммы";
        String grams = "Граммы";

        infoLine1.setText("Значение в тоннах:");
        firstLineMenuItem.setText(tons);
        infoLine2.setText("Значение в килограммах:");
        secondLineMenuItem.setText(kilograms);
        infoLine3.setText("Значение в граммах:");
        thirdLineMenuItem.setText(grams);
        menu_btn.setText("Вес");
        chooseMeasure_btn.setText("Тонны");
    }

    @FXML
    void firstLineMeasureActivate(ActionEvent event) {
        String metres = "Метры";
        String tons = "Тонны";

        if (menu_btn.getText().equals("Расстояние")) {
            firstLineMenuItem.setText(metres);
            chooseMeasure_btn.setText(metres);
        } else if (menu_btn.getText().equals("Вес")) {
            chooseMeasure_btn.setText(tons);
            firstLineMenuItem.setText(tons);
        }
    }

    @FXML
    void secondLineMeasureActivate(ActionEvent event) {
        String centimetres = "Сантиметры";
        String kilograms = "Килограммы";

        if (menu_btn.getText().equals("Расстояние")) {
            secondLineMenuItem.setText(centimetres);
            chooseMeasure_btn.setText(centimetres);
        } else if (menu_btn.getText().equals("Вес")) {
            secondLineMenuItem.setText(kilograms);
            chooseMeasure_btn.setText(kilograms);
        }
    }

    @FXML
    void thirdLineMeasureActivate(ActionEvent event) {
        String millimetres = "Миллиметры";
        String grams = "Граммы";

        if (menu_btn.getText().equals("Расстояние")) {
            thirdLineMenuItem.setText(millimetres);
            chooseMeasure_btn.setText(millimetres);
        } else if (menu_btn.getText().equals("Вес")) {
            thirdLineMenuItem.setText(grams);
            chooseMeasure_btn.setText(grams);
        }
    }

    @FXML
    void enterNumber(ActionEvent event) {

        if (menu_btn.getText().equals("Вес")) {

            convertWeight();
        } else if (menu_btn.getText().equals("Расстояние")) {
            convertDistance();
        }
    }

    void convertDistance() {

        String metres = "Метры";
        String centimetres = "Сантиметры";
        String millimetres = "Миллиметры";

        double number;

        try {
            number = Double.parseDouble(enterField.getText());
        } catch (Exception e) {
            enterField.setText("");
            firstLineResult.setText("");
            secondLineResult.setText("");
            thirdLineResult.setText("");
            return;
        }


        if (chooseMeasure_btn.getText().equals(metres)) {
            chooseMeasure_btn.setText(metres);
            double toCentimetres = number * 100;
            double toMillimetres = number * 1000;

            firstLineResult.setText(enterField.getText());
            secondLineResult.setText("" + toCentimetres);
            thirdLineResult.setText("" + toMillimetres);
        } else if (chooseMeasure_btn.getText().equals(centimetres)) {
            chooseMeasure_btn.setText(centimetres);
            double toMetres = number * 0.01;
            double toMillimetres = number * 10;

            secondLineResult.setText(enterField.getText());
            firstLineResult.setText("" + toMetres);
            thirdLineResult.setText("" + toMillimetres);
        } else if (chooseMeasure_btn.getText().equals(millimetres)) {
            chooseMeasure_btn.setText(millimetres);
            double toMetres = number * 0.001;
            double toCentimetres = number * 0.1;

            thirdLineResult.setText(enterField.getText());
            firstLineResult.setText("" + toMetres);
            secondLineResult.setText("" + toCentimetres);
        }
    }

    void convertWeight() {

        String tons = "Тонны";
        String kilograms = "Килограммы";
        String grams = "Граммы";

        double number;

        try {
            number = Double.parseDouble(enterField.getText());
        } catch (Exception e) {
            enterField.setText("");
            firstLineResult.setText("");
            secondLineResult.setText("");
            thirdLineResult.setText("");
            return;
        }

        if (chooseMeasure_btn.getText().equals(tons)) {
            chooseMeasure_btn.setText(tons);
            double toKilograms = number * 1000;
            double toGrams = number * 1000000;

            firstLineResult.setText(enterField.getText());
            secondLineResult.setText("" + toKilograms);
            thirdLineResult.setText("" + toGrams);
        } else if (chooseMeasure_btn.getText().equals(kilograms)) {
            chooseMeasure_btn.setText(kilograms);
            double toTons = number * 0.001;
            double toGrams = number * 1000;

            secondLineResult.setText(enterField.getText());
            firstLineResult.setText("" + toTons);
            thirdLineResult.setText("" + toGrams);
        } else if (chooseMeasure_btn.getText().equals(grams)) {
            chooseMeasure_btn.setText(grams);
            double toTons = number * 0.000001;
            double toKilograms = number * 0.001;

            thirdLineResult.setText(enterField.getText());
            firstLineResult.setText("" + toTons);
            secondLineResult.setText("" + toKilograms);
        }
    }

    @FXML
    void initialize() {


    }

}
