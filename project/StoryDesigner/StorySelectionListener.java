package StoryDesigner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * An {@code ActionListener} for linking the components of the StoryDesigner
 * together
 */
public class StorySelectionListener implements ActionListener {
    StoryTreePanel storyTreePanel;
    NodeEditPanel nodeEditPanel;
    StoryDesigner designerFrame;

    @Override
    public void actionPerformed(ActionEvent e) {
        nodeEditPanel.changeNode(storyTreePanel.getCurrentNode());
        designerFrame.changesMade();
    }
    
    public StorySelectionListener(StoryTreePanel sTreePanel, NodeEditPanel nEditPanel, StoryDesigner designer) {
        storyTreePanel = sTreePanel;
        nodeEditPanel = nEditPanel;
        designerFrame = designer;

        storyTreePanel.linkEditor(nodeEditPanel);
    }

}