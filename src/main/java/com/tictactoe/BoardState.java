package com.tictactoe;

import java.util.HashMap;
import java.util.Objects;
import static com.tictactoe.BoardState.SquareState.*;

public class BoardState {
    enum SquareState {
        UNPLACED, X, O
    }

    private int turnCount;
    private String[][] board;
    private final HashMap<String, SquareState> boardHash = new HashMap<>();
    String[][] winConditions;

    public BoardState() {
        this.turnCount = 0;
        this.winConditions = new String[][]{
                {"00", "10", "20"},
                {"01", "11", "21"},
                {"02", "12", "22"},
                {"00", "01", "02"},
                {"10", "11", "12"},
                {"20", "21", "22"},
                {"02", "11", "20"},
                {"00", "11", "22"}
        };
        resetGame();
    }

    public SquareState getWhoseTurn() {
        if (turnCount % 2 == 0) {
            return X;
        } else {
            return O;
        }
    }

    public void incrementTurnCount() {
        this.turnCount += 1;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public boolean checkWin() {
        int threeInRow = 0;
        for (int x = 0; x < 8; x++) {
            if (threeInRow != 3) {
                for (int y = 0; y < 3; y++) {
                    if (this.boardHash.get(winConditions[x][y]) == getWhoseTurn()) {
                        threeInRow++;
                    }
                    else {
                        threeInRow = 0;
                        break;
                    }
                }
            }
            else {return true;}
        }
        return threeInRow == 3;
    }

    public void setBoardSquare(String boardCoord) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 3; y++) {
                if (Objects.equals(this.winConditions[x][y], boardCoord)) {
                    boardHash.put(boardCoord, getWhoseTurn());
                }
            }
        }

    }

    public void resetGame() {
        String boardCoord;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 3; x++) {
                boardCoord = (x + String.valueOf(y));
                this.boardHash.put(boardCoord, UNPLACED);
            }
        }
        this.turnCount = 0;
    }

    public boolean checkLoseCondition() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 3; y++) {
                if ((this.boardHash.get(winConditions[x][y]) == UNPLACED)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void getBoardTest() {
        System.out.println(boardHash.get("00") + " " + boardHash.get("10") + " " + boardHash.get("20"));
        System.out.println(boardHash.get("01") + " " + boardHash.get("11") + " " + boardHash.get("21"));
        System.out.println(boardHash.get("02") + " " + boardHash.get("12") + " " + boardHash.get("22"));
    }

    public void getWinTest() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.println(x + " " + y + ": " + boardHash.get(winConditions[x][y]));
            }
        }
    }
}
