package com.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Objects;

public class GameController {
    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;
    @FXML
    private Text textWinOrLose;

    BoardState gameState = new BoardState();

    @FXML
    void onButtonClick00(ActionEvent event) {
        playerMove(button00, "00", gameState);
    }

    @FXML
    void onButtonClick01(ActionEvent event) {
        playerMove(button01, "01", gameState);
    }

    @FXML
    void onButtonClick02(ActionEvent event) {
        playerMove(button02, "02", gameState);
    }

    @FXML
    void onButtonClick10(ActionEvent event) {
        playerMove(button10, "10", gameState);
    }

    @FXML
    void onButtonClick11(ActionEvent event) {
        playerMove(button11, "11", gameState);
    }

    @FXML
    void onButtonClick12(ActionEvent event) {
        playerMove(button12, "12", gameState);
    }

    @FXML
    void onButtonClick20(ActionEvent event) {
        playerMove(button20, "20", gameState);
    }

    @FXML
    void onButtonClick21(ActionEvent event) {
        playerMove(button21, "21", gameState);
    }

    @FXML
    void onButtonClick22(ActionEvent event) {
        playerMove(button22, "22", gameState);
    }

    void setButtonAbility(boolean bool) {
        button00.setDisable(bool);
        button10.setDisable(bool);
        button20.setDisable(bool);
        button01.setDisable(bool);
        button11.setDisable(bool);
        button21.setDisable(bool);
        button02.setDisable(bool);
        button12.setDisable(bool);
        button22.setDisable(bool);
    }

    @FXML
    void onButtonClickReset(ActionEvent event) {
        setButtonAbility(false);
        button00.setText("");
        button10.setText("");
        button20.setText("");
        button01.setText("");
        button11.setText("");
        button21.setText("");
        button02.setText("");
        button12.setText("");
        button22.setText("");
        gameState.resetGame();
        textWinOrLose.setText("");

    }

    void playerMove(Button button, String boardCoord, BoardState gameState) {
        if ((!Objects.equals(button.getText(), "X")) && (!Objects.equals(button.getText(), "O"))) {
            button.setText(String.valueOf(gameState.getWhoseTurn()));
            gameState.setBoardSquare(boardCoord);
            if (gameState.checkWin()) {
                textWinOrLose.setText(gameState.getWhoseTurn() + " Won!");
                setButtonAbility(true);
            }
            else if (gameState.getTurnCount() > 7) {
                if (gameState.checkLoseCondition()) {
                    textWinOrLose.setText("Cat's Game!");
                }
            }
            gameState.incrementTurnCount();
        }
    }
}
