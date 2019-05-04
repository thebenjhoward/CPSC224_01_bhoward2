
default: story-player

all: story-player story-designer

story-player:
	javac StoryPlayer/GameGUI.java
	jar cvmf StoryPlayer.MF StoryPlayer.jar StoryPlayer/*.class StoryData/*.class
	$(RM) StoryPlayer/*.class StoryData/*.class

story-designer:
	javac StoryDesigner/StoryDesigner.java
	jar cvmf StoryDesigner.MF StoryDesigner.jar StoryDesigner/*.class StoryData/*.class
	$(RM) StoryDesigner/*.class StoryData/*.class

clean:
	$(RM) StoryDesigner/*.class StoryData/*.class StoryPlayer/*.class *.jar