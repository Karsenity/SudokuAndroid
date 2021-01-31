package com.example.sudoku.SudokuLogic;

import com.example.sudoku.CreatePuzzle.CreatePuzzle;
import com.example.sudoku.CreatePuzzle.GridFromFile;
import com.example.sudoku.SudokuLogic.ConfigGenerators.BlockGenerator;
import com.example.sudoku.SudokuLogic.ConfigGenerators.ColumnGenerator;
import com.example.sudoku.SudokuLogic.ConfigGenerators.RowGenerator;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Board {
    private ArrayList<ArrayList<Square>> gameBoard;
    private ArrayList<Configuration> Configurations;
    private int columns;

    public Board(int columns, int missingSquares, ArrayList<ArrayList<Square>> initialBoard) {
        this.columns = columns;
        CreatePuzzle puzzleBuilder = new CreatePuzzle();
        this.gameBoard = initialBoard;
        puzzleBuilder.makePuzzlePlayable(this.gameBoard, missingSquares);
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

    public ArrayList<Boolean> buildBooleanGrid(){
        ArrayList<Boolean> retval = new ArrayList<>();
        for (int i=0; i<this.gameBoard.size(); i++){
            for (int j=0; j<this.gameBoard.size(); j++){
                int current = this.gameBoard.get(i).get(j).getCurrentValue();
                if (current == 0){
                    retval.add(true);
                } else {
                    retval.add(false);
                }
            }
        }
        return retval;
    }

    public Square getSquare(int x, int y){
        return gameBoard.get(x).get(y);
    }

//    public void initGameBoard(int[][] grid){
//        this.gameBoard = new ArrayList<>();
//
//        for (int i=0; i < this.columns; i++){
//            this.gameBoard.add(new ArrayList<Square>());
//        }
//
//        for (int i=0; i<grid.length; i++){
//            for (int j=0; j<grid.length; j++){
//                int current = grid[i][j];
//                if (current == 0){
//                    this.gameBoard.get(i).add(new Square(true, -1));
//                } else {
//                    this.gameBoard.get(i).add(new Square(false, grid[i][j]));
//                }
//            }
//        }
//    }
}
