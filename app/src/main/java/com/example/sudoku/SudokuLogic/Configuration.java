package com.example.sudoku.SudokuLogic;

import java.util.ArrayList;

public class Configuration {
    public ArrayList<Square> squaresInConfig;

    public Configuration(ArrayList<Square> squares){
        this.squaresInConfig = squares;
        Square test = new Square(false, 3);

    }

    public boolean checkValid(){
        //if numbers unique
        boolean check = true;

        for (int i = 0; i< this.squaresInConfig.size() - 1 ; i++){
            for (int j=i+1; j < this.squaresInConfig.size(); j++ ){
                //if the numbers are not unique
                int current = this.squaresInConfig.get(i).getCurrentValue();
                int compareTo = this.squaresInConfig.get(j).getCurrentValue();

                if (current == compareTo){
                    check = false;
                }
            }
        }

        return check;
    }

    public ArrayList<Square> getSquaresInConfig(){

        return this.squaresInConfig;

    }

    public ArrayList<Integer> getValueSquares(){
        int size = this.squaresInConfig.size();
        ArrayList<Integer> values = new ArrayList<Integer>();

        for (Square square : this.squaresInConfig){
            Integer squareValue = square.getCurrentValue();
            values.add(squareValue);
        }
        return values;

    }

//    public static void main(String[] args) {
//        ArrayList<SudokuLogic.Square> list = new ArrayList<SudokuLogic.Square>();
//        for(int i =0; i<9; i++) {
//            SudokuLogic.Square square = new SudokuLogic.Square(true, i);
//            list.add(square);
//        }
//
//        SudokuLogic.Configuration test1 = new SudokuLogic.Configuration(list);
//
//        System.out.println(test1.checkValid());
//    }
}
