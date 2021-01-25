package com.example.sudoku.SudokuLogic;

import java.util.ArrayList;
public class Square {

    private boolean isChangeable;
    private int currentValue;

    public Square(boolean isChangeable, int currentValue){
        this.isChangeable = isChangeable;
        this.currentValue = currentValue;
    }

    public void setCurrentValue(int newValue){
        this.currentValue = newValue;

    }

    public int getCurrentValue(){
        return this.currentValue;
    }

    public boolean isChangeable(){
        return this.isChangeable;
    }

}
