package com.example.sudoku.SudokuLogic;

import com.example.sudoku.SudokuLogic.ConfigGenerators.BlockGenerator;
import com.example.sudoku.SudokuLogic.ConfigGenerators.ColumnGenerator;
import com.example.sudoku.SudokuLogic.ConfigGenerators.RowGenerator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/*
The following code is functional but not optimal. Should generate random Sudoku boards until a complete
one is generated. Not every board is usable; will sometimes result in an overflow error if no board
is found.

 */
public class GeneratePuzzle {

    public ArrayList<ArrayList<Square>>  generatePuzzle(int boardLength) {
        ArrayList<ArrayList<Square>> puzzle = new ArrayList<>();

        //generate an empty puzzle board
        for (int i = 0; i < boardLength; i++) {
            ArrayList<Square> puzzleRow = new ArrayList<>();
            for (int j = 0; j < boardLength; j++) {
                Square square = new Square(false, 0);
                puzzleRow.add(square);
            }
            puzzle.add(puzzleRow);
        }

        //put numbers into the board
        ColumnGenerator columnGen = new ColumnGenerator();
        RowGenerator rowGen = new RowGenerator();
        BlockGenerator blockGen = new BlockGenerator();

        ArrayList<Configuration> rows = rowGen.generateConfigurations(puzzle);
        ArrayList<Configuration> columns = columnGen.generateConfigurations(puzzle);
        ArrayList<Configuration> blocks = blockGen.generateConfigurations(puzzle);

        ArrayList<Integer> values = generateNumList(boardLength);

        for (Configuration row : rows) {
            //if 0 is in the row and the row doesnt have the other values and putting a value wont ruin a col or block,
            //then put the value in the row
            Collections.shuffle(values);

            for (int value: values)
                for (Square square : row.getSquaresInConfig())
                    if (square.getCurrentValue() == 0 && !row.getValueSquares().contains(value))
                        for (Configuration col : columns)
                            if (col.getSquaresInConfig().contains(square) && !col.getValueSquares().contains(value))
                                for (Configuration block : blocks)
                                    if (block.getSquaresInConfig().contains(square) && !block.getValueSquares().contains(value))
                                        square.setCurrentValue(value);
        }

        boolean containsZero = false;
        for (Configuration row: rows){
            if (row.getValueSquares().contains(0)){
                containsZero = true;
                break;
            }
        }

        if (!containsZero){
            return puzzle;
        }
        else{
            return generatePuzzle(boardLength);
        }
    }

    //write method to remove numbers from the board
    public void removeNumbersFromBoard(ArrayList<ArrayList<Square>> generatedPuzzle, int numToRemove){
        Random rand = new Random();


        for (int i=0; i<numToRemove; i++){
            int number1 = rand.nextInt(generatedPuzzle.size());
            int number2 = rand.nextInt(generatedPuzzle.size());

            Square toRemove = generatedPuzzle.get(number1).get(number2);
            toRemove.setCurrentValue(0);
        }

        ArrayList<ArrayList<Square>> newBoard = new ArrayList<>();

    }

    public ArrayList<ArrayList<Square>> makeBoardEditable(ArrayList<ArrayList<Square>> gameBoard){

        ArrayList<ArrayList<Square>> newBoard = new ArrayList<>();

        for (ArrayList<Square> row : gameBoard){
            ArrayList<Square> newRow = new ArrayList<>();
            for( Square square : row){
                if (square.getCurrentValue() == 0){
                    Square newSquare = new Square(true, 0);
                    newRow.add(newSquare);
                }
                else{
                    newRow.add(square);
                }
            }
            newBoard.add(newRow);
        }
        return newBoard;
    }

    public ArrayList<Integer> generateNumList(int size){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=1; i<= size; i++){
            numbers.add(i);
        }
        return numbers;
    }


    public static void main(String[] args) {
        GeneratePuzzle generator = new GeneratePuzzle();
        ArrayList<ArrayList<Square>> puzzle = generator.generatePuzzle(9);
        DrawBoard createBoard = new DrawBoard();
        createBoard.drawBoard(puzzle);


        generator.removeNumbersFromBoard(puzzle, 10);

        System.out.println("\n \n" );
        createBoard.drawBoard(puzzle);

        generator.makeBoardEditable(puzzle);

        System.out.println("\n \n" );
        createBoard.drawBoard(puzzle);



    }
}
