
default: storyplayer

all: storyplayer storydesigner

storyplayer:
	javac StoryPlayer/GameGUI.java
	jar cvfm StoryPlayer.jar StoryPlayer.manifest StoryPlayer/*.class StoryData/*.class
	$(RM) StoryPlayer/*.class StoryData/*.class

storydesigner:
	javac StoryDesigner/TestFile.java
	jar cvfm StoryPlayer.jar StoryPlayer.manifest StoryDesigner/*.class StoryData/*.class
	$(RM) StoryDesigner/*.class StoryData/*.class

clean:
	$(RM) StoryDesigner/*.class StoryData/*.class StoryPlayer/*.class