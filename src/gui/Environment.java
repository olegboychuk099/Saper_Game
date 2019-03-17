package gui;

/**
 * Клас для зберігання інформації про хід гри
 */
public class Environment {
    /** Ознака виграної гри */
    private boolean finish;

    /** Ознака програної гри */
    private boolean gameOver;

    /** Число бомб на полі */
    private int numBombs;

    /**
     * Конструктор
     * @param numBombs число бомб на полі
     */
    public Environment(int numBombs) {
        this.numBombs = numBombs;
        this.finish = false;
        this.gameOver = false;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
