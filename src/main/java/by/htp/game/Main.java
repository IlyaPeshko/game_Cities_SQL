package by.htp.game;

import by.htp.game.Service.GameAction;

/**
 * Created by ilyalees on 09/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        GameAction action = new GameAction();

        System.out.println("WELCOME");
        System.out.println();

        action.game(6);

        System.out.println();
        System.out.println("END");
    }

}
