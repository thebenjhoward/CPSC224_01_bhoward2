package StoryPlayer;



import javax.swing.*;

@SuppressWarnings("serial")
public class TestInfo extends JFrame {
    public static void main(String args[]) {
        TestInfo test = new TestInfo();
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        //test.setSize(750, 200);
        rootPanel.add(new InfoPanel());
        rootPanel.add(new ChoicesPanel());
        test.add(rootPanel);

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.pack();

        test.setVisible(true);
    }
} 