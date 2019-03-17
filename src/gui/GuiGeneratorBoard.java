package gui;

import java.util.Random;

import abstracct.Cell;
import abstracct.GeneratorBoard;

/**
 * 
 * @author ����
 *
 */
public class GuiGeneratorBoard implements GeneratorBoard{

    /** ����� ���� �� ��� */
    private int numBombs;

    /** ����� ����� ������ */
    private Cell[][] cells;

    @Override
    public int getNumBombs() {
        return numBombs;
    }

    /**
     * ������ ����� ������ ��� ���� ���
     * �������� ��� ��� ������� ����
     * ������� ������� ���������� around
     * @return ����� �������
     */

    /**
     *
     * @param resX ������� ������� �� ��
     * @param resY ������� ������� �� ��
     * @param numBombs ����� ���� �� ���
     * @return
     */
    @Override
    public Cell[][] generate(int resX, int resY, int numBombs) {

        this.numBombs = numBombs; //������ ����� ����
        this.cells = new Cell[resX][resY]; //��������� ����� ������

        boolean[][] bombs = new boolean[resX][resY]; //����� ����������� ����

        //���������� ����� �� ���� � ����������� �������
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

        //� ��������� � ������������� ���� ��������� ����� ������
        for (int x = 0; x != cells.length; x++){
            for (int y = 0; y != cells[0].length; y++){
                cells[x][y] = new GuiCell(bombs[x][y]);
            }
        }

        this.setCellsAround(); //������������ ���������� around ��� ������

        return this.cells;
    }

    /**
     * �������� ��� ������� Cell[][] ���������� around
     */
    private void setCellsAround(){
        for (int x = 0; x != cells.length; x++){
            for (int y = 0; y != cells[0].length; y++){
                cells[x][y].setAround(countCellAround(x, y));
            }
        }
    }

    /**
     * �������� ��� ������ ����� ���� ������� �� �� ���
     * @param x ����������
     * @param y ����������
     * @return ����� ���� ������� ������
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
