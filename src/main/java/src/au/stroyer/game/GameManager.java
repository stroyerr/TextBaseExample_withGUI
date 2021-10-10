package src.au.stroyer.game;

import src.au.stroyer.log.Log;

public class GameManager {

    private int stage = 0;
    private String player = "";
    public static GameManager activeManager;
    public GameManager(){
        this.stage = 0;
        this.player = "";
        this.init();
        activeManager = this;
    }

    public void init(){
        Log.fromConsole("Welcome, player! \n Lets begin your adventure... please, tell me your name!");
    }

    public void executeTask(String input) {
        switch (this.stage) {
            case 0:
                if(input.length() < 3 || input.length() > 20){
                    Log.fromConsole("Please enter a name longer than 3 characters and shorter than 20 characters.");
                    return;
                }
                this.player = input;
                Log.fromConsole("Welcome, " + this.player + " lets begin.");
                this.nextStage();
                return;
            case 1:
                String toCheck = input.toLowerCase();
                switch (toCheck) {
                    case "north":
                        Log.fromConsole("You begin to travel North...");
                        return;
                    case "south":
                        Log.fromConsole("You begin to travel South...");
                        return;
                    case "east":
                        Log.fromConsole("You begin to travel East...");
                        return;
                    case "west":
                        Log.fromConsole("You begin to travel West...");
                        return;
                    default:
                        Log.fromConsole("Unkown direction! Please enter North, East, South or West!");
                        return;
                }
        }
    }

    public void nextStage(){
        this.stage ++;
        this.initNextStage();
    }

    public void initNextStage(){
        switch (this.stage){
            case 1:
                Log.fromConsole("Which direction would you like to begin in?");
        }
    }
}
