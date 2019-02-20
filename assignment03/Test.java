import javax.swing.*;

public class Test extends JFrame
{
    public Test()
    {
        this.setSize(500, 500);
        BoardPanel b = new BoardPanel();
        b.enableButtons();
        this.add(b);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Test();
    }
}