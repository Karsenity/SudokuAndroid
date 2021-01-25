package com.example.sudoku.SudokuLogic;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Square>> gameBoard;
    private ArrayList<Configuration> Configurations;
    private int columns;

    public Board(int columns){
        this.columns = 9;
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

    public Square getSquare(int x, int y){
        return gameBoard.get(x).get(y);
    }

    public void initGameBoard(int[][] grid){
        this.gameBoard = new ArrayList<>();

        for (int i=0; i < this.columns; i++){
            this.gameBoard.add(new ArrayList<Square>());
        }

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid.length; j++){
                int current = grid[i][j];
                if (current == 0){
                    this.gameBoard.get(i).add(new Square(true, -1));
                } else {
                    this.gameBoard.get(i).add(new Square(false, grid[i][j]));
                }
            }
        }
    }
}
