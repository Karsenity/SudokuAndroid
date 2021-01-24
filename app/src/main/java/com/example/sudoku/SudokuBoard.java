package com.example.sudoku;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SudokuBoard extends View {
    private final int boardColor;
    private int cellSize;
    private final int rowSize;
    private final Paint boardColorPaint = new Paint();


    public SudokuBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.rowSize = 10;

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SudokuBoard, 0, 0);
        try {
            boardColor = a.getInteger(R.styleable.SudokuBoard_boardColor, 0);
        } finally{
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height){
        super.onMeasure(width, height);

        //determine if width or height is smaller to make square fit on screen
        int dimension = Math.min(this.getMeasuredWidth(), this.getMeasuredHeight());
        this.cellSize = dimension / 9;
        // set dimensions of sudoku board
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas){
        // make instance of paint class : it's like a paintbrush / paintbucket for altering board
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(16);
        boardColorPaint.setColor(boardColor);
        boardColorPaint.setAntiAlias(true);

        canvas.drawRect(0, 0, getWidth(), getHeight(), boardColorPaint);
        drawBoard(canvas);
    }


    private void drawBoard(Canvas canvas){

        // Draw Rows
        for (int i=0; i<this.rowSize; i++){
            if (i%3 == 0) drawLine(12);
            else drawLine(4);

            canvas.drawLine(cellSize * i, 0, cellSize*i, getWidth(), boardColorPaint);
        }

        // Draw Columns
        for (int j=0; j<this.rowSize; j++){
            if (j%3 == 0) drawLine(8);
            else drawLine(4);

            canvas.drawLine(0, cellSize * j, getHeight(), cellSize*j, boardColorPaint);
        }
    }


    private void drawLine(int strokeWidth){
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(strokeWidth);
        boardColorPaint.setColor(boardColor);
        boardColorPaint.setAntiAlias(true);
    }


}
