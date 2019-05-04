package StoryPlayer;

import StoryData.StoryNode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlsPanel extends JPanel implements ActionListener {
    private JButton backButton, resetButton;
    private ActionListener globalListener;

    public ControlsPanel() {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));

        backButton = new JButton("Back");
        backButton.setToolTipText("Go back to the previous choice");
        backButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setToolTipText("Restart the whole story");
        resetButton.addActionListener(this);

        this.add(backButton);
        this.add(resetButton);

        //this.setPreferredSize(new Dimension(750, 50));

    }

    public void setBackEnabled(boolean b) {
        backButton.setEnabled(b);
    }

    public void setResetEnabled(boolean b) {
        resetButton.setEnabled(b);
    }
    /**
     * @param globalListener the globalListener to set
     */
    public void setGlobalListener(ActionListener globalListener) {
        this.globalListener = globalListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton && globalListener != null) {
            globalListener.actionPerformed(new ActionEvent(this, StoryPanel.STORY_BACK, null));
        } else if(e.getSource() == resetButton && globalListener != null) {
            globalListener.actionPerformed(new ActionEvent(this, StoryPanel.STORY_RESET, null));
        }
    }
}