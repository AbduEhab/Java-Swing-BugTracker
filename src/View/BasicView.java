package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import Misc.Logger;

public class BasicView {

    public BasicView() {
        JFrame one = new JFrame();
        Logger.Log("Frame Rendered");
        // one.setLocationRelativeTo(null);

        JButton but = new JButton();
        but.addActionListener(e -> {
            Logger.Declare("Program End");
            System.exit(0);
        });
        but.setPreferredSize(new Dimension(200, 100));

        one.getContentPane().add(but, BorderLayout.CENTER);

        one.setTitle("DEMO");
        one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        one.setSize(new Dimension(800, 600));
        one.setVisible(true);
    }

}