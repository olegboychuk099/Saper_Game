package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logics.Easy;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Клас реалізує запуск Гри
 */
public class Main {
    private static final JPanel controlPanel = new JPanel();
    private static final GuiBoard board = new GuiBoard();

    public static void main(String[] arg){
                final JFrame frame = new JFrame();
                frame.setLayout(new BorderLayout());
                frame.setSize(608,600);
                frame.add(board,BorderLayout.CENTER);
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new BorderLayout());
                final GuiAction action = new GuiAction(
                        new GuiGeneratorBoard(),
                        board,
                        new Easy()
                );
                final JButton generate = new JButton("start");
                generate.addActionListener(action);
                controlPanel.add(generate,SwingConstants.CENTER);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
           
        
    }

   

}
