package view;
import readWrite.ItemListCreator;
import readWrite.ReadFromXlsx;
import readWrite.WriteToExcelForCheck;
import readWrite.WriteToXml;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class Interface extends JFrame implements ActionListener {
    static JLabel label = new JLabel();
    static JLabel labelIn = new JLabel();
    static JLabel labelOut = new JLabel();
    String in;
    String out;


    Interface() {

    }

    public static void main(String[] args) {
        Interface i = new Interface();
        i.setSize(250, 200);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton buttonIn = new JButton("Choose xlsx file");
        JButton buttonOut = new JButton("Choose output folder");
        JButton convert = new JButton("Convert");
        // convert.setBackground(new Color(93, 75, 182));
        // convert.setForeground(Color.WHITE);
        // convert.setBorderPainted(false);
        // convert.setContentAreaFilled(false);
        //convert.setOpaque(true);
        buttonIn.addActionListener(i);
        buttonOut.addActionListener(i);
        convert.addActionListener(i);



        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.weightx = 0.5;
        grid.gridy = 0;
        panel.add(Box.createVerticalGlue());

        grid.fill = GridBagConstraints.CENTER;
        grid.gridx = 0;
        grid.gridy = 0;
        panel.add(buttonIn, grid);

        grid.fill = GridBagConstraints.CENTER;
        grid.gridx = 0;
        grid.gridy = 1;
        panel.add(labelIn, grid);

        grid.fill = GridBagConstraints.CENTER;
        grid.gridx = 0;
        grid.gridy = 3;
        panel.add(buttonOut, grid);

        grid.fill = GridBagConstraints.CENTER;
        grid.gridx = 0;
        grid.gridy = 4;
        panel.add(labelOut, grid);

        grid.fill = GridBagConstraints.CENTER;
        grid.gridx = 0;
        grid.gridy = 5;
        panel.add(convert, grid);


        grid.fill = GridBagConstraints.CENTER;
        grid.gridx = 0;
        grid.gridy = 6;
        panel.add(label, grid);

        i.add(panel);
        i.add(panel);
        i.add(panel);
        i.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Choose xlsx file")) {
            JFileChooser fileOpen = new JFileChooser();
            int ret = fileOpen.showDialog(null, "Choose file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileOpen.getSelectedFile();
                label.setText("");
                labelIn.setText(file.getName());
                in = fileOpen.getCurrentDirectory() + "/" + file.getName();
            }
        } else if (s.equals("Choose output folder")) {
            JFileChooser folderOutPanel = new JFileChooser();
            folderOutPanel.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int retOut = folderOutPanel.showDialog(null, "Open OutPut folder");
            if (retOut == JFileChooser.APPROVE_OPTION) {
                File folderOut = folderOutPanel.getSelectedFile();
                label.setText("");
                labelOut.setText(folderOutPanel.getCurrentDirectory() + "/");
                out = folderOutPanel.getCurrentDirectory() + "/";
            }
        }

        else if (s.equals("Convert"))
        {
            if (in != null && out != null) {
                try {
                   // QvvConverter.readXLSXFile(in, out);
                   ReadFromXlsx.readXLSXFile(in, out);
                    label.setText("Converted");
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NullPointerException n) {
                    n.printStackTrace();
                    label.setText("Choose the folder and file");
                }
            }
            else
            {
                label.setText("Choose the folder and file");
            }
        }
    }
}