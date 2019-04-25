package StoryDesigner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StorySelectionListener implements ActionListener {
    StoryTreePanel storyTreePanel;
    NodeEditPanel nodeEditPanel;
    StoryDesigner designerFrame;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Node selected");
        nodeEditPanel.changeNode(storyTreePanel.getCurrentNode());
        designerFrame.changesMade();
    }

    public StorySelectionListener(StoryTreePanel sTreePanel, NodeEditPanel nEditPanel, StoryDesigner designer)
    {
        storyTreePanel = sTreePanel;
        nodeEditPanel = nEditPanel;
        designerFrame = designer;

        storyTreePanel.linkEditor(nodeEditPanel);
    }
    
}