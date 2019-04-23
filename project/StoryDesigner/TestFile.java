package StoryDesigner;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import StoryData.StoryNode;

public class TestFile extends JFrame
{
    public static void main(String args[])
    {
        TestFile test = new TestFile();
        StoryNode root = new StoryNode("root", "storyTextRoot", null, null);
        StoryNode child1 = new StoryNode("child1", "storyTextChild1", null, root);
        StoryNode child2 = new StoryNode("child2", "storyTextChild2", null, root);
        StoryNode child3 = new StoryNode("child3", "storyTextChild3", null, root);
        StoryNode child4 = new StoryNode("child4", "storyTextChild4", null, root);
        StoryNode child5 = new StoryNode("child5", "storyTextChild5", null, child1);

        test.setLayout(new GridLayout(1, 2));
        test.add(new StoryTreePanel(root));
        test.add(new NodeEditPanel());

        test.setSize(500, 500);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        test.setVisible(true);

    }
}