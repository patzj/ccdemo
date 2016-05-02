package xyz.patzj.ccdemo.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import xyz.patzj.ccdemo.action.Encryptor;
import xyz.patzj.ccdemo.action.Decryptor;

/**
 * Primary container of other UI components.
 * @author patzj
 */
public class Panel extends JPanel {

    private JRadioButton radEncrypt;
    private JRadioButton radDecrypt;
    private JLabel lblKey;
    private JLabel lblPlain;
    private JLabel lblCipher;
    private JLabel lblErr;
    private JTextField txtKey;
    private JTextField txtPlain;
    private JTextField txtCipher;
    private JButton btnExec;
    private JButton btnClr;

    /**
     * Default constructor.
     */
    public Panel() {
        // initialize primary panel properties
        setPreferredSize(new Dimension(320, 180));
        setLayout(new BorderLayout());

        initPnlNorth();
        initPnlCenter();
        initPnlSouth();
    }

    public void initPnlNorth() {
        JPanel pnl = new JPanel();
        ButtonGroup btnGrp = new ButtonGroup();
        radEncrypt = new JRadioButton("Encrypt");
        radDecrypt = new JRadioButton("Decrypt");
        lblKey = new JLabel("Key:");
        txtKey = new JTextField(4);

        radEncrypt.setSelected(true);

        btnGrp.add(radEncrypt);
        btnGrp.add(radDecrypt);

        pnl.add(radEncrypt);
        pnl.add(radDecrypt);
        pnl.add(lblKey);
        pnl.add(txtKey);

        add(pnl, BorderLayout.NORTH);
    }

    public void initPnlCenter() {
        JPanel pnl = new JPanel();
        JPanel pnlEncrypt = new JPanel();
        JPanel pnlDecrypt = new JPanel();
        JPanel pnlErr = new JPanel();
        lblPlain = new JLabel("Plain Text:");
        lblCipher = new JLabel("Cipher Text:");
        lblErr = new JLabel("");
        txtPlain = new JTextField(28);
        txtCipher = new JTextField(28);

        pnlEncrypt.setLayout(new BorderLayout());
        pnlEncrypt.add(lblPlain, BorderLayout.NORTH);
        pnlEncrypt.add(txtPlain);

        pnlDecrypt.setLayout(new BorderLayout());
        pnlDecrypt.add(lblCipher, BorderLayout.NORTH);
        pnlDecrypt.add(txtCipher);

        pnlErr.add(lblErr);

        pnl.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnl.add(pnlEncrypt);
        pnl.add(pnlDecrypt);
        pnl.add(lblErr);

        add(pnl);
    }

    public void initPnlSouth() {
        JPanel pnl = new JPanel();
        JButton btnExec = new JButton("Execute");
        JButton btnClr = new JButton("Clear");

        btnExec.addActionListener(new ExecListener());

        pnl.add(btnExec);
        pnl.add(btnClr);

        add(pnl, BorderLayout.SOUTH);
    }

    private class ExecListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Object src = event.getSource();
            String plain = "";
            String cipher = "";

            if(radEncrypt.isSelected()) {
                plain = txtPlain.getText();
                txtCipher.setText(plain);
            } else {
                cipher = txtCipher.getText();
                txtPlain.setText(cipher);
            }
        }
    }
}
