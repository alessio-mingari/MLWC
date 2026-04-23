package alessiomingari.MLWC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MLWC implements ActionListener {

    public static final String TITLE = "MLWC";
    public static final int WIDTH = 450;
    public static final int HEIGHT = 660;

    private JLabel display;

    public static void main(String[] args) {
        JFrame frame = new JFrame(TITLE);

        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        MLWC mlwc = new MLWC();
        mlwc.addComponents(frame);

        frame.setVisible(true);
    }

    private void addComponents(JFrame frame) {

        display = new JLabel("0", SwingConstants.RIGHT);
        display.setBounds(30, 30, WIDTH - 80, 80);
        frame.add(display);

        String[] key_list = {"9", "8", "7", "+", "6", "5", "4", "-", "3", "2", "1", "x", "0", "C", "=", "/",};

        for(int i = 0; i < key_list.length; i++) {
            JButton key = new JButton(key_list[i]);
            key.setBounds(30 + (i / 4) * 100, 200 + (i % 4) * 100, 70, 70);
            key.setActionCommand(key_list[i]);
            key.addActionListener(this);
            frame.add(key);
        }
    }

    private String getResult() {

        return "0";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String code = e.getActionCommand();

        switch (code) {
            case "C":
                display.setText("0");
                break;
            case "=":
                display.setText(getResult());
                break;
            default:
                display.setText(display.getText() + code);
        }
    }
}