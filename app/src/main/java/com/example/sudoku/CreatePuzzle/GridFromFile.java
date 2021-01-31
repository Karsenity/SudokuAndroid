package com.example.sudoku.CreatePuzzle;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.sudoku.SudokuLogic.Square;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GridFromFile {

    public static ArrayList<ArrayList<Square>> readBoard(InputStream file) {
        ArrayList<ArrayList<Square>> board = new ArrayList<>();
        Scanner sc = new Scanner(file).useDelimiter("\\A");
        // Read in each line
        while (sc.hasNextLine()){
            // Start new ArrayList
            ArrayList<Square> row = new ArrayList<>();
            String line = sc.nextLine();
            String[] splitLine = line.split(" ");
            for (String s : splitLine) {
                Square current = new Square(true, Integer.parseInt(s));
                row.add(current);
            }
            board.add(row);
        }
        return board;
    }

    public static ArrayList<ArrayList<Square>> getRandomBoard(Context context) throws IOException {
        InputStream retval = null;
        // 1.) Get all the filenames in the assets folder
        String[] fileNames = context.getAssets().list("boards");
        // 2.) Pick a random one to use
        Random rand = new Random();
        int randomIndex = rand.nextInt(fileNames.length);
        // 3.) Open the chosen file
        try {
            // TESTED: we have the board at this point
            retval = context.getAssets().open("boards/" + fileNames[randomIndex]);
        } catch (IOException e){
            e.printStackTrace();
        }
        // 4.) Send the InputStream to readBoard() to finish parsing
        return GridFromFile.readBoard(retval);
    }


}



