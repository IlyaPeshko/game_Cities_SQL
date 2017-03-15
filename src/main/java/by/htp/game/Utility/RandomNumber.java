package by.htp.game.Utility;

/**
 * Created by ilyalees on 06/03/2017.
 */
public class RandomNumber {
    public int random (int number){
        int random_number = 1 + (int) (Math.random() * number);
        return random_number;
    }
}
