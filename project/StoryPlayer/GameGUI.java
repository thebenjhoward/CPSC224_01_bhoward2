package StoryPlayer;

import javax.swing.*;

public class GameGUI extends JFrame {
    private ChoicesPanel choices;

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
