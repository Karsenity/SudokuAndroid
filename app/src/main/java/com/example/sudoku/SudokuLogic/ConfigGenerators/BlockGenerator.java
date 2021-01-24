package com.example.sudoku.SudokuLogic.ConfigGenerators;

import com.example.sudoku.SudokuLogic.ConfigGenerator;
import com.example.sudoku.SudokuLogic.Configuration;
import com.example.sudoku.SudokuLogic.Square;

import java.util.ArrayList;

public class BlockGenerator implements ConfigGenerator {

    public ArrayList<Configuration> generateConfigurations(ArrayList<ArrayList<Square>> board) {

        int length = board.size();
        int blockLength = (int) (Math.sqrt(length));

        ArrayList<Configuration> blocks = new ArrayList<>();

        for (int i = 0 ; i < blockLength ; i++)
            for (int j = 0 ; j < blockLength; j++){
                ArrayList<Square> block = new ArrayList<>();
                for (int k = 0 ; k < blockLength ; k++) {
                    for (int l = 0; l < blockLength; l++) {
                        int outer = i * blockLength + k ;
                        int inner = j * blockLength + l;
                        block.add(board.get(outer).get(inner));
                    }
                }

                Configuration blockConfig = new Configuration(block);
                blocks.add(blockConfig);

            }
        return blocks;
    }

//    public static void main(String[] args) {
//        BlockGenerator generator = new BlockGenerator();
//        ArrayList<ArrayList<Square>> squares = new ArrayList<ArrayList<Square>>();
//
//        for (int i = 0 ; i < 4; i++){
//            ArrayList<Square> squareArray = new ArrayList<Square>();
//            for (int j = 0 ; j < 4 ; j++){
//                Square square = new Square(true, i*4 + j);
//                squareArray.add(square);
//            }
//            squares.add(squareArray);
//        }
//
//        ArrayList<Configuration> blocks = generator.generateConfigurations(squares);
//        for (Configuration block : blocks){
//            System.out.println(block.getValueSquares());
//        }
//
//    }


}
