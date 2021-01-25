package com.example.sudoku.SudokuLogic;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Square>> gameBoard;
    private ArrayList<Configuration> Configurations;

    public Board(){

    }

    public boolean checkWin(){
        boolean win = false;
        return win;

    }

    public boolean updateSquare(int x, int y, int newValue){
        Square current = gameBoard.get(x).get(y);
        if (current.isChangeable()){
            current.setCurrentValue(newValue);
            return true;
        }
        else {
            return false;
        }
    }

}
