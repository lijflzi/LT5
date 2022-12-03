import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Main extends Compute{

    public static void main(String[] args) {

        JFrame frame = new JFrame("The Special Age Calculator ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelTitle = new JPanel(new FlowLayout());
        JPanel panelOne = new JPanel(new GridLayout(2, 2, 1, 1));
        JPanel panelTwo = new JPanel(new FlowLayout());
        JButton button = new JButton("Find your age!");

        panelTitle.setBounds(10, 10, 380, 40);
        panelOne.setBounds(10, 60, 380, 80);
        panelTwo.setBounds(10, 200, 380, 40);

        frame.getContentPane().setBackground(Color.WHITE);
        panelTitle.setBackground(Color.WHITE);
        panelOne.setBackground(Color.WHITE);
        panelTwo.setBackground(Color.WHITE);

        JLabel labelOne, labelTwo, labelTitle;

        final JTextField tFieldOne, tFieldTwo;
        tFieldOne = new JTextField(20);
        tFieldOne.setPreferredSize(new Dimension(80,20));
        tFieldTwo = new JTextField(20);
        tFieldTwo.setPreferredSize(new Dimension(80,20));

        labelTitle = new JLabel("Calculate your age!", JLabel.CENTER);
        labelOne = new JLabel(" Please input the year today:");
        labelTwo = new JLabel(" Please input the year you were born:");

        labelTitle.setForeground(Color.WHITE);
        tFieldOne.setBackground(Color.GRAY);
        tFieldTwo.setBackground(Color.GRAY);
        tFieldOne.setForeground(Color.WHITE);
        tFieldTwo.setForeground(Color.WHITE);

        labelTitle.setBounds(10,10,90,20);
        labelOne.setBounds(10,10,90,20);
        tFieldOne.setBounds(5, 5, 100, 100);
        labelTwo.setBounds(10,10,90,20);
        tFieldTwo.setBounds(5, 5, 100, 100);

        panelTitle.add(labelTitle);

        panelOne.add(labelOne);
        panelOne.add(tFieldOne);
        panelOne.add(labelTwo);
        panelOne.add(tFieldTwo);

        button.setBounds(10,10,90,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = computeAge(tFieldOne.getText(),tFieldTwo.getText());
                displayMessage(String.valueOf(result));
            }
        });

        panelTwo.add(button);

        frame.add(panelTitle);
        frame.add(panelOne);
        frame.add(panelTwo);

        frame.setSize(400,300);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

abstract class Methods {
    public void displayMessage(){
        System.out.println("Your age");
    }
}
class Compute extends Methods{
    public static int computeAge(String value1, String value2){
        int val1 = Integer.parseInt(value1);
        int val2 = Integer.parseInt(value2);
        int finalage = val1 - val2;
        return finalage;
    }
    public static void displayMessage(String finalage){
        JOptionPane.showMessageDialog( null, "You are currently: " + finalage, "Your age:" , JOptionPane.INFORMATION_MESSAGE );
    }
}