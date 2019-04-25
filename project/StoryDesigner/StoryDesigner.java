package StoryDesigner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import StoryData.StoryNode;

public class StoryDesigner extends JFrame implements ActionListener {
        
    public static void main(String args[]) {
        new StoryDesigner();
    }
    
    /** Warns the user before creating a new story */
    public static final int NEW_STORY = 0;

    /** Warns the user before opening a new story */
    public static final int OPEN_STORY = 1;

    /** Saves the story to the specified file */
    public static final int SAVE_STORY = 2;

    /** Warns the user before exiting */
    public static final int EXIT_EDITOR = 3;

    private DesignerMenuPanel designerMenuPanel;
    private StoryTreePanel storyTreePanel;
    private NodeEditPanel nodeEditPanel;

    private StoryNode rootNode;
    private boolean unsavedChanges = false;

    public StoryDesigner() {
        rootNode = generateEmptyStory();
        
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        storyTreePanel = new StoryTreePanel(rootNode);
        mainPanel.add(storyTreePanel);
        nodeEditPanel = new NodeEditPanel();
        mainPanel.add(nodeEditPanel);

        storyTreePanel.addTreeListener(new StorySelectionListener(storyTreePanel, nodeEditPanel, this));

        designerMenuPanel = new DesignerMenuPanel();
        designerMenuPanel.setGlobalEventListener(this);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(designerMenuPanel, BorderLayout.NORTH);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void changesMade() {
        unsavedChanges = true;
    }

    private StoryNode generateEmptyStory() {
        return new StoryNode("root", "empty", null, null);
    }

    // Menu operations
    private void newStory() {
        if (unsavedChanges) {
            int result = JOptionPane.showConfirmDialog(this, "Would you like to save before creating a new story?",
                    "New Story", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (designerMenuPanel.getSaveLocation().equals("")) {
                    String saveLocation = designerMenuPanel.saveAsOverwriteDialog();
                    if (!saveLocation.equals("")) {
                        saveStory(saveLocation);
                    }
                    rootNode = generateEmptyStory();
                    storyTreePanel.replaceTree(rootNode);
                } else {
                    saveStory(designerMenuPanel.getSaveLocation());
                    rootNode = generateEmptyStory();
                    storyTreePanel.replaceTree(rootNode);
                }
            } else if (result == JOptionPane.NO_OPTION) {
                rootNode = generateEmptyStory();
                storyTreePanel.replaceTree(rootNode);
            }
        } else {
            rootNode = generateEmptyStory();
            storyTreePanel.replaceTree(rootNode);
        }
    }

    private void openStory(String path) {
        if (unsavedChanges) {
            int result = JOptionPane.showConfirmDialog(this, "Would you like to save before loading?", "Load Tree",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (designerMenuPanel.getSaveLocation().equals("")) {
                    String saveLocation = designerMenuPanel.saveAsOverwriteDialog();
                    if (!saveLocation.equals("")) {
                        saveStory(saveLocation);
                    }
                    rootNode = StoryNode.readXml(path);
                    storyTreePanel.replaceTree(rootNode);
                } else {
                    saveStory(designerMenuPanel.getSaveLocation());
                    rootNode = StoryNode.readXml(path);
                    storyTreePanel.replaceTree(rootNode);
                }
            } else if (result == JOptionPane.NO_OPTION) {
                rootNode = StoryNode.readXml(path);
                storyTreePanel.replaceTree(rootNode);
            }
        } else {
            rootNode = StoryNode.readXml(path);
            storyTreePanel.replaceTree(rootNode);
        }
    }

    private void saveStory(String path) {
        rootNode.writeXml(path);
    }

    private void exitEditor() {
        if (unsavedChanges) {
            int result = JOptionPane.showConfirmDialog(this, "Would you like to save before exiting?", "Exit",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (designerMenuPanel.getSaveLocation().equals("")) {
                    String saveLocation = designerMenuPanel.saveAsOverwriteDialog();
                    if (!saveLocation.equals("")) {
                        saveStory(saveLocation);
                    }
                    System.exit(0);
                } else {
                    saveStory(designerMenuPanel.getSaveLocation());
                    System.exit(0);
                }
            } else if (result == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getID() == NEW_STORY) {

        } else if (e.getID() == OPEN_STORY) {

        } else if (e.getID() == SAVE_STORY) {
            saveStory(e.getActionCommand());
        } else if (e.getID() == EXIT_EDITOR) {

        }
    }

}