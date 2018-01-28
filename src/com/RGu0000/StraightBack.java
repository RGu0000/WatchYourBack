package com.RGu0000;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


class StraightBack {
    private JButton StartButton;
    private JPanel panel1;
    private JTextArea chooseNotificationTypesAndTextArea;
    private JCheckBox CheckBox2;
    private JCheckBox CheckBox3;
    private JTextArea timersMmSsTextArea;
    private JTextArea minimumTimeTextArea;
    private JTextArea maximumTimeTextArea;
    private JTextArea textArea1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JCheckBox CheckBox1;
    private JSpinner spinner4;
    private JSpinner spinner3;
    static TrayIcon trayIcon = null;
    private ArrayList<JSpinner> JSpinners = new ArrayList<>();
    private ArrayList<JCheckBox> JCheckBoxes = new ArrayList<>();
    private boolean[] checkboxes = new boolean[3];


    void go() {

        JFrame frame = new JFrame("Watch Your Back!");
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        panel1.setPreferredSize(new Dimension(500, 250));
        StartButton = new JButton();
        StartButton.addActionListener(new StartStop());
        StartButton.setFocusPainted(false);
        StartButton.setText("START THE PROGRAM");
        panel1.add(StartButton, BorderLayout.SOUTH);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(panel2, BorderLayout.NORTH);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        chooseNotificationTypesAndTextArea = new JTextArea();
        chooseNotificationTypesAndTextArea.setBackground(new Color(-1513240));
        chooseNotificationTypesAndTextArea.setEditable(false);
        chooseNotificationTypesAndTextArea.setEnabled(true);
        chooseNotificationTypesAndTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        chooseNotificationTypesAndTextArea.setText("Choose notification types and set the timers");
        panel2.add(chooseNotificationTypesAndTextArea);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel1.add(panel3, BorderLayout.CENTER);
        CheckBox2 = new JCheckBox();
        CheckBox2.setFont(new Font("Arial", CheckBox2.getFont().getStyle(), 13));
        CheckBox2.setSelected(true);
        CheckBox2.setText("Tray Notification");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(CheckBox2, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer1, gbc);
        CheckBox3 = new JCheckBox();
        CheckBox3.setFont(new Font("Arial", CheckBox3.getFont().getStyle(), 13));
        CheckBox3.setText("Pop-up");
        CheckBox3.setSelected(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 12;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel3.add(CheckBox3, gbc);
        timersMmSsTextArea = new JTextArea();
        timersMmSsTextArea.setBackground(new Color(-1513240));
        timersMmSsTextArea.setFont(new Font("Arial", Font.BOLD, 15));
        timersMmSsTextArea.setText("Timers [mm:ss]");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 13;
        panel3.add(timersMmSsTextArea, gbc);
        minimumTimeTextArea = new JTextArea();
        minimumTimeTextArea.setBackground(new Color(-1513240));
        minimumTimeTextArea.setFont(new Font("Arial", minimumTimeTextArea.getFont().getStyle(), 14));
        minimumTimeTextArea.setText(" Minimum time: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 14;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(minimumTimeTextArea, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 11;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer8, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer9, gbc);
        final JTextArea textArea2 = new JTextArea();
        textArea2.setBackground(new Color(-1513240));
        textArea2.setFont(new Font("Arial", Font.BOLD, 18));
        textArea2.setText(":");
        gbc = new GridBagConstraints();
        gbc.gridx = 13;
        gbc.gridy = 16;
        panel3.add(textArea2, gbc);
        spinner3 = new JSpinner(new SpinnerNumberModel(10, 0, 19, 1));


        JSpinner.DefaultEditor spinnerEditor3 = new JSpinner.DefaultEditor(spinner3);

        spinnerEditor3.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spinner3.setEditor(spinnerEditor3);
        spinner3.setFont(new Font("Arial", spinner3.getFont().getStyle(), 13));
        spinner3.setPreferredSize(new Dimension(45, 26));
        gbc = new GridBagConstraints();
        gbc.gridx = 12;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spinner3, gbc);
        maximumTimeTextArea = new JTextArea();
        maximumTimeTextArea.setBackground(new Color(-1513240));
        maximumTimeTextArea.setFont(new Font("Arial", maximumTimeTextArea.getFont().getStyle(), 14));
        maximumTimeTextArea.setText(" Maximum time: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 11;
        gbc.gridy = 14;
        gbc.gridwidth = 5;
        panel3.add(maximumTimeTextArea, gbc);
        spinner4 = new JSpinner(new SpinnerNumberModel(0, 0, 60, 5));
        JSpinner.DefaultEditor spinnerEditor4 = new JSpinner.DefaultEditor(spinner4);
        spinnerEditor4.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spinner4.setEditor(spinnerEditor4);

        spinner4.setFont(new Font("Arial", spinner4.getFont().getStyle(), 13));
        spinner4.setPreferredSize(new Dimension(45, 26));
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spinner4, gbc);
        textArea1 = new JTextArea();
        textArea1.setBackground(new Color(-1513240));
        textArea1.setFont(new Font("Arial", Font.BOLD, 18));
        textArea1.setText(":");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 16;
        panel3.add(textArea1, gbc);
        spinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        JSpinner.DefaultEditor spinnerEditor1 = new JSpinner.DefaultEditor(spinner1);
        spinnerEditor1.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spinner1.setEditor(spinnerEditor1);

        spinner1.setFont(new Font("Arial", spinner1.getFont().getStyle(), 13));
        spinner1.setPreferredSize(new Dimension(45, 26));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 16;
        panel3.add(spinner1, gbc);
        spinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 60, 5));
        JSpinner.DefaultEditor spinnerEditor2 = new JSpinner.DefaultEditor(spinner2);
        spinnerEditor2.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spinner2.setEditor(spinnerEditor2);

