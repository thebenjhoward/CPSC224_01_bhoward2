package StoryPlayer;


import java.awt.GridLayout;

import javax.swing.*;

public class TestInfo extends JFrame {
    public static void main(String args[]) {
        TestInfo test = new TestInfo();
        test.setLayout(new GridLayout(1, 1));
        //test.setSize(750, 200);
        test.add(new InfoPanel());

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.pack();
        System.out.print(test.getSize().getWidth());
        System.out.print(" x ");
        System.out.println(test.getSize().getHeight());

        test.setVisible(true);
    }
} 