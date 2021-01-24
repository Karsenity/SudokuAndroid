package com.example.sudoku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NumpadAdapter extends ArrayAdapter {
    private final ArrayList<Integer> numPad;
    public NumpadAdapter(@NonNull Context context, int resource, ArrayList<Integer> numPad) {
        super(context, resource);
        this.numPad = numPad;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Button btn = new Button(super.getContext());
        btn.setClickable(true);
        btn.setFocusable(false);
        btn.setText(String.valueOf(numPad.get(position)));
        return btn;
    }
}
