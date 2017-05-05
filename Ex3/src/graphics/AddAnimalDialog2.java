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
public class AddAnimalDialog2 extends JFrame {

    private final static String[] ANIMALS = {"Lion", "Bear", "Giraffe", "Elephant", "Turtle"};
    private final static String[] COLORS = {"Natural", "Red", "Blue"};

    private GridLayout layout;
    private JFrame parentFrame;
    private JPanel addAnimalPanel,parentPanel;
    private JComboBox<String> chooseCbx;
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

    public AddAnimalDialog2(JFrame frame,JPanel panel,String name,boolean visible) {
        super(name);
        setParentFrame(frame);
        setParentPanel(panel);
        guiInit();
        initPanel();
        pack();
        setVisible(visible);
    }

    public AddAnimalDialog2(String name) {
        super(name);
        guiInit();
        initPanel();
        pack();

    }


    private void guiInit(){
        setBounds(600,300,600,500);
        layout=new GridLayout(0, 2,50,23);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public boolean setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        return true;
    }

    public boolean setParentPanel(JPanel parentPanel) {
        this.parentPanel = parentPanel;
        return true;
    }

    private void initPanel() {

        addAnimalPanel.setLayout(layout);
        //Choose an Animal Label
        chooseLabel = new JLabel("Choose an Animal:");
        addAnimalPanel.add(chooseLabel,0,0);

        //Choose an Animal Combo Box: with "Lion", "Bear", "Giraffe", "Elephant", "Turtle"
        chooseCbx = new JComboBox<String>(ANIMALS);
        addAnimalPanel.add(chooseCbx);

        //set the size of the animal label
        sizeLabel = new JLabel("Animal Size:");
        addAnimalPanel.add(sizeLabel);
        sizeText = new JTextField();
        addAnimalPanel.add(sizeText);

        //set the animal vertical speed
        vSpeedLabel = new JLabel("Animal Vertical Speed:");
        addAnimalPanel.add(vSpeedLabel);
        vSpeedText = new JTextField();
        addAnimalPanel.add(vSpeedText);

        //set the animal horizontal speed
        hSpeedLabel = new JLabel("Animal Horizontal Speed:");
        addAnimalPanel.add(hSpeedLabel);
        hSpeedText = new JTextField();
        addAnimalPanel.add(hSpeedText);

        //set the animal color
        colorLabel = new JLabel("Animal Color:");
        addAnimalPanel.add(colorLabel);
        colorCbx = new JComboBox<String>(COLORS);
        addAnimalPanel.add(colorCbx);

        okButton = new JButton("OK");
        addAnimalPanel.add(okButton);
        cancelButton = new JButton("Cancel");
        addAnimalPanel.add(cancelButton);

        add(addAnimalPanel);
    }//end initPanel

}//end class
