package com.example.sudoku;

import java.util.ArrayList;

public class ExampleGrid {
    public int[][] grid;

    public ArrayList<Integer> returnExampleGrid(){
//       grid = new int[][] {
//                {1,2,3,4},
//                {3,4,2,1},
//                {2,1,4,3},
//                {4,3,1,2}
//        };

        grid = new int[][] {
                {6,7,1,3,9,5,8,4,2},
                {8,9,2,1,7,4,3,5,6},
                {5,3,4,6,2,8,9,7,1},
                {1,8,5,2,4,7,6,3,9},
                {2,4,9,8,3,6,7,1,5},
                {3,6,7,5,1,9,2,8,4},
                {9,2,3,7,5,1,4,9,8},
                {4,1,8,9,6,3,5,2,7},
                {7,5,6,4,8,2,1,9,3}
        };

        ArrayList<Integer>newGrid = new ArrayList<>();

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid.length; j++){
                newGrid.add(grid[i][j]);
            }
        }
        return newGrid;
    }
}
