package com.example.sudoku.CreatePuzzle;

import com.example.sudoku.SudokuLogic.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MakePuzzlePlayable {

    public  void makePuzzlePlayable(ArrayList<ArrayList<Square>> beep){

    }

    public void permuteNumbers(ArrayList<ArrayList<Square>> rawBoard){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0; i<rawBoard.size(); i++){ numbers.add(i+1); }
        Collections.shuffle(numbers);

        for (ArrayList<Square> row: rawBoard){
            for (Square square : row){
                int value = square.getCurrentValue();
                int newValue = numbers.get(value-1);
                square.setCurrentValue(newValue);
            }
        }
    }

    public ArrayList<ArrayList<Square>> rotateBoard(ArrayList<ArrayList<Square>> rawBoard){
        ArrayList<ArrayList<Square>> newBoard = new ArrayList<>();
        for (int i=0; i<rawBoard.size(); i++){
            ArrayList<Square> newRow = new ArrayList<>();
            for (int j=0; j<rawBoard.size(); j++){
                Square square = rawBoard.get(rawBoard.size()-1-j).get(i);
                newRow.add(square);
            }
            newBoard.add(newRow);
        }
        return newBoard;
    }

    public ArrayList<ArrayList<Square>> flipBoardHorizontal(ArrayList<ArrayList<Square>> rawBoard){
        ArrayList<ArrayList<Square>> newBoard = new ArrayList<>();
        for (int i=0; i<rawBoard.size(); i++){
            ArrayList<Square> newRow = new ArrayList<>();
            for (int j=0; j<rawBoard.size(); j++){
                Square square = rawBoard.get(i).get(rawBoard.size()-1-j);
                newRow.add(square);
            }
            newBoard.add(newRow);
        }
        return newBoard;
    }

    public ArrayList<ArrayList<Square>> flipBoardVertical(ArrayList<ArrayList<Square>> rawBoard){
        ArrayList<ArrayList<Square>> newBoard = new ArrayList<>();
        for (int i=0; i<rawBoard.size(); i++){
            ArrayList<Square> newRow = new ArrayList<>();
            for (int j=0; j<rawBoard.size(); j++){
                Square square = rawBoard.get(rawBoard.size()-1-i).get(j);
                newRow.add(square);
            }
            newBoard.add(newRow);
        }
        return newBoard;
    }

    public void removeNumbers(ArrayList<ArrayList<Square>> rawBoard, int numToRemove){
        Random rand = new Random();

        for (int i=0; i<numToRemove; i++){
            int number1 = rand.nextInt(rawBoard.size());
            int number2 = rand.nextInt(rawBoard.size());

            Square toRemove = rawBoard.get(number1).get(number2);
            toRemove.setCurrentValue(0);
        }
    }


}