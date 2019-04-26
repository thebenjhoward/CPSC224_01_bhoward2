package StoryDesigner;

import StoryData.StoryNode;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel used to edit {@code StoryNode} objects and update changes on the tree
 */
public class NodeEditPanel extends JPanel {

    private StoryNode currentNode = null;

    private JTextArea optionTextArea;
    private JLabel optionTextLabel;
    private JTextArea storyTextArea;
    private JLabel storyTextLabel;
    private JButton saveButton;
    // add image functionality

    private ActionListener saveListener;

    /**
     * Default Constructor
     */
    public NodeEditPanel() {
        this.initializeComponents();
        this.setPreferredSize(new Dimension(300, 600));
    }

    /**
     * Initializes all components of the panel
     */
    private void initializeComponents() {
        // Set up main panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // option text label
        optionTextLabel = new JLabel("Option Text: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.BASELINE_LEADING;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(optionTextLabel, constraints);

        // option text area
        optionTextArea = new JTextArea();
        optionTextArea.setLineWrap(true);
        optionTextArea.setWrapStyleWord(true);
        JScrollPane optionScrollPane = new JScrollPane(optionTextArea);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.BASELINE_LEADING;
        constraints.gridwidth = 2;
        constraints.gridheight = 6;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(optionScrollPane, constraints);

        // story text label
        storyTextLabel = new JLabel("Story Text: ");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.BASELINE_LEADING;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(storyTextLabel, constraints);

        // story text area
        storyTextArea = new JTextArea();
        storyTextArea.setLineWrap(true);
        storyTextArea.setWrapStyleWord(true);
        JScrollPane storyScrollPane = new JScrollPane(storyTextArea);
        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.BASELINE_LEADING;
        constraints.gridwidth = 2;
        constraints.gridheight = 6;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(storyScrollPane, constraints);

        // save button
        saveButton = new JButton("Save Node");
        saveButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        saveButton.addActionListener(new SaveListener());
        constraints.gridx = 1;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.BASELINE_LEADING;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(saveButton, constraints);

        this.changeNode(null);
    }
    
    /**
     * Saves, then changes the node being edited
     * 
     * @param newNode the node being changed to
     */
    public void changeNode(StoryNode newNode) {
        saveNode();
        currentNode = newNode;
        if (currentNode != null) {
            optionTextArea.setText(currentNode.getOptionText());
            optionTextArea.setEnabled(!currentNode.isRoot());
            storyTextArea.setText(currentNode.getStoryText());
            storyTextArea.setEnabled(true);
            saveButton.setEnabled(true);

            // add image functionality

        } else {
            optionTextArea.setText("");
            optionTextArea.setEnabled(false);
            storyTextArea.setText("");
            storyTextArea.setEnabled(false);

            saveButton.setEnabled(false);
            // add image functionality
        }
    }

    /**
     * Saves the current node being edited to the tree
     */
    public void saveNode() {
        if (currentNode != null) {
            currentNode.setStoryText(storyTextArea.getText());
            currentNode.setOptionText(optionTextArea.getText());
            // add image functionality
            if (saveListener != null) {
                saveListener.actionPerformed(null);
            }
        }
    }

    /**
     * Use this to set an action that will be performed upon the save button being
     * clicked or the save action being performed
     * 
     * @param listener the listener to be added
     */
    public void addSaveListener(ActionListener listener) {
        saveListener = listener;
    }

    private class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            saveNode();
        }
    }
}