package logics;

import Main.NewJFrame;
import abstracct.Cell;
import abstracct.GameLogic;
import gui.Environment;

/**
 * Клас логіки програми
 */
public class Easy implements GameLogic {

    /** Комірки */
    private Cell[][] cells;

    /** Екземпляр для зберігання змінних про стан гри*/
    private Environment env;

    /**
     * Підготовка логіки для работи, заповнення cells і env
     * @param e екземпляр для зберігання змінних про стан гри
     * @param cells масив комірок
     */
    @Override
    public void loadBoard(Environment e, Cell[][] cells) {
        this.env = e;
        this.cells = cells;
    }

    /**
     * провіряє чи ми повинні вибухнути на комірці
     * вибухаємо у випадку якщо: це бомба і ми її відкрили
     * перед поверненням встановлюємо відповідне значення для властивості GameOver обєкта env
     * @param x позиція комірки
     * @param y позиція комірки
     * @return true - вибухнули, false - ні
     */
    @Override
    public boolean shouldBang(int x, int y) {
        final Cell selected = this.cells[x][y];
        boolean toReturn = false;
        if(selected.isBomb() && selected.isOpen()){
            toReturn = true;
        }
        this.env.setGameOver(toReturn);
        NewJFrame.game.lox(this.env);
        return toReturn;
    }


    /**
     * Провіряє умову успішного завершення гри
     * Гра рахується завершеною у випадку:
     *      - всі невідкриті комірки - бомби (навіть якщо вои не помічені як бомби)
     * Інакше повертаються всі комірки, що означає про незавершену гру
     *      - будь-яка комірка з бомбою не позначена як бомба
     *      - комірка не відкрита і при цьому бомби в ній немає
     *      - комірка позначена як бомба, хоча там її немає
     * Перед поверненням устанавлюємо відповідні значення для властивостей Finish обєкта env
     * @return true якщо виконані умови фініша false - ні
     */
    @Override
    public boolean finish() {
        boolean toReturn = true;
        if(!this.minEnclosedCells()) {
            for (Cell[] row: cells){
                for (Cell cell: row){
                    if (!cell.isSuggestBomb() && cell.isBomb()) toReturn = false;
                    if (!cell.isOpen() && !cell.isBomb()) toReturn = false;
                    if (cell.isSuggestBomb() && !cell.isBomb()) toReturn = false;
                }
            }
        }
        this.env.setFinish(toReturn);
        NewJFrame.game.win(this.env);
        return toReturn;
    }

    /**
     * позначає комірку як бомбу або відкриває її.
     * У випадку якщо відкрита комірка не оточена бомбами,
     * запускається самовідкриття всіх межуючих з нею комірок
     * @param x позиція комірки
     * @param y позиція комірки
     * @param bomb ознака бомби
     */
    @Override
    public void suggest(int x, int y, boolean bomb) {
        if (bomb){
            this.cells[x][y].suggestBomb();
        } else if (cells[x][y].getAround()==0 && !cells[x][y].isSuggestBomb()) {
            this.selfOpen(x, y);
        } else {
            this.cells[x][y].open();
        }
    }

    /**
     * Функція самовідкриття для комірки
     * відкриває себе і всі межуючі комірки
     * викликає саму себе для межуючої комірки якщо біля неї також немає бомб
     * @param x позиція комірки
     * @param y позиція комірки
     */
    @Override
    public void selfOpen(int x, int y){
        this.cells[x][y].open();
        for (int inX = x - 1; inX <= x + 1; inX++) {
            for (int inY = y - 1; inY <= y + 1; inY++) {
                if (
                        inX < 0 || inY < 0 ||
                                inX == x && inY == y ||
                                inX >= cells.length || inY >= cells[0].length
                        ) {
                    continue;
                } else if (cells[inX][inY].getAround() == 0 && !cells[inX][inY].isOpen()) {
                    this.selfOpen(inX, inY);
                } else {
                    cells[inX][inY].open();
                }
            }
        }
    }

    /**
     * Повкртає ознаку фінала гри, базуючсь на даних із обєкта env
     * @return true якщо фінал, false - ні
     */
    @Override
    public boolean finalized(){
        return (env.isFinish() || env.isGameOver());
    }


    /**
     * Провіряє чи дорівнює число НЕвідкритих комірок загальній кількості бомб
     * @return true у випадку якщо дорівнює, false - ні
     */
    private boolean minEnclosedCells() {
        int numEnclosed = 0;
        for (int x = 0; x != cells.length; x++){
            for (int y = 0; y != cells[0].length; y++){
                if(!cells[x][y].isOpen()) numEnclosed++;
            }
        }
        boolean toReturn = false;
        if(numEnclosed == env.getNumBombs()){
            toReturn = true;
            this.selfSuggest();
        }
        return toReturn;
    }

    /**
     * Позначає непомічені комірки з бомбами
     * Використано для наглядності зовнішнього вигляду
     */
    private void selfSuggest(){
        for (Cell[] row: cells){
            for (Cell cell: row){
                if(cell.isBomb() && !cell.isSuggestBomb()){
                    cell.suggestBomb();
                }
            }
        }
    }
}
