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

import com.example.sudoku.SudokuLogic.Board;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Replace example grid below with function in Board for generating
        // random board on creation

        // Example grid being used for testing
        int[][] exampleGrid = ExampleGrid.returnExampleGrid();
        // Create the board for the game
        int columns = 9;
        Board board = new Board(columns);
        board.initGameBoard(exampleGrid);

        // Find the GridView from activity_main.xml and attach the adapter
        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setNumColumns(columns);
        GridAdapter adapter = new GridAdapter(this, ExampleGrid.booleanGrid(exampleGrid), board, 9);
        grid.setAdapter(adapter);

        // Find the NumPad from activity_main.xml and attach the corresponding adapter
        GridView numPad = (GridView) findViewById(R.id.numPad);
        numPad.setNumColumns(columns);
        NumpadAdapter numPadAdapter = new NumpadAdapter(this, columns);
        numPad.setAdapter(numPadAdapter);


        numPad.setOnItemClickListener((AdapterView.OnItemClickListener) (parent, view, position, id) -> {
            GridView grid1 = (GridView) findViewById(R.id.gridView);
            GridAdapter adapter1 = (GridAdapter) grid1.getAdapter();

            int clickedValue = Integer.parseInt(((TextView) view).getText().toString());
            adapter1.updateSelected(clickedValue);
        });

        grid.setOnItemClickListener((parent, view, position, id) -> {
            GridView grid12 = findViewById(R.id.gridView);
            GridAdapter adapter12 = (GridAdapter) grid12.getAdapter();
            adapter12.setSelected(position);
        });










    }
}