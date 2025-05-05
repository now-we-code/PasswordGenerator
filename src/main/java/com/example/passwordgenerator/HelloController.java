package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    private TextField phrase, password, num, num1;

    @FXML
    private VBox phrases;

    @FXML
    private CheckBox leet, spcl;

    @FXML
    private RadioButton rd_s, rd_e, rd_r;

    private PassGen p;

    @FXML
    protected void onGenerate() {
        int length = Integer.parseInt(num.getText());
        int _num = Integer.parseInt(num1.getText());
        boolean _leet = leet.isSelected();
        boolean specs = spcl.isSelected();

        char upper = 'S';
        if (rd_e.isSelected()) {
            upper = 'E';
        } else if (rd_s.isSelected()) {
            upper = 'S';
        } else if (rd_r.isSelected()) {
            upper = 'R';
        }
        if (length != 0 && _num != 0) {
            String pass = p.getPassword(length, _num, specs, upper, _leet);
            password.setText(pass);
        }
    }

    @FXML
    protected void onAdd() {
        String _phrase = phrase.getText();
        if (!_phrase.isEmpty()) {
            Label l = new Label(_phrase);
            l.getStyleClass().add("token");
            phrases.getChildren().add(l);
            p.addPhrase(_phrase);
        }
        phrase.clear();

    }

    public HelloController() {
        this.p = new PassGen();
    }
}