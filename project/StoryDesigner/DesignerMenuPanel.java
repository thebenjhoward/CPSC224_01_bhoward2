package StoryDesigner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;

public class DesignerMenuPanel extends JPanel implements ActionListener {
    private JFileChooser fileChooser;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newButton, openButton, saveButton, saveAsButton, exitButton;

    private String saveLocation = "";
    private ActionListener globalEventListener;

    public DesignerMenuPanel() {
        globalEventListener = null;
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));
        this.setLayout(new GridLayout(1, 1));

        // menu bar, menu, and items
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        newButton = new JMenuItem("New Story");
        newButton.addActionListener(this);
        newButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newButton.setMnemonic(KeyEvent.VK_N);

        openButton = new JMenuItem("Open Story");
        openButton.addActionListener(this);
        openButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openButton.setMnemonic(KeyEvent.VK_O);

        saveButton = new JMenuItem("Save Story");
        saveButton.addActionListener(this);
        saveButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveButton.setMnemonic(KeyEvent.VK_S);

        saveAsButton = new JMenuItem("Save Story As...");
        saveAsButton.addActionListener(this);
        saveAsButton
                .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        saveAsButton.setMnemonic(KeyEvent.VK_A);

        exitButton = new JMenuItem("Exit.");
        exitButton.addActionListener(this);
        exitButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        exitButton.setMnemonic(KeyEvent.VK_X);

        fileMenu.add(newButton);
        fileMenu.addSeparator();
        fileMenu.add(openButton);
        fileMenu.add(saveButton);
        fileMenu.add(saveAsButton);
        fileMenu.addSeparator();
        fileMenu.add(exitButton);

        menuBar.add(fileMenu);
        this.add(menuBar);
    }

    public void setGlobalEventListener(ActionListener l) {
        globalEventListener = l;
    }

    public String getSaveLocation() {
        return saveLocation;
    }

    public String saveAsOverwriteDialog() {
        while (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to continue? Unsaved changes will be lost");
            if(result == JOptionPane.YES_OPTION) {
                return "";
            }
        }
        return fileChooser.getSelectedFile().getPath();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            globalEventListener.actionPerformed(new ActionEvent(this, StoryDesigner.NEW_STORY, null));
            saveLocation = "";

        } else if (e.getSource() == openButton) {
            int result = fileChooser.showOpenDialog(this.getRootPane());
            if (result == JFileChooser.APPROVE_OPTION && globalEventListener != null) {
                globalEventListener.actionPerformed(
                        new ActionEvent(this, StoryDesigner.OPEN_STORY, fileChooser.getSelectedFile().getPath()));
                saveLocation = fileChooser.getSelectedFile().getPath();
            }

        } else if (e.getSource() == saveButton) {
            if (saveLocation.equals("")) {
                int result = fileChooser.showSaveDialog(this.getRootPane());
                if (result == JFileChooser.APPROVE_OPTION && globalEventListener != null) {
                    globalEventListener.actionPerformed(
                            new ActionEvent(this, StoryDesigner.SAVE_STORY, fileChooser.getSelectedFile().getPath()));
                    saveLocation = fileChooser.getSelectedFile().getPath();
                }
            } else {
                globalEventListener.actionPerformed(new ActionEvent(this, StoryDesigner.SAVE_STORY, saveLocation));
            }

        } else if (e.getSource() == saveAsButton) {
            int result = fileChooser.showSaveDialog(this.getRootPane());
            if (result == JFileChooser.APPROVE_OPTION && globalEventListener != null) {
                globalEventListener.actionPerformed(
                        new ActionEvent(this, StoryDesigner.SAVE_STORY, fileChooser.getSelectedFile().getPath()));
                saveLocation = fileChooser.getSelectedFile().getPath();
            }

        } else if (e.getSource() == exitButton) {
            globalEventListener.actionPerformed(new ActionEvent(this, StoryDesigner.EXIT_EDITOR, null));
        }
    }
}