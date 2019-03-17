package gui;

import java.awt.*;

import abstracct.Cell;

/**
 * ��������� ������
 */
public class GuiCell implements Cell<Graphics> {

    /** ����� ������*/
    public static  int PADDING = 41;

    /** ���� �� ���������*/
    public static  String PATH = "/icons/gray/lar/";

    public void setPATH(String pATH) {
		PATH = pATH;
	}
    /** ������ ����� */
    private boolean bomb;

    /** ����� ���� ������� ������*/
    private int around;

    /** ������ ���� �� ������ ������� �� ����� */
    private boolean suggestBomb = false;

    /** ������ ���� �� ������ �������*/
    private boolean open = false;

    /**
     * �����������
     * @param bomb ������ �����
     */
    public GuiCell(boolean bomb) {
        this.bomb = bomb;
    }

    public GuiCell() {
        
    }

    @Override
    public void setAround(int around) {
        this.around = around;
    }

    @Override
    public int getAround() {
        return around;
    }

    @Override
    public boolean isBomb() {
        return this.bomb;
    }

    @Override
    public boolean isSuggestBomb() {
        return this.suggestBomb;
    }

    @Override
    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void suggestBomb() {
        if (!this.open) this.suggestBomb = !this.suggestBomb;
    }

    @Override
    public void open() {
        if (!this.suggestBomb) this.open = true;
    }

    @Override
    public Image getImg(){
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"unverified.png"));
        if(this.suggestBomb){
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"suggestBomb.png"));
        }else if (this.open){
            img = this.getEmptyImg();
        }
        return img;
    }

    @Override
    public Image getEmptyImg() {
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"empty.png"));
        switch (this.around){
            case 0: break;
            case 1: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"1.png")); break;
            case 2: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"2.png")); break;
            case 3: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"3.png")); break;
            case 4: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"4.png")); break;
            case 5: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"5.png")); break;
            case 6: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"6.png")); break;
            case 7: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"7.png")); break;
            case 8: img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"8.png")); break;
        }
        return img;
    }

    @Override
    public Image getGameOverImg() {
        Image img = this.getEmptyImg();
        if (this.isBomb() && this.isOpen()){
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"gameOverBomb.png"));
        } else if(this.isBomb() && this.isSuggestBomb()){
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"suggestBomb.png"));
        } else if(this.isBomb() && !this.isSuggestBomb()){
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"finishBomb.png"));
        } else if(!this.isBomb() && this.isSuggestBomb()){
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"falseSuggestBomb.png"));
        }
        return img;
    }

    @Override
    public Image getFinishImg() {
        Image img = this.getEmptyImg();
        if (this.isBomb() && this.isSuggestBomb()){
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(this.PATH+"suggestBomb.png"));
        }
        return img;
    }
}