package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.sudoku.CreatePuzzle.GridFromFile;
import com.example.sudoku.SudokuLogic.Board;
import com.example.sudoku.SudokuLogic.Square;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the board for the game
        int columns = 9;
        int missingSquares = 1;
        Board board = null;
        ArrayList<ArrayList<Square>> initialBoard = null;
        try {
            initialBoard = GridFromFile.getRandomBoard(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        board = new Board(columns, missingSquares, initialBoard);
        // Find the GridView from activity_main.xml and attach the adapter
        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setNumColumns(columns);
        GridAdapter adapter = new GridAdapter(this, board.buildBooleanGrid(), board, 9);
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