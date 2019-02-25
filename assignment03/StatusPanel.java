import javax.swing.*;

public class StatusPanel extends JPanel
{
    private JLabel status;

    public StatusPanel()
    {
      status = new JLabel("Press New Game to Begin.");
      this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
      add(greeting);
    }

    public void setText(String text)
    {
      status.setText(text);
    }

    public void reset()
    {
      status.setText("Press New Game to Begin.");
    }
}
