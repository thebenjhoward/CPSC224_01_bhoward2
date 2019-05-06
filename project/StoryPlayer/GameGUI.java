package StoryPlayer;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameGUI extends JFrame {

    public static void main(String[] args) {
        new GameGUI();
    }
    
    public GameGUI() {
        this.setTitle("JBandersnatch");
        
        StoryPanel storyPanel = new StoryPanel();
        this.add(storyPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
