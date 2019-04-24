package StoryDesigner;

import java.awt.FlowLayout;
import javax.swing.*;
import StoryData.StoryNode;

public class TestFile extends JFrame {
    public static void main(String args[]) {
        TestFile test = new TestFile();
        StoryNode root = new StoryNode("root", "storyTextRoot", null, null);
        StoryNode child1 = new StoryNode("child1", "storyTextChild1", null, root);
        StoryNode child2 = new StoryNode("child2", "storyTextChild2", null, child1);
        StoryNode child3 = new StoryNode("child3", "storyTextChild3", null, child2);
        StoryNode child4 = new StoryNode("child4", "storyTextChild4", null, child3);
        StoryNode child5 = new StoryNode("child5", "storyTextChild5", null, child4);
        StoryNode child6 = new StoryNode("child6", "storyTextChild6", null, child5);
        StoryNode child7 = new StoryNode("child7", "storyTextChild7", null, child6);

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new FlowLayout(FlowLayout.LEFT));

        StoryTreePanel storyPanel = new StoryTreePanel(root);
        JScrollPane scrollPane = new JScrollPane(storyPanel);
                
        mainPane.add(scrollPane);
        NodeEditPanel nodePanel = new NodeEditPanel();
        mainPane.add(nodePanel);

        storyPanel.addTreeListener(new StorySelectionListener(storyPanel, nodePanel));

        test.add(mainPane);

        //test.setSize(500, 500);
        
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.pack();
        test.setVisible(true);

    }
}