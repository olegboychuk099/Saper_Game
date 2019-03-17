package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import abstracct.Cell;
import abstracct.GameLogic;
import abstracct.GeneratorBoard;
import abstracct.UserAction;

/**
 * ��������� �����䳿 � ������������
 * ���� ��� ����������� � ����� initGame()
 *
 */
public class GuiAction implements UserAction, ActionListener, MouseListener{

    /** ��������� ������ */
    private final GeneratorBoard generator;

    /** ����� */
    private final GuiBoard board;

    /** ����� �������� */
    private final GameLogic logic;

    /** ����� ���� �� ��*/
    public static int RESOLUTION_X = 10;

    /** ����� ���� �� ��*/
    public static int RESOLUTION_Y = 10;

    /** ����� ����*/
    public static int NUM_BOMBS = 5;
        public  static void setRESOLUTION_X(int rESOLUTION_X) {
		RESOLUTION_X = rESOLUTION_X;
	}

	public static void setRESOLUTION_Y(int rESOLUTION_Y) {
		RESOLUTION_Y = rESOLUTION_Y;
	}

	public static void setNUM_BOMBS(int nUM_BOMBS) {
		NUM_BOMBS = nUM_BOMBS;
	}

    /**
     * �����������
     * @param generator ��������� ������
     * @param board �����
     * @param logic ����� ��������
     */
    public GuiAction(GeneratorBoard generator, GuiBoard board, GameLogic logic) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
        this.board.addMouseListener(this);

    }
    

    /**
     * �������� ����� ����.
     * � ������ ��������� ������ '����� ����' � ������ 'Enviroment' �������� ������ � ���� ����.
     * ����� ��� ���������� ���������� � ������� ������� ����� (board) � ������(logic)
     * � ���������� ������ (board) � (logic) �� ��������� ������ ���������
     * ��� ��������� ��������� ������������� �������� ���������� ����� (board) � (logic)
     */
    @Override
    public void initGame() {
        final Cell[][] cells = generator.generate(RESOLUTION_X,RESOLUTION_Y,NUM_BOMBS); 
        final Environment e = new Environment(generator.getNumBombs()); 
        this.board.drawBoard(e, cells);
        this.logic.loadBoard(e, cells); 
    }

    /**
     * ���������� ��� ������� �� ������ � ������������ �������� ������
     * @param x �������
     * @param y �������
     * @param bomb ������� ���� ��� ������������ ������� ������ ��� �����
     */
    @Override
    public void select(int x, int y, boolean bomb) {
        if(!this.logic.finalized()) {
            this.logic.suggest(x, y, bomb); 
            this.logic.shouldBang(x, y);
            this.logic.finish(); 
            this.board.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean bomb = (e.getButton() != 1);
        this.select(board.getCellOnX(e.getX()),board.getCellOnY(e.getY()), bomb);
        board.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
