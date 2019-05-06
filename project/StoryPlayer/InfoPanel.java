package StoryPlayer;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;


@SuppressWarnings("serial")
public class InfoPanel extends JPanel {
    private JTextPane storyTextPane;
    private JScrollPane storyScrollPane;

    public InfoPanel() {
        // set up panel layout
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // set up story area
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        storyTextPane = new JTextPane();
        storyTextPane.setEditorKit(htmlEditorKit);
        storyTextPane.setEditable(false);
        storyScrollPane = new JScrollPane(storyTextPane);
        storyScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        storyScrollPane.setPreferredSize(new Dimension(730, 200));
        storyScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // add stuff
        this.add(storyScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setPreferredSize(new Dimension(750, 200));
    }

    public void setText(String text) {
        storyTextPane.setText(text);
        storyTextPane.setEnabled(!(text == null || text.equals("")));
        storyTextPane.setCaretPosition(0);
    }
}