package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import javaCode.DisplayData;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MainController {

    @FXML
    private ProgressBar mainBar;

    @FXML
    private Button lessons1Button;

    @FXML
    private Button lessons2Button;

    @FXML
    private Button lessons3Button;

    @FXML
    private Label lessonTitleLabel;

    @FXML
    private Label germanPhraseLabel;

    @FXML
    private TextField userAnswerTextField;

    @FXML
    private Button okButton;

    @FXML
    private Button bigAButton;

    @FXML
    private Button bigOButton;

    @FXML
    private Button bigUButton;

    @FXML
    private Button aButton;

    @FXML
    private Button oButton;

    @FXML
    private Button uButton;

    @FXML
    private Button ssButton;

    @FXML
    private Label goodOrWrongAnsLabel;

    @FXML
    private Label correctAnsLabel;

    @FXML
    private Label numberOfGoodAnswerLabel;

    @FXML
    private Label numberOfWrongAnswerLabel;

    @FXML
    private Label scoreLabel;

    private DisplayData dd = new DisplayData();
    private double mainBarProgress;

    public void initialize() {

        lessons1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lessonTitleLabel.setText(lessons1Button.getText());
                dd.displayAllData(lessons1Button.getText());
                clearFieldAfterButton();
                displayScoreAndNewGermanPhrase();
            }
        });

        lessons2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lessonTitleLabel.setText(lessons2Button.getText());
                dd.displayAllData(lessons2Button.getText());
                clearFieldAfterButton();
                displayScoreAndNewGermanPhrase();
            }
        });

        lessons3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lessonTitleLabel.setText(lessons3Button.getText());
                dd.displayAllData(lessons3Button.getText());
                clearFieldAfterButton();
                displayScoreAndNewGermanPhrase();
            }
        });

        userAnswerTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)){
                    enterOrOkButton();
                }
            }
        });

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                enterOrOkButton();
            }
        });

        ssButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "ß";
                userAnswerTextField.setText(phrase);
            }
        });

        aButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "ä";
                userAnswerTextField.setText(phrase);
            }
        });

        oButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "ö";
                userAnswerTextField.setText(phrase);
            }
        });

        uButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "ü";
                userAnswerTextField.setText(phrase);
            }
        });

        bigAButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "Ä";
                userAnswerTextField.setText(phrase);
            }
        });

        bigOButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "Ö";
                userAnswerTextField.setText(phrase);
            }
        });

        bigUButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String phrase = userAnswerTextField.getText();
                phrase += "Ü";
                userAnswerTextField.setText(phrase);
            }
        });

        mainBar.setProgress(mainBarProgress);

    }

    private void displayScoreAndNewGermanPhrase(){
        germanPhraseLabel.setText(dd.displayPlDesc());
        numberOfGoodAnswerLabel.setText(dd.getCorrectAnsAsString());
        numberOfWrongAnswerLabel.setText(dd.getWrongAnsAsString());
        scoreLabel.setText(dd.getPercentAsString());
    }

    private void enterOrOkButton(){
        String userAnsw = userAnswerTextField.getText();
        dd.collectGeData(userAnsw);
        setBarProgress();
        userAnswerTextField.clear();
        displayScoreAndNewGermanPhrase();
        goodOrWrongAnsLabel.setText(dd.getCorrOrNotAns());
        correctAnsLabel.setText(dd.geDescToLabel());
    }

    private void clearFieldAfterButton(){
        userAnswerTextField.clear();
        goodOrWrongAnsLabel.setText("");
        correctAnsLabel.setText("");
    }

    private void setBarProgress(){
        double i = dd.getCorrectAns();
        double all = dd.getOryginalListSize();
        double value = i/all;
        mainBarProgress = value;
        mainBar.setProgress(mainBarProgress);
    }

}
