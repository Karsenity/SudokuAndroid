package com.example.sudoku.SudokuLogic;


import java.util.ArrayList;

public class DrawBoard {

    public void drawBoard(ArrayList<ArrayList<Square>> board){
        int boardLength = board.size();
        int blockLength = (int) Math.sqrt(boardLength);


        System.out.println("   = = = = = = = = = = = = = = = = = = = = = = = = = = = =   ");
        for (int i=0; i<blockLength; i++ ){
            for (int j=0; j<blockLength; j++){
                System.out.print(" || ");
                for (int k=0; k < blockLength; k++ ){
                    for (int l=0 ; l < blockLength; l++){
                        int rowIndex = blockLength*i + j;
                        int colIndex = blockLength*k + l;

                        System.out.print("  " + board.get(rowIndex).get(colIndex).getCurrentValue() + "  ");
                        //System.out.println(i + "" + j + "" + k);
                    }
                    System.out.print(" || ");
                }
                System.out.println();
            }
            System.out.println("   = = = = = = = = = = = = = = = = = = = = = = = = = = = =   ");
        }


    }

//    public static void main(String[] args) {
//        DrawBoard generator = new DrawBoard();
//
//        ArrayList<ArrayList<Square>> squares = new ArrayList<ArrayList<Square>>();
//
//        for (int i =0 ; i< 4; i++){
//            ArrayList<Square> squareArray = new ArrayList<Square>();
//
//            for (int j=0; j< 4; j++ ){
//                Square square = new Square(true, 0);
//                squareArray.add(square);
//            }
//            squares.add(squareArray);
//        }
//        generator.drawBoard(squares);
//    }
}
