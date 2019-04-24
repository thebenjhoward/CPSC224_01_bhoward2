package StoryPlayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class InfoPanel extends JPanel {
    private JLabel storyLabel;
    private JTextArea storyTextArea;
    private JLabel imageLabel;
    private Image tempImage; // remove later

    public InfoPanel() {
        // set up panel layout
        // this.setLayout(new GridBagLayout());
        // GridBagConstraints rootConstraints = new GridBagConstraints();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // set up story label
        // storyLabel = new JLabel(
        //         "<html><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p></html>");
        // storyLabel.setMaximumSize(new Dimension(530, Integer.MAX_VALUE));
        // JScrollPane storyScrollPane = new JScrollPane(storyLabel);
        storyTextArea = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        storyTextArea.setLineWrap(true);
        storyTextArea.setWrapStyleWord(true);
        JScrollPane storyScrollPane = new JScrollPane(storyTextArea);
        storyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        storyScrollPane.setPreferredSize(new Dimension(530, 200));
        storyScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));

        // set up image label
        loadImage();
        imageLabel = new JLabel(new ImageIcon(tempImage));
        imageLabel.setPreferredSize(new Dimension(180, 180));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // add stuff
        // // storyLabel
        // rootConstraints.gridx = 0;
        // rootConstraints.gridy = 0;
        // rootConstraints.gridwidth = 6;
        // rootConstraints.fill = GridBagConstraints.BOTH;
        // rootConstraints.weightx = 1.0;
        // rootConstraints.weighty = 1.0;
        // this.add(storyScrollPane, rootConstraints);

        // // imageLabel
        // rootConstraints.gridx = 6;
        // rootConstraints.gridy = 0;
        // rootConstraints.gridwidth = 4;
        // rootConstraints.fill = GridBagConstraints.BOTH;
        // rootConstraints.weightx = 1.0;
        // rootConstraints.weighty = 1.0;
        // this.add(imageLabel, rootConstraints);

        this.add(storyScrollPane);
        this.add(imageLabel);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    private void loadImage() {
        try {
            tempImage = ImageIO.read(new File("StoryPlayer\\PlaceHolderImage.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void setText(String text) {

    }

    public void setImage(Image image) {

    }
}
