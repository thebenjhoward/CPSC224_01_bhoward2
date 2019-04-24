package StoryPlayer;

import StoryData.StoryNode;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StoryPanel extends JPanel {
  private StoryNode currentNode;
  private ChoicesPanel choices;
  private InfoPanel info;

  public StoryPanel(){
    initializeGUI();
    setNode(null);
    
  }

  public StoryPanel(StoryNode rootNode){
      initializeGUI();
      setNode(rootNode);
  }

  /*---------------------------------------------------------
  //////////////////// HELPER FUNCTIONS /////////////////////
  -----------------------------------------------------------*/

  // uses set methods to update GUI
  public void setNode(StoryNode node){
    currentNode = node;
  }

  // add components
  public void initializeGUI(){

  }

}
