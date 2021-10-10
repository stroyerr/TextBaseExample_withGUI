package src.au.stroyer.Main;

import src.au.stroyer.gui.GUI;

public class Main {
    public static void main(String[] args){
        onEnable();
    }

    private static void onEnable(){
        GUI.init();
    }
}
