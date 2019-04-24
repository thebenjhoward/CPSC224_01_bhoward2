package StoryPlayer;

import StoryData.StoryNode;
import java.awt.event.*;
import javax.swing.*;

public class StoryPanel extends JPanel {
    private StoryNode currentNode;
    private InfoPanel infoPanel;
    private ChoicesPanel choicesPanel;

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
            infoPanel.setText("");
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
        }
    }

    // add components
    public void initializeGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        infoPanel = new InfoPanel();
        choicesPanel = new ChoicesPanel();

        for(int i = 0; i < 4; i++) {
            choicesPanel.setButtonListener(i, new ButtonListener(i));
        }

        this.add(infoPanel);
        this.add(choicesPanel);
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
}
