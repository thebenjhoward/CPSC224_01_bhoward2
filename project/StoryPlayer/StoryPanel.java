package StoryPlayer;

import StoryData.StoryNode;
import java.awt.event.*;
import javax.swing.*;

public class StoryPanel extends JPanel implements ActionListener {
    private StoryNode currentNode;
    private InfoPanel infoPanel;
    private ChoicesPanel choicesPanel;
    private ControlsPanel controlsPanel;
    private PlayerMenuPanel playerMenuPanel;

    public static final int STORY_OPEN = 0;
    public static final int STORY_BACK = 1;
    public static final int STORY_RESET = 2;
    public static final int STORY_EXIT = 3;

    public StoryPanel() {
        initializeGUI();
        setNode(null);

    }

    public StoryPanel(StoryNode rootNode) {
        initializeGUI();
        setNode(rootNode);
    }

    /*---------------------------------------------------------
    //////////////////// HELPER FUNCTIONS /////////////////////
    -----------------------------------------------------------*/

    // uses set methods to update GUI
    public void setNode(StoryNode node) {
        currentNode = node;
        if (currentNode == null) {
            for (int i = 0; i < 4; i++) {
                choicesPanel.setButtonText(i, "");
                choicesPanel.setButtonEnabled(i, false);
            }
            infoPanel.setText("File > Open to start a story");
            controlsPanel.setBackEnabled(false);
            controlsPanel.setResetEnabled(false);
        } else {
            for (int i = 0; i < 4; i++) {
                if (i < currentNode.getChildCount()) {
                    choicesPanel.setButtonText(i, currentNode.getChildNode(i).getOptionText());
                    choicesPanel.setButtonEnabled(i, true);
                } else {
                    choicesPanel.setButtonText(i, "");
                    choicesPanel.setButtonEnabled(i, false);
                }
            }
            infoPanel.setText(currentNode.getStoryText());
            if (currentNode.isRoot()) {
                controlsPanel.setBackEnabled(false);
                controlsPanel.setResetEnabled(false);
            } else {
                controlsPanel.setBackEnabled(true);
                controlsPanel.setResetEnabled(true);
            }
        }
    }

    // add components
    public void initializeGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        playerMenuPanel = new PlayerMenuPanel();
        infoPanel = new InfoPanel();
        choicesPanel = new ChoicesPanel();
        controlsPanel = new ControlsPanel();

        for (int i = 0; i < 4; i++) {
            choicesPanel.setButtonListener(i, new ButtonListener(i));
        }

        playerMenuPanel.setGlobalListener(this);
        controlsPanel.setGlobalListener(this);

        this.add(playerMenuPanel);
        this.add(infoPanel);
        this.add(choicesPanel);
        this.add(controlsPanel);
    }

    /*---------------------------------------------------------
    //////////////////// LISTENER CLASSES /////////////////////
    -----------------------------------------------------------*/

    private class ButtonListener implements ActionListener {
        int buttonIndex;

        @Override
        public void actionPerformed(ActionEvent e) {
            setNode(currentNode.getChildNode(buttonIndex));
        }

        public ButtonListener(int index) {
            buttonIndex = index;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getID() == StoryPanel.STORY_OPEN) {
            this.setNode(StoryNode.readXml(e.getActionCommand()));
        } else if (e.getID() == StoryPanel.STORY_BACK) {
            this.setNode(currentNode.getParentNode());
        } else if (e.getID() == StoryPanel.STORY_RESET) {
            if (JOptionPane.showConfirmDialog(this.getRootPane(), "Are you sure you want to reset?", "Reset?",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                StoryNode curr = currentNode;
                while (!curr.isRoot()) {
                    curr = curr.getParentNode();
                }
                this.setNode(curr);
            }
        } else if (e.getID() == StoryPanel.STORY_EXIT) {
            if (JOptionPane.showConfirmDialog(this.getRootPane(), "Are you sure you want to exit?", "Exit?",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
