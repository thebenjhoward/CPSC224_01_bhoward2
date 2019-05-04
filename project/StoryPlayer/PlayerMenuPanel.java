package StoryPlayer;

import StoryData.StoryNode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerMenuPanel extends JPanel {
  private JFileChooser fileChooser;
  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenuItem open, exit;
}

  public PlayerMenuPanel() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));
    int result = fileChooser.showOpenDialog(this.getRootPane());
    this.setLayout(new GridLayout(1, 1));

    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    open = new JMenuItem("Open");
    exit = new JMenuItem("Exit");

    open.addActionListener(this);
    exit.addActionListener(this);

    fileMenu.add(open);
    fileMenu.addSeparator();
    fileMenu.add(exit);

    menuBar.add(fileMenu);
    this.add(menuBar);

  }
}




  /**
   * Sets the Global Event Listener. This listener will relay events to the
   * {@code StoryDesigner} panel
   *
   * @param l The listener to be added
   */
  public void setGlobalEventListener(ActionListener l) {
      globalEventListener = l;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == open) {

    } else if (e.getSource() == exit) {

    }
  }
