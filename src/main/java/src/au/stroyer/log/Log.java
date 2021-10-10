package src.au.stroyer.log;

import src.au.stroyer.gui.GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Log {
    public static void sendMessage(String s){
        JTextArea console = GUI.log;
        String prior = console.getText();
        prior +=( "\n" + s);
    }

    public static void sendMessage(String prefix, String s){
        JTextArea console = GUI.log;
        String prior = "";
        prior +=( "\n" + prefix + ": " + s);
        console.append(prior);
    }

    public static void updateLog(){
        JTextArea console = GUI.log;
        String raw = console.getText();
        String lines[] = raw.split("\\r?\\n");
        List<String> linesToModify = Arrays.stream(lines).toList();
        if(linesToModify.size() >= 5){
            linesToModify.remove(linesToModify.get(0));
        }
        String newLog = "";
        for (String s : linesToModify){
            newLog += "\n" + s;
        }
        GUI.log.setText(newLog);
    }

    public static void fromConsole(String s){
        sendMessage("Game", s);
    }

    public static void fromPlayer(String s){
        sendMessage("You", s);
    }
}
