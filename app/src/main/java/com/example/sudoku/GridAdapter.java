package com.example.sudoku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.ArrayRes;

import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class GridAdapter extends ArrayAdapter{

    private Context context;
    private ArrayList<Integer> numberGrid;
    private ArrayList<Integer> initialGrid;
    private int selected;

    public GridAdapter(Context context, ArrayList<Integer> grid, ArrayList<Integer> initialGrid){
        super(context, R.layout.activity_main, R.id.gridView, grid);
        this.context = context;
        this.numberGrid = grid;
        this.initialGrid = initialGrid;

    }


    // This appears to just be the draw method for the button
    // The position is the actual button, i.e. the index
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println( "getView was called");
        Button btn = new Button(context);

        int number = initialGrid.get(position);

        if (number == 0){
            btn.setClickable(false);
            btn.setFocusable(false);
        }


        btn.setText(String.valueOf(number));
        return btn;
    }

    public void setSelected(int position){
        this.selected = position;
    }

    public void setValue(int position, int val){
        if (this.selected != -1) {
            this.numberGrid.set(position, val);
        }
        this.selected = -1;
    }

    public int getSelected(){return this.selected;}
}
