package StoryData;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@XmlRootElement(name = "StoryNode")
public class StoryNode {

    @XmlElement(name = "OptionText")
    private String optionText;

    @XmlElement(name = "StoryText")
    private String storyText;

    @XmlElement(name = "StoryImage")
    private Image storyImage;

    private StoryNode parent;

    @XmlElement(name = "Child")
    private StoryNode[] children;

    /**
     * Parameterized constructor for the StoryNode
     * 
     * @param optionText The text to be displayed when the node's parent is active
     * @param storyText  The text to be displayed when the node is active
     * @param storyImage The image to be displayed when the node is active
     * @param parent     The parent of the node. Set to null if creating a root
     */
    public StoryNode(String optionText, String storyText, Image storyImage, StoryNode parent) {
        this.optionText = optionText;
        this.storyText = storyText;
        this.storyImage = storyImage;
        this.parent = parent;

        this.children = new StoryNode[] { null, null, null, null };

        if (this.parent != null) {
            this.parent.addChild(this);
        }
    }

    /**
     * Default constructor. Sets children to be an array of null
     */
    public StoryNode() {
        this.children = new StoryNode[] { null, null, null, null };
    }

    /**
     * Reads an xml and deserializes a StoryNode tree
     * 
     * @param path the path to the xml to be read
     * @return the root node of the tree
     */
    public static StoryNode readXml(String path) {
        StoryNode returnNode = null;
        try {
            File inFile = new File(path);
            FileReader reader = new FileReader(inFile);
            JAXBContext context = JAXBContext.newInstance(StoryNode.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            returnNode = (StoryNode) unmarshaller.unmarshal(reader);
        } catch (IOException e) {

        } catch (JAXBException e2) {

        }
        return returnNode;
    }

    /**
     * gets whether the parent is the root of the node tree
     * 
     * @return true if it is the parent, false otherwise
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * Gets the text to be displayed as the button option when the node's parent is
     * active
     * 
     * @return the option text
     */
    public String getOptionText() {
        return optionText;
    }

    /**
     * sets the text to be displayed as the button option when the node's parent is
     * active
     * 
     * @param optionText the option text to be displayed
     */
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    /**
     * Gets the story text, which is displayed in the story-text section when the
     * node is active
     * 
     * @return string of the story text
     */
    public String getStoryText() {
        return storyText;
    }

    /**
     * Sets the text to be displayed in the story-text section when the node is
     * active
     * 
     * @param storyText the story text to be stored
     */
    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    /**
     * Gets the image associated with the given node
     * 
     * @return an Image object associated with the node
     */
    public Image getStoryImage() {
        return storyImage;
    }

    /**
     * Sets the image associated with the given node
     * 
     * @param storyImage The image to be added to the node
     */
    public void setStoryImage(Image storyImage) {
        this.storyImage = storyImage;
    }

    /**
     * Gets the parent of the given node
     * 
     * @return the parent of the node
     */
    public StoryNode getParentNode() {
        return parent;
    }

    /**
     * Gets the node stored at the given 0-based index
     * 
     * @param index should be an integer between 0 and 3.
     * @return Returns the node at index if it exists. Otherwise returns null
     */
    public StoryNode getChildNode(int index) {
        if (index >= 0 && index <= 3) {
            return children[index];
        } else {
            return null;
        }
    }

    /**
     * Adds a child to the node, provided no more than 4 children currently exist.
     * 
     * @param childNode the child to be added to the node
     */
    private void addChild(StoryNode childNode) {
        for (int i = 0; i < 4; i++) {
            if (children[i] == null) {
                children[i] = childNode;
                return;
            }
        }
    }

    /**
     * Updates the parent relationships of all the nodes. To be used after loading
     * from xml
     */
    public void updateParents() {
        for (int i = 0; i < 4; i++) {
            if (children[i] != null) {
                children[i].parent = this;
                children[i].updateParents();
            }
        }
    }

    /**
     * Serializes the node tree to xml and writes to the given path
     * 
     * @param path the file to write to
     */
    public void writeXml(String path) {
        File outFile = new File(path);
        try {
            FileWriter writer = new FileWriter(outFile);
            JAXBContext context = JAXBContext.newInstance(StoryNode.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(this, writer);

        } catch (IOException e) {

        } catch (JAXBException e2) {

        }

    }

    /**
     * Gets the number of children the node has
     * 
     * @return an integer between 1 and 4
     */
    public int getChildCount() {
        for (int i = 0; i < 4; i++) {
            if (children[i] == null) {
                return i;
            }
        }
        return 4;
    }

    public void removeFromParent() {
        boolean foundNode = false;
        for(int i = 0; i < parent.getChildCount(); i++) {
            if(parent.children[i] == this) {
                parent.children[i] = null;
                foundNode = true;
            } else if(foundNode) {
                parent.children[i - 1] = parent.children[i];
                parent.children[i] = null;
            }
        }
    }

    @Override
    public String toString() {
        if (optionText.length() < 10) {
            return optionText;
        } else {
            return String.join("", optionText.substring(0, 7), "...");
        }
    }
}