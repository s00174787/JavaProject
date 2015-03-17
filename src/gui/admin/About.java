package gui.admin;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 17/03/2015)
*/

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener {

    private JDialog about;
    private JButton closeButton;
    private JLabel progNameLabel, versionNumLabel, devsLabel, devPic, thanksLabel;
    private JPanel northPanel, centerPanel, southPanel;
    private Border paddingBorder = BorderFactory.createEmptyBorder(20,50,50,20);  // set the border inside the grid to move details away from the edges


    public About(){

        // setup the jdialog
        about = new JDialog();
        about.setTitle("About DGA Computers");
        about.getContentPane().setBackground(new Color(98, 169, 221));
        about.setLayout(new BorderLayout());
        about.setSize(500, 400);
        about.setResizable(false);
        about.setLocationRelativeTo(null);
        about.getContentPane().setBounds(20,20,20,20);

// NORTH PANEL

        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.setBorder(paddingBorder);

        devPic = new JLabel(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\128\\save.png"));
        northPanel.add(devPic);

        about.add(devPic, BorderLayout.NORTH);


// CENTER PANEL

        centerPanel = new JPanel(new GridLayout(4,1));
        centerPanel.setBackground(new Color(98, 169, 221));
        centerPanel.setBorder(paddingBorder);

        progNameLabel = new JLabel("Program Name: DGA Computers");
        centerPanel.add(progNameLabel);

        versionNumLabel = new JLabel("Version: 0.5b");
        centerPanel.add(versionNumLabel);

        devsLabel = new JLabel("Developed By: ");
        centerPanel.add(devsLabel);

        thanksLabel = new JLabel("Special Thanks To: ");
        centerPanel.add(thanksLabel);

        about.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(new Color(98, 169, 221));

        closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(100, 26));
        closeButton.addActionListener(this);

        southPanel.add(closeButton);
        about.add(southPanel, BorderLayout.SOUTH);



        // make about window visible
        about.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        about.dispose();
    }
}