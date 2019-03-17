package gui;

/**
 * ���� ��� ��������� ���������� ��� ��� ���
 */
public class Environment {
    /** ������ ������� ��� */
    private boolean finish;

    /** ������ �������� ��� */
    private boolean gameOver;

    /** ����� ���� �� ��� */
    private int numBombs;

    /**
     * �����������
     * @param numBombs ����� ���� �� ���
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