        spinner2.setFont(new Font("Arial", spinner2.getFont().getStyle(), 13));
        spinner2.setPreferredSize(new Dimension(45, 26));
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 16;
        panel3.add(spinner2, gbc);
        CheckBox1 = new JCheckBox();
        CheckBox1.setFont(new Font("Arial", CheckBox1.getFont().getStyle(), 13));
        CheckBox1.setSelected(true);
        CheckBox1.setText("Sound");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel3.add(CheckBox1, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 15;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer10, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 16;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer11, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 17;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer13, gbc);
        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 17;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer14, gbc);
        final JPanel spacer15 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 18;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer15, gbc);
        final JPanel spacer16 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer16, gbc);
        final JPanel spacer17 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer17, gbc);
        final JPanel spacer18 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer18, gbc);
        final JPanel spacer19 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 14;
        gbc.gridy = 19;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer19, gbc);
        final JPanel spacer20 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 18;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer20, gbc);
        final JPanel spacer21 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer21, gbc);
        final JPanel spacer22 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer22, gbc);
        final JPanel spacer23 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer23, gbc);
        final JPanel spacer24 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer24, gbc);
        final JPanel spacer25 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer25, gbc);
        final JPanel spacer26 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer26, gbc);





        JSpinners.add(spinner1);
        JSpinners.add(spinner2);
        JSpinners.add(spinner3);
        JSpinners.add(spinner4);

        JCheckBoxes.add(CheckBox1);
        JCheckBoxes.add(CheckBox2);
        JCheckBoxes.add(CheckBox3);





        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);



        if(SystemTray.isSupported()) {
            final JWindow frame2 = new JWindow();

            SystemTray tray = SystemTray.getSystemTray();


            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getResource("/tray.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Image image = Toolkit.getDefaultToolkit().getImage("src\\images\\tray.png");
            PopupMenu popup = new PopupMenu();
            MenuItem openItem = new MenuItem("Open main window");
            MenuItem exitItem = new MenuItem("Close app");
            popup.add(openItem);
            popup.addSeparator();
            popup.add(exitItem);

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    frame.setVisible(true);
                    frame.setState(Frame.NORMAL);
                }
            });

            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tray.remove(trayIcon);
                    System.exit(0);
                }
            });

            trayIcon = new TrayIcon(image, "Watch your back!", popup);
            trayIcon.setImageAutoSize(true);

            trayIcon.setPopupMenu(popup);
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        frame2.add(popup);
                        popup.show(frame2,e.getXOnScreen(), e.getYOnScreen());
                    }
                }
            });

            try {
                frame2.setVisible(true);
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
        }
    }


    public class StartStop extends JButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            AlarmTimer alarm = new AlarmTimer();
            checkboxes[0]=CheckBox1.isSelected();
            checkboxes[1]=CheckBox2.isSelected();
            checkboxes[2]=CheckBox3.isSelected();

            if ((Integer) spinner1.getValue() * 60 + (Integer) spinner2.getValue() >= (Integer) spinner3.getValue() * 60 + (Integer) spinner4.getValue()) {
                JOptionPane.showMessageDialog(null, new JLabel("Check timers' settings!",JLabel.CENTER),"Wrong time set", JOptionPane.ERROR_MESSAGE);
            } else {
                if (StartButton.getText().equals("START THE PROGRAM")) {
                    StartButton.setText("PROGRAM IS ALREADY RUNNING  -  PRESS TO STOP");
                    for (JCheckBox c : JCheckBoxes) { c.setEnabled(false);}
                    for (JSpinner c : JSpinners) { c.setEnabled(false);}

                    alarm.setAlarm((Integer) spinner1.getValue(), (Integer) spinner2.getValue(), (Integer) spinner3.getValue(), (Integer) spinner4.getValue(), checkboxes);

                } else {
                    StartButton.setText("START THE PROGRAM");
                    alarm.StopTimer();
                    for (JCheckBox c : JCheckBoxes) { c.setEnabled(true);}
                    for (JSpinner c : JSpinners) { c.setEnabled(true);}

                }
            }
        }
    }
}