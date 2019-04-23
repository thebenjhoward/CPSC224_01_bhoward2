package StoryDesigner;

import StoryData.StoryNode;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NodeEditPanel extends JPanel {

    private StoryNode currentNode = null;

    private JTextArea optionTextArea;
    private JLabel optionTextLabel;
    private JTextArea storyTextArea;
    private JLabel storyTextLabel;
    private JButton saveButton;
    // add image functionality

    private ActionListener saveListener;

    public NodeEditPanel()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // set up optionText panel
        JPanel optionTextPanel = new JPanel();
        optionTextPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        optionTextPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        optionTextLabel = new JLabel("Option Text: ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        optionTextPanel.add(optionTextLabel, constraints);

        optionTextArea = new JTextArea();
        optionTextArea.setLineWrap(true);
        optionTextArea.setRows(3);

        JScrollPane optionScrollPanel = new JScrollPane(optionTextArea);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 4;
        optionTextPanel.add(optionScrollPanel, constraints);

        this.add(optionTextPanel);

        // set up storyText panel
        JPanel storyTextPanel = new JPanel();
        storyTextPanel.setLayout(new GridBagLayout());
        storyTextPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        storyTextLabel = new JLabel("Story Text: ");
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        storyTextPanel.add(storyTextLabel, constraints);

        storyTextArea = new JTextArea();
        storyTextArea.setLineWrap(true);
        storyTextArea.setRows(6);
        JScrollPane storyScrollPanel = new JScrollPane(storyTextArea);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridheight = 4;
        storyTextPanel.add(storyScrollPanel, constraints);

        this.add(storyTextPanel);

        // set up save button
        saveButton = new JButton("Save Node");
        saveButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(saveButton);

    }

    public void changeNode(StoryNode newNode) {
        saveNode();
        currentNode = newNode;
        if (currentNode != null) {
            optionTextArea.setText(currentNode.getOptionText());
            optionTextArea.setEnabled(!currentNode.isRoot());

            storyTextArea.setText(currentNode.getStoryText());

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