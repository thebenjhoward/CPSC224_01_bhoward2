package StoryDesigner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import StoryData.StoryNode;

public class StoryTreePanel extends JPanel {
    private JTree nodeTree;
    private ActionListener listener = null;
    private StoryNode currentNode = null;
    private JScrollPane treeScrollPane;
    private JButton addButton, removeButton;
    private JPanel buttonPanel;

    public StoryNode getCurrentNode() {
        return currentNode;
    }

    public StoryTreePanel(StoryNode root) {
        loadTree(root);
        nodeTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        nodeTree.addTreeSelectionListener(new StoryTreeListener());
        treeScrollPane = new JScrollPane(nodeTree);
        this.setBackground(Color.WHITE);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        addButton = new JButton("Add Node");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNode();
            }
        });
        buttonPanel.add(addButton);

        removeButton = new JButton("Remove Node");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedNode();
            }
        });
        buttonPanel.add(removeButton);

        this.setLayout(new BorderLayout());

        this.add(treeScrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setPreferredSize(new Dimension(700, 600));
    }

    private void loadTree(StoryNode root) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root);
        populateTree(rootNode);

        nodeTree = new JTree(rootNode);
    }

    public void replaceTree(StoryNode root) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root);
        populateTree(rootNode);

        ((DefaultTreeModel) nodeTree.getModel()).setRoot(rootNode);
    }

    private void populateTree(DefaultMutableTreeNode currentNode) {
        StoryNode currentObject = (StoryNode) currentNode.getUserObject();
        for (int i = 0; i < currentObject.getChildCount(); i++) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(currentObject.getChildNode(i));
            currentNode.add(newNode);
            populateTree(newNode);
        }
    }

    public void addTreeListener(ActionListener l) {
        listener = l;
    }

    public void linkEditor(NodeEditPanel nodeEditPanel) {
        nodeEditPanel.addSaveListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nodeTree.updateUI();
            }
        });
    }

    public void addNode() {
        if (currentNode != null && currentNode.getChildCount() <= 3) {
            StoryNode newNode = new StoryNode("empty node", "", null, currentNode);
            DefaultMutableTreeNode currTreeNode = (DefaultMutableTreeNode) nodeTree.getLastSelectedPathComponent();
            DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode(newNode);
            currTreeNode.add(newTreeNode);
            nodeTree.expandPath(new TreePath(currTreeNode.getPath()));
            nodeTree.setLeadSelectionPath(new TreePath(newTreeNode.getPath()));
            nodeTree.updateUI();
        }
    }

    public void removeSelectedNode() {
        if(nodeTree.getLastSelectedPathComponent() != nodeTree.getModel().getRoot())
        {
            int result = JOptionPane.showConfirmDialog(this.getRootPane(), "Are you sure you want to remove this node?",
                    "Remove Node?", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                DefaultMutableTreeNode deleteNode = (DefaultMutableTreeNode) nodeTree.getLastSelectedPathComponent();
                if (deleteNode != null && deleteNode.getParent() != null) {
                    currentNode.removeFromParent();
                    currentNode = null;
                    DefaultTreeModel model = (DefaultTreeModel) nodeTree.getModel();
                    model.removeNodeFromParent(deleteNode);
                }
            }
        }
    }

    private class StoryTreeListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) nodeTree.getLastSelectedPathComponent();
            if (treeNode == null) {
                currentNode = null;
            } else {
                currentNode = (StoryNode) treeNode.getUserObject();
            }

            if (listener != null) {
                listener.actionPerformed(null);
            }
        }

    }
}