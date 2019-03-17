package Main;

import gui.Environment;
import gui.GuiAction;
import gui.GuiBoard;
import gui.GuiCell;
import gui.GuiGeneratorBoard;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import logics.Easy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Олег
 */

public class GameMain1 extends javax.swing.JFrame {
public GuiBoard  board      = new GuiBoard();
public JPanel    otherPanel = new JPanel( new BorderLayout() ); 
public GuiAction action     = new GuiAction(
                        new GuiGeneratorBoard(),
                        board,
                        new Easy()
                );

public int x =GuiAction.RESOLUTION_X*GuiCell.PADDING, y =GuiAction.RESOLUTION_Y*GuiCell.PADDING;

public void muss(int q,int w){
         x =GuiAction.RESOLUTION_X*GuiCell.PADDING;
         y =GuiAction.RESOLUTION_Y*GuiCell.PADDING;
         refresh(q,w,x,y);
}
public void setX(int X){
    x=X;
}
public void setY(int Y){
    y=Y;
}
    /**
     * Creates new form GameMain
     */
     public void refresh(int xz, int yz,int xx, int yy) {
			this.remove(otherPanel);
			otherPanel.removeAll();
			board.revalidate();
			board.repaint();
			jButton2.addActionListener(action);
			otherPanel.revalidate();
			otherPanel.repaint();
			otherPanel.add(board, BorderLayout.CENTER);
			this.add(otherPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(xz, yz, xx, yy));
			this.revalidate();
			this.repaint();
			
			}

    public GameMain1() {
        initComponents();
        refresh(338,100,x,y);
    this.setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_Close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, -1, -1));

        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sun.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_Back.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/background_game.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents
int xx,xy;
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        game.setVisible(false);
        this.setLocationRelativeTo(null);
        frame.getFrame().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
       int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged
   
    /**
     * @param args the command line arguments
     */
    static NewJFrame frame =  new NewJFrame();
    public static GameMain1 game = new GameMain1();
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                game.setVisible(true);
            }
        });
    }
    public static GameMain1 getGameMain(){
        return game;
    }
    public GuiAction getAction() {
		return action;
	}
public void lox(Environment e) {
    	if(e.isGameOver()) {
    		new Lose().setVisible(true);
    	}
    }
public void win(Environment e) {
	if(e.isFinish()) {
		new Win().setVisible(true);
	}
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
