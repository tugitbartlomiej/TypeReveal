import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {
    private JPanel mainPanel;
    private JButton button1;
    private JTextArea textArea1;

    public GUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("Kliknięto przycisk!\n");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
