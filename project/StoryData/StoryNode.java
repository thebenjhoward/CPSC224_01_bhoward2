package StoryData;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** A node-based data structure used for the story being edited or played */
@XmlRootElement(name = "StoryNode")
@XmlAccessorType(XmlAccessType.FIELD)
public class StoryNode {

    @XmlElement(name = "OptionText")
    private String optionText;

    @XmlElement(name = "StoryText")
    private String storyText;

    @XmlTransient
    private StoryNode parent;

    @XmlElement(name = "Child")
    private StoryNode[] children;

    /**
     * Parameterized constructor for the StoryNode
     * 
     * @param optionText The text to be displayed when the node's parent is active
     * @param storyText  The text to be displayed when the node is active
     * @param parent     The parent of the node. Set to null if creating a root
     */
    public StoryNode(String optionText, String storyText, StoryNode parent) {
        this.optionText = optionText;
        this.storyText = storyText;
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
            returnNode.updateParents();
            returnNode.updateChildren();
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (JAXBException e2) {
            System.out.println(e2.toString());
        }
        return returnNode;
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
            writer.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (JAXBException e2) {
            System.out.println(e2.toString());
        }

    }

    /**
     * Gets whether the parent is the root of the node tree
     * 
     * @return true if it is the parent, false otherwise
     */
    public boolean isRoot() {
        return parent == null;
    }
    
    
    /**
     * Gets whether the parent is the root of the node tree
     * 
     * @return true if it is the parent, false otherwise
     */
    public boolean isLeaf() {
        return getChildCount() == 0;
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
     * Sets the text to be displayed as the button option when the node's parent is
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
    private void updateParents() {
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                children[i].parent = this;
                children[i].updateParents();
            }
        }
    }

    /**
     * Updates the children arrays to all have a size of 4
     */
    private void updateChildren() {
        if (children.length != 4) {
            StoryNode[] newChildren = new StoryNode[] { null, null, null, null };
            for (int i = 0; i < children.length; i++) {
                children[i].updateChildren();
                newChildren[i] = children[i];

            }
            children = newChildren;
        }
    }

    /**
     * Gets the number of children the node has
     * 
     * @return an integer between 1 and 4
     */
    public int getChildCount() {
        if(this.children.length != 4) {
            updateChildren();
        }
        for (int i = 0; i < 4; i++) {
            if (children[i] == null) {
                return i;
            }
        }
        return 4;
    }

    /**
     * Removes the given node from its parent class and reorders the array properly
     */
    public void removeFromParent() {
        boolean foundNode = false;
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (parent.children[i] == this) {
                parent.children[i] = null;
                foundNode = true;
            } else if (foundNode) {
                parent.children[i - 1] = parent.children[i];
                parent.children[i] = null;
            }
        }
    }

    @Override
    public String toString() {
        if (optionText.length() < 20) {
            return optionText;
        } else {
            return String.join("", optionText.substring(0, 17), "...");
        }
    }
}