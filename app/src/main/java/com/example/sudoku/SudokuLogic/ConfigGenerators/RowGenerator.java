package com.example.sudoku.SudokuLogic.ConfigGenerators;

import com.example.sudoku.SudokuLogic.ConfigGenerator;
import com.example.sudoku.SudokuLogic.Configuration;
import com.example.sudoku.SudokuLogic.Square;

import java.util.ArrayList;

public class RowGenerator implements ConfigGenerator {

    public RowGenerator(){}

    public ArrayList<Configuration> generateConfigurations(ArrayList<ArrayList<Square>> board) {

        ArrayList<Configuration> rowsList = new ArrayList<Configuration>();
        for (ArrayList<Square> rowArray : board){
            Configuration rowConfig = new Configuration(rowArray);
            rowsList.add(rowConfig);
        }

        return rowsList;
    }


}
