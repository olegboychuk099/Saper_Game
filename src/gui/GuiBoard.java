package gui;

import javax.swing.*;

import abstracct.Board;
import abstracct.Cell;

import java.awt.*;

/**
 * Реалізація гральної дошки
 */
public class GuiBoard extends JPanel implements Board {


    /** Обєкт для збереження інформації про хід гри */
    private Environment env;

    /** Масив комірок */
    public Cell<Graphics>[][] cells;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.cells != null){
            for (int x = 0; x != this.cells.length; x++){
                for (int y = 0; y != cells[0].length; y++){
                    g.drawImage(this.getCellImage(x, y), x*GuiCell.PADDING, y*GuiCell.PADDING, this);
                }
            }
        }
    }

    /**
     * Повертає потрібну картинку для комірки в залежності від ситуації гри
     * @param x координата
     * @param y координата
     * @return картинка для комірки
     */
    private Image getCellImage(int x, int y){
        Image img = cells[x][y].getImg();
        if (env.isGameOver()) {
            img = cells[x][y].getGameOverImg();
        } else if (env.isFinish()) {
            img = cells[x][y].getFinishImg();
        }
        return img;
    }

    /**
     * Ініціалізує Board параметрами і відмальовує
     * @param e екземпляр для збереження змінних про стан гри
     * @param cells масив комірок
     */
    @Override
    public void drawBoard(Environment e, Cell[][] cells) {
        this.env = e;
        this.cells = cells;
        this.repaint();
    }

    /**
     * Отримання номера клітки за координатою екрана
     * @param x позиція
     * @return номер елемента
     */
    @Override
    public int getCellOnX(int x) {
        return (int) x/GuiCell.PADDING;
    }

    /**
     * Отримання номера клітки за координатою екрана
     * @param y позиція
     * @return номер елемента
     */
    @Override
    public int getCellOnY(int y) {
        return (int) y/GuiCell.PADDING;
    }

}
