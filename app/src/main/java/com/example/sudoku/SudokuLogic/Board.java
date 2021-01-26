package com.example.sudoku.SudokuLogic;

import com.example.sudoku.SudokuLogic.ConfigGenerators.BlockGenerator;
import com.example.sudoku.SudokuLogic.ConfigGenerators.ColumnGenerator;
import com.example.sudoku.SudokuLogic.ConfigGenerators.RowGenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {
    private ArrayList<ArrayList<Square>> gameBoard;
    private ArrayList<Configuration> Configurations;
    private int columns;

    public Board(int columns){
        this.columns = columns;
    }

    public boolean checkWin(){
        ArrayList<ArrayList<Configuration>> configTypes = new ArrayList<>();

        configTypes.add(new RowGenerator().generateConfigurations(gameBoard));
        configTypes.add(new ColumnGenerator().generateConfigurations(gameBoard));
        configTypes.add(new BlockGenerator().generateConfigurations(gameBoard));

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0; i<gameBoard.size(); i++){numbers.add(i+1);}

        boolean win = true;

        for (ArrayList<Configuration> configType : configTypes){
            for (Configuration config : configType){
                for (int number: numbers){
                    if (!config.getValueSquares().contains(number)){win=false;break;}
                }
            }
        }
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
