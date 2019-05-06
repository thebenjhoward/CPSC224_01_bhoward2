package StoryPlayer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PlayerMenuPanel extends JPanel implements ActionListener {
    private JFileChooser fileChooser;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem open, exit;

    private ActionListener globalEventListener;

    public PlayerMenuPanel() {
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Story XML Files", "story"));

        this.setLayout(new GridLayout(1, 1));

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        open = new JMenuItem("Open");
        exit = new JMenuItem("Exit");

        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));

        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        this.add(menuBar);

    }

    /**
     * Sets the Global Event Listener. This listener will relay events to the
     * {@code StoryDesigner} panel
     *
     * @param l The listener to be added
     */
    public void setGlobalListener(ActionListener l) {
        globalEventListener = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open && globalEventListener != null) {
            int result = fileChooser.showOpenDialog(this.getRootPane());
            if (result == JFileChooser.APPROVE_OPTION) {
                globalEventListener.actionPerformed(
                        new ActionEvent(this, StoryPanel.STORY_OPEN, fileChooser.getSelectedFile().getPath()));
            }

        } else if (e.getSource() == exit && globalEventListener != null) {
            globalEventListener.actionPerformed(new ActionEvent(this, StoryPanel.STORY_EXIT, null));
        }
    }
}