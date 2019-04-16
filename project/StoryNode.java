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

    public StoryNode() {
        this.children = new StoryNode[] { null, null, null, null };
    }

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

    public boolean isRoot() {
        return parent == null;
    }

    public String getOptionText() {
        return optionText;
    }

    public String getStoryText() {
        return storyText;
    }

    public Image getStoryImage() {
        return storyImage;
    }

    public StoryNode getParentNode() {
        return parent;
    }

    public StoryNode getChildNode(int index) {
        if (index >= 0 && index <= 3) {
            return children[index];
        } else {
            return null;
        }
    }

    private void addChild(StoryNode childNode) {
        for (int i = 0; i < 4; i++) {
            if (children[i] == null) {
                children[i] = childNode;
                return;
            }
        }
    }

    public void updateParents() {
        for (int i = 0; i < 4; i++) {
            if (children[i] != null) {
                children[i].parent = this;
                children[i].updateParents();
            }
        }
    }

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
}