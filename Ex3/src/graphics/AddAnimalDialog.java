package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 03/05/2017
 * @see
 */
@SuppressWarnings("ALL")
public class AddAnimalDialog extends JDialog {

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

    public AddAnimalDialog(JFrame frame,JPanel panel,String name,boolean visible) {
        setName(name);
        setParentFrame(frame);
        setParentPanel(panel);
        guiInit();
        initPanel();
        pack();
        setVisible(visible);
    }

    public AddAnimalDialog(String name) {
        this.setName(name);
        guiInit();
        initPanel();
        pack();
    }

    private void guiInit(){
        setBounds(600,300,600,500);
        layout=new GridLayout(0, 2,50,23);
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
        okButton.addActionListener(ActionPe);
        cancelButton = new JButton("Cancel");
        add(cancelButton);
    }//end initPanel

}//end class
