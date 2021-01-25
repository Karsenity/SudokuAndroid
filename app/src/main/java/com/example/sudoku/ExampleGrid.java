package com.example.sudoku;

import java.util.ArrayList;

public class ExampleGrid {
    public static int[][] grid;

    public static int[][] returnExampleGrid(){
//       grid = new int[][] {
//                {1,2,3,4},
//                {3,4,2,1},
//                {2,1,4,3},
//                {4,3,1,2}
//        };

        grid = new int[][] {
                {0,7,1,3,9,5,8,4,2},
                {8,0,2,1,7,4,3,5,6},
                {5,3,0,6,2,8,9,7,1},
                {1,8,5,2,4,7,6,3,9},
                {2,4,9,8,3,6,7,1,5},
                {3,6,7,5,1,9,2,8,4},
                {9,2,3,7,5,1,4,9,8},
                {4,1,8,9,6,3,5,2,7},
                {7,5,6,4,8,2,1,9,3}
        };

        return grid;
    }

    public static ArrayList<Boolean> booleanGrid(int[][] grid){
        ArrayList<Boolean> booleanGrid = new ArrayList<>();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid.length; j++){
                int current = grid[i][j];
                if (current == 0){
                    booleanGrid.add(true);
                } else {
                    booleanGrid.add(false);
                }
            }
        }
        return booleanGrid;
    }
}
