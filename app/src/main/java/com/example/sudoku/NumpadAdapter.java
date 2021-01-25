package com.example.sudoku;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NumpadAdapter extends ArrayAdapter {
    private Context context;
    private final ArrayList<Integer> numPad;
    private int selected;


    public NumpadAdapter(@NonNull Context context, ArrayList<Integer> numPad) {
        super(context, R.layout.activity_main, R.id.numPad, numPad);
        this.context = context;
        this.numPad = numPad;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Button btn = new Button(super.getContext());
        btn.setText(String.valueOf(numPad.get(position)));
        btn.setClickable(false);
        btn.setFocusable(false);
        return btn;
    }
    public void setSelected(int position){
        this.selected = position;
    }

    public void setValue(int position, int val){
        this.numPad.set(position, val);
    }

    public int getSelected(){
        return this.selected;
    }


}
