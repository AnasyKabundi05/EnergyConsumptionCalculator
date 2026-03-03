import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EnergyConsumptionCalculator {
    private JPanel rootPanel;
    private JPanel inputPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton calculateButton;
    private JButton resetButton;
    private JPanel energyPanel;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JPanel costPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("EnergyConsumptionCalculator");
        frame.setContentPane(new EnergyConsumptionCalculator().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public EnergyConsumptionCalculator() {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");

            }
        });


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    double hrs = Double.parseDouble(textField2.getText());
                    double powerConsumption = Double.parseDouble(textField1.getText());

                    if(comboBox1.getSelectedIndex() == 0){
                        textField1.setText("800");
                    } else if (comboBox1.getSelectedIndex() == 1) {
                        textField1.setText("50");
                    }else if (comboBox1.getSelectedIndex() == 2){
                        textField1.setText("2000");
                    }

                    double powerDay;
                    double powerMonth;
                    double powerYear;

                    powerDay = (powerConsumption * hrs) / 1000;

                    powerMonth = ((powerConsumption * hrs) / 1000) * 30;

                    powerYear = ((powerConsumption * hrs) / 1000) * 365;

                    textField3.setText(String.valueOf(powerDay));
                    textField4.setText(String.valueOf(powerMonth));
                    textField5.setText(String.valueOf(powerYear));

                    double UNIT_RATE = 26.41;

                    double dayRate;
                    double monthRate;
                    double yearRate;
                    DecimalFormat df = new DecimalFormat("##.00");

                    dayRate = powerDay * UNIT_RATE;
                    monthRate = powerMonth * UNIT_RATE;
                    yearRate = powerYear * UNIT_RATE;

                    textField6.setText(String.valueOf(df.format(dayRate)));
                    textField7.setText(String.valueOf(df.format(monthRate)));
                    textField8.setText(String.valueOf(df.format(monthRate)));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(rootPanel,"Input must be numeric","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(comboBox1.getSelectedIndex() == 0){
                    textField1.setText("800");
                } else if (comboBox1.getSelectedIndex() == 1) {
                    textField1.setText("50");
                }else if (comboBox1.getSelectedIndex() == 2){
                    textField1.setText("2000");
                }


            }
        });
    }
}
