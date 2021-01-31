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
                {0,3,5,2,6,9,0,0,1},
                {6,0,2,5,7,1,4,9,3},
                {1,9,7,8,3,4,5,6,2},
                {8,0,6,1,0,5,3,4,7},
                {3,0,4,6,8,0,9,1,5},
                {9,5,1,7,4,3,6,2,8},
                {5,1,9,3,2,6,8,7,4},
                {2,4,8,9,5,0,1,3,6},
                {7,6,3,4,1,8,2,5,9}
        };
//
//        {
//            {0,3,5,2,6,9,0,0,1},
//            {6,0,2,0,7,1,4,9,0},
//            {1,9,0,8,3,4,5,0,2},
//            {8,0,6,1,0,5,3,0,7},
//            {3,0,4,0,8,0,9,1,0},
//            {0,5,1,0,4,3,6,2,8},
//            {5,0,0,0,2,6,0,7,4},
//            {2,4,8,9,5,0,1,3,6},
//            {0,6,0,4,0,8,2,0,9}
//        };

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
