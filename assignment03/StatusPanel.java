import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class StatusPanel extends JPanel {
    private JLabel status;

    public StatusPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setPreferredSize(new Dimension(500, 16));

        status = new JLabel("Welcome to Tic-Tac-Toe!");
        status.setHorizontalAlignment(SwingConstants.LEFT);
        add(status);
    }

    public void setText(String text) {
        status.setText(text);
    }

    public void reset() {
        status.setText("Welcome to Tic-Tac-Toe");
    }
}
