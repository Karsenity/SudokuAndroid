package com.example.sudoku.SudokuLogic.ConfigGenerators;

import com.example.sudoku.SudokuLogic.ConfigGenerator;
import com.example.sudoku.SudokuLogic.Configuration;
import com.example.sudoku.SudokuLogic.Square;

import java.util.ArrayList;

public class ColumnGenerator implements ConfigGenerator {

    public ArrayList<Configuration> generateConfigurations(ArrayList<ArrayList<Square>> board) {

        ArrayList<Configuration> columnsList = new ArrayList<Configuration>();

        for (int i=0 ; i< board.size(); i++ ){

            ArrayList<Square> columnArray = new ArrayList<Square>();

            for (ArrayList<Square> row : board){
                columnArray.add(row.get(i));
            }
            Configuration columnConfig = new Configuration(columnArray);
            columnsList.add(columnConfig);

        }
        return columnsList;
    }


//    public static void main(String[] args){
//        ColumnGenerator generator = new ColumnGenerator();
//        ArrayList<ArrayList<Square>> squares = new ArrayList<ArrayList<Square>>();
//
//        for (int i =0 ; i< 3; i++){
//            ArrayList<Square> squareArray = new ArrayList<Square>();
//
//            for (int j=0; j< 3; j++ ){
//                Square square = new Square(true, i*3 + j);
//                squareArray.add(square);
//            }
//            squares.add(squareArray);
//        }
//        System.out.println(squares);
//        System.out.println(generator.generateConfigurations(squares));
//        for (Configuration column :  generator.generateConfigurations(squares)){
//            System.out.println("Look!" + column.getSquaresInConfig());
//        }
//    }
}
