package com.example.sudoku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.sudoku.SudokuLogic.Board;
import com.example.sudoku.SudokuLogic.Square;

import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class GridAdapter extends ArrayAdapter{

    private Context context;
    private ArrayList<Boolean> numberGrid;

    private Board board;
    private TextView winView;
    private int selected = -1;
    private int columnSize;



    public GridAdapter(Context context, ArrayList<Boolean> grid, Board board, TextView winView, int columnSize){
        super(context, R.layout.activity_main, R.id.gridView, grid);
        this.context = context;
        this.numberGrid = grid;
        this.winView = winView;


        this.board = board;
        this.columnSize = columnSize;
    }

    /*
    Converts a call to get a square from the array into the appropriate call from
    the "Board" class and returns the result
     */
    private Square getSquare(int position){
        int x = (int) Math.floor(position / this.columnSize);
        int y = position % this.columnSize;
        return board.getSquare(x, y);
    }


    public boolean updateSquare(int position, int newValue){
        int x = (int) Math.floor(position / this.columnSize);
        int y = position % this.columnSize;
        if (position != -1){
            return board.updateSquare(x, y, newValue);
        }
        return false;
    }

    /*
    Draw method for the Android app, draws an individual square from the Board
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button btn = new Button(context);
        Square current = getSquare(position);

        if (current.isChangeable()){
            btn.setClickable(false);
            btn.setFocusable(false);
            btn.setBackgroundResource(R.drawable.selectable_grid_bckgd);
        } else {
//            btn.setBackgroundColor(Color.parseColor("#729ba8"));
            btn.setBackgroundResource(R.drawable.unclickable_grid_bckgd);
        }

        if (current.getCurrentValue() == -1){
            btn.setText("");
        } else {
            btn.setText(String.valueOf(current.getCurrentValue()));
        }
        return btn;
    }

    /*
    Indicator for which square is currently being selected on the board
     */
    public void setSelected(int position){
        this.selected = position;
    }

    public int getSelected() {
        return this.selected;
    }

    public void updateSelected(int newValue){
        updateSquare(this.selected, newValue);
        this.selected = -1;
        notifyDataSetChanged();
        checkWin();
    }

    public boolean checkWin(){

        if (board.checkWin()){
            winView.setVisibility(View.VISIBLE);
            return true;
        }
        else { return false; }
    }
}
