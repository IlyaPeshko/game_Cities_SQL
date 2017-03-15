package by.htp.game;

import by.htp.game.Utility.FirstLastLetter;

/**
 * Created by ilyalees on 09/03/2017.
 */
public class TestMain {
    public static void main(String[] args) {
        FirstLastLetter letter = new FirstLastLetter();
        letter.lastLetter("июль");
        System.out.println("target "+letter.lastLetter("июль"));
    }
}
