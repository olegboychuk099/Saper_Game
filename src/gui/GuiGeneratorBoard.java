package gui;

import java.util.Random;

import abstracct.Cell;
import abstracct.GeneratorBoard;

/**
 * 
 * @author Олег
 *
 */
public class GuiGeneratorBoard implements GeneratorBoard{

    /** число бомб на полі */
    private int numBombs;

    /** масив набор комірок */
    private Cell[][] cells;

    @Override
    public int getNumBombs() {
        return numBombs;
    }

    /**
     * Генерує масив комірок для поля гри
     * Заповнює дані про кількість бомб
     * Назначає коміркам властивості around
     * @return масив коміркок
     */

    /**
     *
     * @param resX кількість коміркок по осі
     * @param resY кількість коміркок по осі
     * @param numBombs число бомб на полі
     * @return
     */
    @Override
    public Cell[][] generate(int resX, int resY, int numBombs) {

        this.numBombs = numBombs; //задаємо число бомб
        this.cells = new Cell[resX][resY]; //визначаємо число комірок

        boolean[][] bombs = new boolean[resX][resY]; //масив розподілення бомб

        //розподіляєм бомби по полю у випадковому порядку
        if (numBombs < resX*resY) {
            int numGeneratedBombs = 0;
            Random rand = new Random();
            while (numGeneratedBombs < this.numBombs) {
                int x = rand.nextInt(resX);
                int y = rand.nextInt(resY);
                if (bombs[x][y] != true) {
                    bombs[x][y] = true;
                    numGeneratedBombs++;
                }
            }
        }

        //в залежності з розположенням бомб заповнюєм масив комірок
        for (int x = 0; x != cells.length; x++){
            for (int y = 0; y != cells[0].length; y++){
                cells[x][y] = new GuiCell(bombs[x][y]);
            }
        }

        this.setCellsAround(); //устанавлюємо властивість around для комірок

        return this.cells;
    }

    /**
     * присвоює всім коміркам Cell[][] властивість around
     */
    private void setCellsAround(){
        for (int x = 0; x != cells.length; x++){
            for (int y = 0; y != cells[0].length; y++){
                cells[x][y].setAround(countCellAround(x, y));
            }
        }
    }

    /**
     * підраховує для комірки число бомб навколо неї на полі
     * @param x координата
     * @param y координата
     * @return число бомб навколо комірки
     */
    private int countCellAround(int x, int y){
        int toReturn = 0;
        for (int inX = x-1; inX <= x+1; inX++){
            for(int inY = y-1; inY <= y+1; inY++){
                if(inX < 0 || inY < 0 || inX >= cells.length || inY >= cells[0].length){
                    continue;
                } else if (cells[inX][inY].isBomb()) {
                    toReturn++;}
            }
        }
        return toReturn;
    }

}
