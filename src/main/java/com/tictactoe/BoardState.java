package com.tictactoe;

import java.util.Objects;

public class BoardState {
    private int turnCount;
    private String[][] board;

    public BoardState() {
        this.turnCount = 0;
        this.board = new String[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.board[x][y] = "";
            }
        }
    }

    public String getWhoseTurn() {
        if (turnCount % 2 == 0) {
            return "X";
        }
        else {
            return "O";
        }
    }

    public void incrementTurnCount() {
        this.turnCount += 1;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoardSquare(int x, int y) {
        this.board[x][y] = getWhoseTurn();
    }

    public void resetGame() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.board[x][y] = "";
            }
        }
        this.turnCount = 0;
    }

    public boolean checkWinCondition(BoardState gameState) {
        boolean threeInRow = false;

        // check columns
        for (int x = 0; x < 3; x++) {
            if (!threeInRow) {
                for (int y = 0; y < 3; y++) {
                    if (Objects.equals(gameState.getBoard()[x][y], gameState.getWhoseTurn())) {
                        threeInRow = true;
                    }
                    else {
                        threeInRow = false;
                        break;
                    }
                }
            }
            else break;
        }
        // check rows
        for (int y = 0; y < 3; y++) {
            if (!threeInRow) {
                for (int x = 0; x < 3; x++) {
                    if (Objects.equals(gameState.getBoard()[x][y], gameState.getWhoseTurn())) {
                        threeInRow = true;
                    }
                    else {
                        threeInRow = false;
                        break;
                    }
                }
            }
            else break;
        }
        // check diagonals
        if (Objects.equals(gameState.getBoard()[1][1], gameState.getWhoseTurn())) {
            if ((Objects.equals(gameState.getBoard()[2][0], gameState.getWhoseTurn()))) {
                if ((Objects.equals(gameState.getBoard()[0][2], gameState.getWhoseTurn()))) {
                    return true;
                }
            }
            if ((Objects.equals(gameState.getBoard()[0][0], gameState.getWhoseTurn()))) {
                if ((Objects.equals(gameState.getBoard()[2][2], gameState.getWhoseTurn()))) {
                    return true;
                }
            }
        }

        return threeInRow;
    }

    public boolean checkLoseCondition() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if ((Objects.equals(this.getBoard()[x][y], ""))) {
                    return false;
                }
            }
        }
        return true;
    }

}

