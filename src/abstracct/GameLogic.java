package abstracct;

import gui.Environment;

/**
 * Інтерфейс GameLogic
 */
public interface GameLogic {

    /**
     * Функція самовідкриття для комірки
     * взривається у випадку, якщо користувач відкрив комірку навколо якої нема бомб
     * @param x позиція
     * @param y позиція
     */
    void selfOpen(int x, int y);

    /**
     * Підготовка логіки для работи, заповнює cells і env
     * @param e екземпляр для зберігання змінних про стан гри
     * @param cells масив комірок
     */
    void loadBoard(Environment e, Cell[][] cells);

    /**
     * Провіряє чи повинні ми взірватись на комірці
     * @param x позиція комірки
     * @param y позиція комірки
     * @return true - взірвалась и false - ні
     */
    boolean shouldBang(int x, int y);

    /**
     * Провіряє умову успішного вирішення гри
     * @return true - фініш false - нет
     */
    boolean finish();

    /**
     * Повертає ознаку фіналу гри
     * @return true - фінал, false - ні
     */
    boolean finalized();

    /**
     * Помічає комірку як бомбу або відкриває її.
     * @param x позиция комірки
     * @param y позиция комірки
     * @param bomb ознака бомби
     */
    void suggest(int x, int y, boolean bomb);
}
