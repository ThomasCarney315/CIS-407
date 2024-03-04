import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JPanel panel;
    public Main () {
        super("Layout Manager Diff - Thomas Carney");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);

        panel = new JPanel();
        //Box layout manager set
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField text = new JTextField("Type here", 15);
        JButton button = new JButton("Just Do It!");
        button.addActionListener(this);
        JRadioButton rad = new JRadioButton("There can only be one!");
        JCheckBox check = new JCheckBox("to be, or not to be");
        JLabel label = new JLabel("no need to put a label on it");

        panel.add(text);
        panel.add(button);
        panel.add(rad);
        panel.add(check);
        panel.add(label);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Grid Layout manager set
        panel.setLayout(new GridLayout(3, 2));
        revalidate();
    }
}