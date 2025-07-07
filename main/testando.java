package main;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class testando extends JFrame
{
    Action enterAction;
    JLabel label;

    public testando()
    {
        this.setTitle("GameEngine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(null);
        this.setVisible(true);
        
        enterAction = new EnterAction();
        
        label = new JLabel("lks");
        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "enterAction");
        label.getActionMap().put("enterAction", enterAction);

        this.add(label);

    }

    public class EnterAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("@@@@@z\n");
        }
        
    }  
    
}  // testando
