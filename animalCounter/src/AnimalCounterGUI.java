import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalCounterGUI extends JFrame implements ActionListener {
    Sheep sheep = new Sheep();
    Alligator alligator = new Alligator();
    JButton addAlligator;
    JButton addSheep;
    JButton displayCount;
    JButton exit;
    JLabel alligatorCount;
    JLabel sheepCount;
    JButton resetCount;
    ButtonGroup animalRadio;
    JRadioButton sheepRadio;
    JRadioButton alligatorRadio;
    public AnimalCounterGUI() {
        super("Animal Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setLocationRelativeTo(null);

        //panel 1
        JPanel panel1 = new JPanel();
        JLabel welcome = new JLabel("Welcome to the Animal Counter", SwingConstants.CENTER);
        panel1.add(welcome);

        //count panel
        JPanel countPanel = new JPanel();
        BoxLayout box = new BoxLayout(countPanel, BoxLayout.Y_AXIS);
        countPanel.setLayout(box);
        alligatorCount = new JLabel("Alligators:  " + alligator.count);
        sheepCount = new JLabel("Sheep:  " + sheep.count);
        countPanel.add(alligatorCount);
        countPanel.add(sheepCount);

        //button panel
        JPanel buttonPanel = new JPanel();
        addAlligator = new JButton("Add Alligator");
        addAlligator.addActionListener(this);
        addSheep = new JButton("Add Sheep");
        addSheep.addActionListener(this);
        displayCount = new JButton("Display Counts");
        displayCount.addActionListener(this);
        exit = new JButton("Exit");
        exit.addActionListener(this);
        buttonPanel.add(addAlligator);
        buttonPanel.add(addSheep);
        buttonPanel.add(displayCount);
        buttonPanel.add(exit);

        //reset panel
        JPanel resetPanel = new JPanel();
        BoxLayout box2 = new BoxLayout(resetPanel, BoxLayout.Y_AXIS);
        resetPanel.setLayout(box2);
        resetCount = new JButton("Reset Counts");
        resetCount.addActionListener(this);
        animalRadio = new ButtonGroup();
        sheepRadio = new JRadioButton("Sheep");
        alligatorRadio = new JRadioButton("Alligator");
        animalRadio.add(alligatorRadio);
        animalRadio.add(sheepRadio);
        resetPanel.add(alligatorRadio);
        resetPanel.add(sheepRadio);
        resetPanel.add(resetCount);



        add(panel1, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resetPanel, BorderLayout.EAST);
        add(countPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Way she goes...");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addAlligator) {
            alligator.incrementCount(sheep);
            specialCondition();
        }
        else if (source == addSheep) {
            sheep.incrementCount(alligator);
            specialCondition();
        }
        else if (source == displayCount) {
            update();
        }
        else if (source == exit) {
            System.exit(0);
        }
        else if (source == resetCount) {
            if (sheepRadio.isSelected()) {
                sheep.count = 0;
            }
            else if (alligatorRadio.isSelected()) {
                alligator.count = 0;
            }
            specialCondition();
        }
    }
    public void specialCondition() {
        if(alligator.count > sheep.count) {
            JOptionPane.showMessageDialog(this,
                    "Please add more sheep for the hungry alligators");
        } else if (alligator.count < 1) {
            JOptionPane.showMessageDialog(this,
                    "No alligators now so the sheep are safe");
        }
    }
    public void update () {
        alligatorCount.setText( "Alligators:  " + alligator.count);
        sheepCount.setText("Sheep:  " + sheep.count);
    }

    public static void main(String[] args) {

        setLookAndFeel();
        AnimalCounterGUI GUI = new AnimalCounterGUI();
    }
}
