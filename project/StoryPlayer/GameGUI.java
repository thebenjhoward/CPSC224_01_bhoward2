package StoryPlayer;

import javax.swing.*;
import StoryData.StoryNode;

public class GameGUI extends JFrame {
    private ChoicesPanel choices;

    public static void main(String[] args) {
        new GameGUI();
    }
    
    public GameGUI() {
        // Display a title

        StoryNode root = new StoryNode("root", "storyTextRoot", null);
            StoryNode child1 = new StoryNode("child1", "storyTextChild1", root);
                StoryNode gChild1_1 = new StoryNode("gChild1_1", "storyTextgChild1_1", child1);
                StoryNode gChild1_2 = new StoryNode("gChild1_2", "storyTextgChild1_2", child1);
                StoryNode gChild1_3 = new StoryNode("gChild1_3", "storyTextgChild1_3", child1);
                StoryNode gChild1_4 = new StoryNode("gChild1_4", "storyTextgChild1_4", child1);
            StoryNode child2 = new StoryNode("child2", "storyTextChild2", root);
                StoryNode gChild2_1 = new StoryNode("gChild2_1", "storyTextgChild2_1", child2);
                StoryNode gChild2_2 = new StoryNode("gChild2_2", "storyTextgChild2_2", child2);
                StoryNode gChild2_3 = new StoryNode("gChild2_3", "storyTextgChild2_3", child2);
                StoryNode gChild2_4 = new StoryNode("gChild2_4", "storyTextgChild2_4", child2);
            StoryNode child3 = new StoryNode("child3", "storyTextChild3", root);
                StoryNode gChild3_1 = new StoryNode("gChild3_1", "storyTextgChild3_1", child3);
                StoryNode gChild3_2 = new StoryNode("gChild3_2", "storyTextgChild3_2", child3);
                StoryNode gChild3_3 = new StoryNode("gChild3_3", "storyTextgChild3_3", child3);
                StoryNode gChild3_4 = new StoryNode("gChild3_4", "storyTextgChild3_4", child3);
            StoryNode child4 = new StoryNode("child4", "storyTextChild4", root);
                StoryNode gChild4_1 = new StoryNode("gChild4_1", "storyTextgChild4_1", child4);
                StoryNode gChild4_2 = new StoryNode("gChild4_2", "storyTextgChild4_2", child4);
                StoryNode gChild4_3 = new StoryNode("gChild4_3", "storyTextgChild4_3", child4);
                StoryNode gChild4_4 = new StoryNode("gChild4_4", "storyTextgChild4_4", child4);

        this.setTitle("Bandersnatch");
        
        StoryPanel storyPanel = new StoryPanel(root);
        this.add(storyPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
