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

    public Board(ArrayList<ArrayList<Square>> grid){
        this.gameBoard = grid;
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



}
