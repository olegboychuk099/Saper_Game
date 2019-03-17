package abstracct;

import java.awt.*;


/**
 * Інтерфейс комірки
 */
public interface Cell<T> {

    /**
     * 
     * @param around присвоює значення
     */
    void setAround(int around);

    /**
     * 
     * @return значення
     */
    int getAround();

    /**
     * дізнається бомба чи ні
     * @return true - бомба, false - ні
     */
    boolean isBomb();

    /**
     * дізнається чи комірка помічена як бомба
     * @return true якщо так, false - ні
     */
    boolean isSuggestBomb();

    /**
     * дізнається чи комірка відкрита
     * @return true якщо відкрита, false якщо ні
     */
    boolean isOpen();

    /**
     * помічає комірку як бомбу
     */
    void suggestBomb();

    /**
     * відкриває комірку
     */
    void open();

    /**
     * повертає картинки для комірок
     */
    Image getImg();
    Image getEmptyImg();
    Image getGameOverImg();
    Image getFinishImg();

}
