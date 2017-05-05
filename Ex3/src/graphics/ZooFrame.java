package graphics;

import privateutil.BackgroundPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 30/04/2017
 * @see
 */
public class ZooFrame extends JFrame {

    private static final String PICTURESPATH = absolutePath() + "\\src\\graphics\\pictures\\";

    private BufferedImage image;
    private BackgroundPanel greenBg, noBg, imageBg;
//    private JFrame zoo;
    private JMenuBar menuBar;
    private JMenu fileMenu, backgroundMenu, helpMenu;
    private JMenuItem exitMenuI, imageMenuI, greenMenuI, noneMenuI, helpMenuI;
    private ZooPanel zooPanel;
    private JPanel panel1;

    public ZooFrame(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocation(400, 200);
        setSize(1080, 720);
        greenBg = new BackgroundPanel(new Color(46, 150, 51));
        noBg = new BackgroundPanel(getBackground());
        imageBgInit();
    }

    public static String absolutePath() {
        return new File("").getAbsolutePath();
    }

    public void imageBgInit() {
        try {
            image = ImageIO.read(new File(PICTURESPATH + "savanna.jpg"));
        } catch (Exception e1) {
            System.out.println("Cannot read file: " + e1);
        }
        imageBg = new BackgroundPanel(image);
    }

    public void menuInit() {
        menuBar = new JMenuBar();
        setZooPanel();
        add(zooPanel, BorderLayout.SOUTH);
        buildFileMenu();
        buildBackgroundMenu();
        buildHelpMenu();
        setVisible(true);
    }

    public void setZooPanel() {
        zooPanel = new ZooPanel(this);
        zooPanel.init();
    }

    public ActionListener help1ActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Home Work 3\nGui @ Threads");
            }
        };
        return AL;
    }

    public void buildHelpMenu() {
        //Build the Help menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(helpMenu);
        helpMenuI = new JMenuItem("Help");
        helpMenuI.addActionListener(help1ActionListener());
        helpMenu.add(helpMenuI);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    public ActionListener greenActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(greenBg);
                setVisible(true);
                add(zooPanel, BorderLayout.SOUTH);
            }
        };
        return AL;
    }

    private ActionListener noneActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(noBg);
                setVisible(true);
                add(zooPanel, BorderLayout.SOUTH);
            }
        };
        return AL;
    }

    private ActionListener imageActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(imageBg);
                setVisible(true);
                add(zooPanel, BorderLayout.SOUTH);
            }

        };
        return AL;
    }

    public void buildBackgroundMenu() {
        //Build the Background menu
        backgroundMenu = new JMenu("Background");
        backgroundMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(backgroundMenu);
        imageMenuI = new JMenuItem("Image");
        imageMenuI.addActionListener(imageActionListener());
        greenMenuI = new JMenuItem("Green");
        greenMenuI.addActionListener(greenActionListener());
        noneMenuI = new JMenuItem("None");
        noneMenuI.addActionListener(noneActionListener());
        backgroundMenu.add(imageMenuI);
        backgroundMenu.addSeparator();
        backgroundMenu.add(greenMenuI);
        backgroundMenu.addSeparator();
        backgroundMenu.add(noneMenuI);
        menuBar.add(backgroundMenu);
    }


    public ActionListener exitActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        return AL;
    }

    public void buildFileMenu() {
        //Build the File menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_A);
        exitMenuI = new JMenuItem("Exit");//creating the Exit menu item
        exitMenuI.addActionListener(exitActionListener());
        fileMenu.add(exitMenuI);//adding it
        menuBar.add(fileMenu);
    }

    public static void main(String[] args) {
        ZooFrame zooFrame = new ZooFrame("Zoo");
        zooFrame.menuInit();
//        AddAnimalDialog addAnimal = new AddAnimalDialog("Add an Animal Dialog");
//        addAnimal.setVisible(true);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
