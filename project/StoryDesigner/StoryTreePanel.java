package StoryDesigner;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import StoryData.StoryNode;

public class StoryTreePanel extends JPanel {
    private JTree nodeTree;

    public StoryTreePanel(StoryNode root) {
        loadTree(root);
        this.add(nodeTree);
    }

    public void loadTree(StoryNode root) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root);
        populateTree(rootNode);

        nodeTree = new JTree(rootNode);
    }

    private void populateTree(DefaultMutableTreeNode currentNode) {
        StoryNode currentObject = (StoryNode) currentNode.getUserObject();
        for (int i = 0; i < currentObject.getChildCount(); i++) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(currentObject.getChildNode(i));
            currentNode.add(newNode);
            populateTree(newNode);
        }
    }
}