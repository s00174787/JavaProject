package gui.product;

import gui.UIElements;
import gui.admin.AdminMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class ProductMain implements ActionListener {

    private JPanel prodMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewButton;
    private JTextField searchField;
    private JComboBox prodTypes, brandTypes, modelTypes;
    private JPanel managePanel, northPanel, southPanel, searchPanel, searchTopPanel, searchBottomPanel;

    private String[] prodTypess = {"All", "Sales", "Management"};  // this just a placeholder, real info will be populated from DB
    private String[] brandTypess = {"All", "DELL", "HP", "Apple"};  // this just a placeholder, real info will be populated from DB
    private String[] modelTypess = {"All", "Inpiron 5150", "Latitude 1350"};  // this just a placeholder, real info will be populated from DB

    private AdminMain am;

    public JPanel getProductMain(){

    // setup the frame

        prodMain = new JPanel(new BorderLayout());
        //prodMain.getContentPane().setBackground(new Color(98, 169, 221));

// north panel

        northPanel = new JPanel(new GridBagLayout());
        //northPanel.setBackground(new Color(98, 169, 221));

    // manage products panel

        managePanel = new JPanel(new FlowLayout());
        //managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Products")); // set anonymous titled, etched border

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.addActionListener(this);
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 26));
        editButton.setIcon(new ImageIcon(UIElements.edit16));
        editButton.addActionListener(this);
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 26));
        deleteButton.setIcon(new ImageIcon(UIElements.delete16));
        deleteButton.addActionListener(this);
        managePanel.add(deleteButton);

        northPanel.add(managePanel, getConstraints(0,0,1,1,0,0,0,GridBagConstraints.CENTER));

    // search products panel

        searchPanel = new JPanel(new BorderLayout());
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Products")); // set anonymous titled, etched border

        // top panel containing the search field and search button
        searchTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //searchTopPanel.setBackground(new Color(98, 169, 221));
        searchField = new JTextField(29);
        searchTopPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 26));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchTopPanel.add(searchButton);

        // add top panel to search panel
        searchPanel.add(searchTopPanel, BorderLayout.NORTH);

        // buttom panel containing comboboxes for information filtering
        searchBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //searchBottomPanel.setBackground(new Color(98, 169, 221));
        prodTypes = new JComboBox(new DefaultComboBoxModel<String>(prodTypess));
        brandTypes = new JComboBox(new DefaultComboBoxModel<String>(brandTypess));
        modelTypes = new JComboBox(new DefaultComboBoxModel<String>(modelTypess));

        // add bottom panel to search panel
        searchBottomPanel.add(prodTypes);
        searchBottomPanel.add(brandTypes);
        searchBottomPanel.add(modelTypes);

        searchPanel.add(searchBottomPanel, BorderLayout.SOUTH);

        // add all the above to northPanel
        northPanel.add(searchPanel, getConstraints(1,0,1,2,1,0,0,GridBagConstraints.CENTER));

        // add the above to the northPanel
        prodMain.add(northPanel, BorderLayout.NORTH);

    // results panel
/////////////////////////////////////////////////////////////////////////////////////

// south panel

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(new Color(98, 169, 221));

        // bottom buttons
        viewButton = new JButton("View Product");
        viewButton.setPreferredSize(new Dimension(150, 26));
        viewButton.setIcon(new ImageIcon(UIElements.product16));
        southPanel.add(viewButton);
        viewButton.addActionListener(this);

        prodMain.add(southPanel, BorderLayout.SOUTH);

        // turns the lights on
        return prodMain;
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){
            ProductAddEdit pae = new ProductAddEdit(am,0);
        } // edit product
        else if (e.getSource().equals(editButton)){
            ProductAddEdit pae = new ProductAddEdit(am,1);
        }
        else if (e.getSource().equals(deleteButton)){

        }
        else if (e.getSource().equals(viewButton)){
            ProductView pv = new ProductView(am);
        }
    }

    // return GridBagConstraints for GridBagLayout

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int weightxIn, int leftHorInsetIn, int rightHorInsetIn, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, leftHorInsetIn, 5, rightHorInsetIn);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.weightx = weightxIn;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = anchor;
        return c;
    }
}