package graphics;

import privateutil.BackgroundPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;


/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 30/04/2017
 * @see
 */
public class ZooFrame extends JFrame {

    BufferedImage image1;
    BackgroundPanel greenBg, noBg, imageBg;
    private JFrame zoo;
    private JMenuBar menuBar;
    private JMenu file, background, help;
    private JMenuItem exit, image, green, none, help1;
    private ZooPanel zooPanel;
    private JPanel panel1;

    public ZooFrame() {
        zoo = new JFrame("Zoo");
        zoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zoo.pack();
        zoo.setLocation(400, 200);
        zoo.setSize(1080, 720);
        greenBg = new BackgroundPanel(new Color(46, 150, 51));
        noBg = new BackgroundPanel(getBackground());

    }

    public void menuInit() {
        menuBar = new JMenuBar();
        setZooPanel();
        zoo.add(zooPanel, BorderLayout.SOUTH);
        buildFileMenu();
        buildBackgroundMenu();
        buildHelpMenu();
        zoo.setVisible(true);
    }

    public void setZooPanel() {
        zooPanel = new ZooPanel();
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
        help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_A);
        menuBar.add(help);
        help1 = new JMenuItem("Help");
        help1.addActionListener(help1ActionListener());
        help.add(help1);
        menuBar.add(help);
        zoo.setJMenuBar(menuBar);
    }

    public ActionListener greenActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoo.setContentPane(greenBg);
                zoo.setVisible(true);
                zoo.add(zooPanel, BorderLayout.SOUTH);
            }
        };
        return AL;
    }

    private ActionListener noneActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoo.setContentPane(noBg);
                zoo.setVisible(true);
                zoo.add(zooPanel, BorderLayout.SOUTH);
            }
        };
        return AL;
    }

    public String getFilePath(String filename) {
        URL resource = getClass().getResource(filename);
        return resource.toString().replace("file:/", "");
    }

    private ActionListener imageActionListener() {
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    final JFileChooser fc = new JFileChooser();
                    fc.setDialogTitle("Choose background to your zoo");
                    FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg",
                            "png");
                    fc.setFileFilter(filter);
                    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        //
                    }
                    File f = fc.getSelectedFile();

                    image1 = ImageIO.read(f);
                    System.out.println("File " + f.toString());
                } catch (Exception e1) {
                    System.out.println("Cannot read file: " + e1);
                }
                imageBg = new BackgroundPanel(image1);
                zoo.setContentPane(imageBg);
                zoo.setVisible(true);
                zoo.add(zooPanel, BorderLayout.SOUTH);
            }

        };
        return AL;
    }

    public void buildBackgroundMenu() {
        //Build the Background menu
        background = new JMenu("Background");
        background.setMnemonic(KeyEvent.VK_A);
        menuBar.add(background);
        image = new JMenuItem("Image");
        image.addActionListener(imageActionListener());
        green = new JMenuItem("Green");
        green.addActionListener(greenActionListener());
        none = new JMenuItem("None");
        none.addActionListener(noneActionListener());
        background.add(image);
        background.add(green);
        background.add(none);
        menuBar.add(background);
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
        file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_A);
        exit = new JMenuItem("Exit");//creating the Exit menu item
        exit.addActionListener(exitActionListener());
        file.add(exit);//adding it
        menuBar.add(file);
    }

    public static void main(String[] args) {
        ZooFrame zooFrame = new ZooFrame();
        zooFrame.menuInit();
//        AddAnimal addAnimal = new AddAnimal("Add an Animal Dialog");

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
