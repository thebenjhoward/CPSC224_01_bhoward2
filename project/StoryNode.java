import javax.xml.bind.annotation.*;
import java.awt.Image;

public class StoryNode {
    private String optionText;
    private String storyText;
    private Image storyImage;
    private StoryNode parent;
    private StoryNode[] children;

    public StoryNode(String optionText, String storyText, Image storyImage, StoryNode parent)
    {
        this.optionText = optionText;
        this.storyText = storyText;
        this.storyImage = storyImage;
        this.parent = parent;

        this.children = new StoryNode[] { null, null, null, null };

        if(this.parent != null)
        {
            this.parent.addChild(this);
        }
    }

    public boolean isRoot()
    {
        return parent == null;
    }

    public String getOptionText()
    {
        return optionText;
    }

    public String getStoryText()
    {
        return storyText;
    }

    public Image getStoryImage()
    {
        return storyImage;
    }

    public StoryNode getParentNode()
    {
        return parent;
    }
    
    public StoryNode getChildNode(int index)
    {
        if(index >= 0 && index <= 3)
        {
            return children[index];
        }
        else
        {
            return null;
        }
    }

    private void addChild(StoryNode childNode)
    {
        for(int i = 0; i < 4; i++)
        {
            if(children[i] != null)
                children[i] = childNode;
        }
    }
}