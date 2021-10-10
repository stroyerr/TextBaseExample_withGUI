package src.au.stroyer.gui;

import src.au.stroyer.game.GameManager;
import src.au.stroyer.log.Log;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void init(){
        splashScreen();
    }

    public static JTextArea log;
    private static void splashScreen(){
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(1,1));
        f.setSize(750, 400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().setName("Stroyer_'s Text Game");;

        JPanel top = new JPanel();
        JPanel game = new JPanel(new GridLayout(2,1));
        JPanel inputPanel = new JPanel(new GridLayout(2,1));
        JPanel bottom = new JPanel();

        JLabel title = new JLabel("Example Text Game");
        top.add(title);

        JButton inputBuffer = new JButton("Enter");
        JTextField inputField = new JTextField();
        inputField.setName("Input");

        inputBuffer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                executeTask(input);
                inputField.setText("");
            }
        });

        log = new JTextArea();
        log.setFont(Font.getFont(Font.SERIF));
        log.setEditable(false);
        log.setAutoscrolls(true);
        JScrollPane scrollPane = new JScrollPane(log);

        game.add(scrollPane, "1");

        inputPanel.add(inputField, "1");
        inputPanel.add(inputBuffer, "2");

        game.add(inputPanel,"2");

//        f.add(top,"1");
        f.add(game,"1");

        f.setVisible(true);

        GameManager.activeManager = new GameManager();
    }

    protected static void executeTask(String input){
        Log.fromPlayer(input);
        GameManager.activeManager.executeTask(input);
    }
}
