package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 30/04/2017
 * @see
 */
public class ZooPanel extends JPanel implements Runnable {

    private JButton addAnimalZP;
    private JButton sleepZP;
    private JButton wakeUpZP;
    private JButton clearZP;
    private JButton foodZP;
    private JButton infoZP;
    private JButton exitZP;


    public ZooPanel() {
        addAnimalZP = new JButton("Add Animal");
        sleepZP = new JButton("Sleep");
        wakeUpZP = new JButton("Wake up");
        clearZP = new JButton("Clear All");
        foodZP = new JButton("Food ");
        infoZP = new JButton("Info");
        exitZP = new JButton("Exit");
    }

    public void init() {
        addAnimalZP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAnimal addAnimal = new AddAnimal("Add an Animal Dialog");
            }
        });

//        infoZP.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JTable animalJTabel = new JTable();
//                String[] columnNames = {"Animal", "Color", "Weight", "Hor. Speed", "Ver. Speed", "Eat Counter"};
//                String[][] data;
//            }
//        });

        foodZP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] choices = {"Meat", "Cabbage", "Lettuce"};
                int choice = JOptionPane.showOptionDialog(null, "Please Choose Food", "Food for Animals",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, choices, choices[0]);
                if (choice == 0) {
                    System.out.println("Meat");
//                    ImageIcon meatIcon = new ImageIcon("meat.gif");
//                    JLabel meatLabel = new JLabel();
//                    meatLabel.setIcon(meatIcon);
//                    meatLabel.setVisible(true);
//                    getconadd(meatLabel);
                    BufferedImage meatIcon = ImageIO.read("C:\Users\Yotam\Ex3\src\graphics\pictures\meat.gif");//it must be an image file, otherwise you'll get an exception
                    JLabel meatLabel = new JLabel();
                    meatLabel.setIcon(new ImageIcon(meatIcon));
                    getContentPane().add(meatLabel);
                }


            }
        });


        add(addAnimalZP);
        add(sleepZP);
        add(wakeUpZP);
        add(clearZP);
        add(foodZP);
        add(infoZP);
        add(exitZP);
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }

}
