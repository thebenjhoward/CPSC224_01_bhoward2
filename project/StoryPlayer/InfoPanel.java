package StoryPlayer;

import java.awt.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class InfoPanel extends JPanel {
    private JTextArea storyTextArea;

    public InfoPanel() {
        // set up panel layout
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // set up story area
        storyTextArea = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        storyTextArea.setLineWrap(true);
        storyTextArea.setWrapStyleWord(true);
        storyTextArea.setEditable(false);
        JScrollPane storyScrollPane = new JScrollPane(storyTextArea);
        storyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        storyScrollPane.setPreferredSize(new Dimension(730, 200));
        storyScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // add stuff
        this.add(storyScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setPreferredSize(new Dimension(750, 200));
    }

    public void setText(String text) {
        storyTextArea.setText(text);
        storyTextArea.setEnabled(!(text == null || text.equals("")));
    }
}