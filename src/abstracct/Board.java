package abstracct;

import gui.Environment;

/**
 * Інтерфейс Board
 */
public interface Board {

    /**
     * Ініціалізує Board параметрами і відмальовує
     * @param e екземпляр для зберігання змінних про стан гри
     * @param cells масив комірок
     */
    void drawBoard(Environment e, Cell[][] cells);

    /**
     * Отримання номера клітки по координаті екрана
     * @param x позиція
     * @return номер елемента
     */
    int getCellOnX(int x);

    /**
     * Отримання номера клітки по координаті екрана
     * @param y позиція
     * @return номер елемента
     */
    int getCellOnY(int y);
}
