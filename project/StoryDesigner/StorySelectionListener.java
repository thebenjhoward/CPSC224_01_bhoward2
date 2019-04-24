package StoryDesigner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StorySelectionListener implements ActionListener {
    StoryTreePanel storyTreePanel;
    NodeEditPanel nodeEditPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Node selected");
        nodeEditPanel.changeNode(storyTreePanel.getCurrentNode());
    }

    public StorySelectionListener(StoryTreePanel sTreePanel, NodeEditPanel nEditPanel)
    {
        storyTreePanel = sTreePanel;
        nodeEditPanel = nEditPanel;

        storyTreePanel.linkEditor(nodeEditPanel);
    }
    
}