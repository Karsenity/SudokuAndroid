package com.example.sudoku;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView);

        grid.setNumColumns(9);
        ExampleGrid example = new ExampleGrid();
        ArrayList<Integer> exampleGrid = example.returnExampleGrid();

        GridAdapter adapter = new GridAdapter(this, exampleGrid);
        grid.setAdapter(adapter);

        // Testing number-bar along bottom
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView numPad = (RecyclerView) findViewById(R.id.numPad);
        numPad.setLayoutManager(layoutManager);

        int[] pad = new int[]{1,2,3,4,5,6,7,8,9};
        NumpadAdapter adapter = new NumpadAdapter(this, new ArrayList<Integer>(Arra))


//        Button testButton = findViewById(R.id.testButton);
//        testButton.setOnClickListener(new AdapterView.OnClickListener() {
//
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onClick(View v) {
//                GridView grid = (GridView) findViewById(R.id.gridView);
//                GridAdapter adapter = (GridAdapter) grid.getAdapter();
//                Optional<Integer> selected = Optional.ofNullable(adapter.getSelected());
//                selected.ifPresent(integer -> adapter.setValue(integer, 1));
//                adapter.notifyDataSetChanged();
//
//            }
//        });



        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridView grid = findViewById(R.id.gridView);
                GridAdapter adapter = (GridAdapter) grid.getAdapter();
                adapter.setSelected(position);
            }
        });







    }
}