import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.ImageIcon;


public class Hangman
{
    public static void main(String args[])
    {
        StartGame();
    }

    public static void StartGame()
    {
        switch(showMenu())
        {
            case 0:
            RunGame(getRandomWord());
            break;

            case 1:
            RunGame(enterWord());
            break;

            case 2:
            break;
        }

    }

    public static void RunGame(String word)
    {
        char[] guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '-');
        addSpaces(guessedWord, word);

        Boolean isGuessed = false;
        int strikes = 0;

        while(strikes < 6 && !isGuessed)
        {
            showProgress(guessedWord, strikes);
            if(!guessLetter(guessedWord, enterLetter(guessedWord), word))
                strikes++;

            isGuessed = (new String(guessedWord)).equals(word);
        }

        if(isGuessed)
        {
            showProgress(guessedWord, 7);
        }
        else
        {
            showProgress(guessedWord, 6);
        }

        StartGame();
    }

    public static int showMenu()
    {
        String strOption = JOptionPane.showInputDialog("Enter 1 to chose a random word\nEnter 2 to chose a word from the user\nEnter 3 to exit game");
        int option = Integer.parseInt(strOption) - 1;
        return option;
    }

    public static String enterWord()
    {
        return JOptionPane.showInputDialog("Enter your desired word").toLowerCase();
    }

    public static String getRandomWord()
    {
        String[] wordList = { "antidisestablishmentarianism", "no", "bubbles", 
        "sunshine", "help", "happiness", "i am being held against my will",
        "supercalifragilisticexpialidocious", "fear", "anger", "hate", "suffering",
        "pneumonoultramicroscopicsilicovolcanoconiosis", "the quick brown fox jumped "
        + "over the lazy black dog" };

        Random rand = new Random();
        return wordList[rand.nextInt(wordList.length)];
    }

    public static char enterLetter(char[] guessedWord)
    {
        String input = JOptionPane.showInputDialog(null, new String(guessedWord) + "\nEnter a letter to guess").toLowerCase();
        if(input.length() != 1 || !Character.isLetter(input.charAt(0)))
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid letter");
            return enterLetter(guessedWord);
        }
        else
        {
            return input.charAt(0);
        }
        
    }

    public static Boolean guessLetter(char[] guessWord, char guessLetter, String word)
    {
        Boolean success = false;
        Boolean alreadyEntered = false;
        for(int i = 0; i < word.length(); i++)
        {
            if(guessWord[i] == '-' && word.charAt(i) == guessLetter)
            {
                success = true;
                guessWord[i] = guessLetter;
            }
            else if(guessWord[i] == guessLetter)
            {
                alreadyEntered = true;
            }
        }

        if(success)
        {
            JOptionPane.showMessageDialog(null, "You guessed a letter!");            
        }
        else if(alreadyEntered)
        {
            JOptionPane.showMessageDialog(null, "You already guessed that letter!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry, that is incorrect.");
        }
        return success || alreadyEntered;
    }

    public static void showProgress(char[] guessWord, int strikes)
    {
        int numGuesses = 6 - strikes;


        if(strikes == 6) {
            JOptionPane.showMessageDialog(null, new String(guessWord) + "\nYou FOOL! YOU HAVE KILLED HIM!\nHE HAD A FAMILY, HOPES, DREAMS.\nALL FOR NAUGHT",
            "Game Over", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Integer.toString(strikes) + ".png"));
        } else if(strikes == 7) {
            JOptionPane.showMessageDialog(null, new String(guessWord) + "\nConglomeration! You win\nYou have saved sticcman",
            "Game Over", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Integer.toString(strikes) + ".png"));
        } else if(strikes != 1) {
            JOptionPane.showMessageDialog(null, new String(guessWord) + "\nYou have " + numGuesses + " guesses left.",
            "Status", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Integer.toString(strikes) + ".png"));
        } else {
            JOptionPane.showMessageDialog(null, new String(guessWord) + "\nYou have " + numGuesses + " guess left.",
            "Status", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Integer.toString(strikes) + ".png"));
        } 
    }

    public static void addSpaces(char[] guessWord, String word)
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == ' ')
            {
                guessWord[i] = ' ';
            }
        }
    }

}
