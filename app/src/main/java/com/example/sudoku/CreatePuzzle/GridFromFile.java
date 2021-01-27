package com.example.sudoku.CreatePuzzle;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.sudoku.SudokuLogic.Square;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GridFromFile {



    public static ArrayList<ArrayList<Integer>> readBoard(String fileName) throws FileNotFoundException {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        // Get file passed
        String path = System.getProperty("user.dir") + "\\app\\src\\main\\java\\com\\example\\sudoku\\CreatePuzzle\\boards\\";
        File file = new File(path + fileName);
        Scanner sc = new Scanner(file);

        // Read in each line
        while (sc.hasNextLine()){
            // Start new ArrayList
            ArrayList<Integer> row = new ArrayList<>();
            String line = sc.nextLine();
            String[] splitLine = line.split(" ");
            for (String s : splitLine) {
                row.add(Integer.valueOf(s));
            }
            board.add(row);
        }
        return board;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Integer>> test = GridFromFile.readBoard("col9board1.txt");
        for (ArrayList<Integer> row: test){
            System.out.println(row);
        }
    }
}



