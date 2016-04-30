package xyz.patzj.ccdemo.ui;

import javax.swing.JFrame;

/**
 * Window of the application.
 * @author patzj
 */
public class Frame extends JFrame {

    private Panel pnl;

    /**
     * Default constructor.
     */
    public Frame() {
        super("Caesar Cipher Demo");
        pnl = new Panel();

        // add panel and initialize frame properties
        add(pnl);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
