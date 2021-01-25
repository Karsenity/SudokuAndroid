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
import java.util.Arrays;

public class NumpadAdapter extends ArrayAdapter {
    private Context context;
    private final ArrayList<Integer> numPad;


    public NumpadAdapter(@NonNull Context context, int range) {
        super(context, R.layout.activity_main, R.id.numPad, createPad(range));
        this.numPad = createPad(range);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Button btn = new Button(super.getContext());
        btn.setText(String.valueOf(numPad.get(position)));
        btn.setClickable(false);
        btn.setFocusable(false);
        return btn;
    }

    private static ArrayList<Integer> createPad(int range){
        ArrayList<Integer> retval = new ArrayList<>();
        for (int i=1; i <= range; i++){
            retval.add(i);
        }
        return retval;
    }

}
