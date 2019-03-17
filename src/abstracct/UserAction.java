package abstracct;

/**
 * Інтерфейс UserAction використовується для взаємодії з користувачем
 */
public interface UserAction {

    /**
     * починає гру
     */
    void initGame();

    /**
     * вибухає при натисканні на комірку
     * @param x позиція
     * @param y позиція
     * @param bomb ознака того що користувач помітив комірку як бомбу
     */
    void select(int x, int y, boolean bomb);
}
