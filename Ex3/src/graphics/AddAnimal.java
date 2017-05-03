package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 03/05/2017
 * @see
 */
@SuppressWarnings("ALL")
public class AddAnimal extends JFrame {
    GridLayout layout;
    private JComboBox<String> chooseCbx;
    private final static String[] ANIMALS = {"Lion", "Bear", "Giraffe", "Elephant", "Turtle"};
    private final static String[] COLORS = {"Natural", "Red", "Blue"};
    private JTextField sizeText;
    private JTextField vSpeedText;
    private JTextField hSpeedText;
    private JComboBox colorCbx;
    private JLabel chooseLabel;
    private JLabel sizeLabel;
    private JLabel vSpeedLabel;
    private JLabel hSpeedLabel;
    private JLabel colorLabel;
    private JButton okButton;
    private JButton cancelButton;

    public AddAnimal(String name) {
        super(name);
        guiInit();
        initComponents();
        pack();
        setVisible(true);
    }


    private void guiInit(){
        setBounds(600,300,600,500);
        layout=new GridLayout(0, 2,50,23);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initComponents() {

        setLayout(layout);
        //Choose an Animal Label
        chooseLabel = new JLabel("Choose an Animal:");
        add(chooseLabel,0,0);

        //Choose an Animal Combo Box: with "Lion", "Bear", "Giraffe", "Elephant", "Turtle"
        chooseCbx = new JComboBox<String>(ANIMALS);
        add(chooseCbx);

        //set the size of the animal label
        sizeLabel = new JLabel("Animal Size:");
        add(sizeLabel);
        sizeText = new JTextField();
//        sizeText.
        add(sizeText);

        //set the animal vertical speed
        vSpeedLabel = new JLabel("Animal Vertical Speed:");
        add(vSpeedLabel);
        vSpeedText = new JTextField();
        add(vSpeedText);

        //set the animal horizontal speed
        hSpeedLabel = new JLabel("Animal Horizontal Speed:");
        add(hSpeedLabel);
        hSpeedText = new JTextField();
        add(hSpeedText);

        //set the animal color
        colorLabel = new JLabel("Animal Color:");
        add(colorLabel);
        colorCbx = new JComboBox<String>(COLORS);
        add(colorCbx);

        okButton = new JButton("OK");
        add(okButton);
        cancelButton = new JButton("Cancel");
        add(cancelButton);
    }//end initComponents

}//end class
