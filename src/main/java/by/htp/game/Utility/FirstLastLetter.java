package by.htp.game.Utility;

/**
 * Created by ilyalees on 05/03/2017.
 */
public class FirstLastLetter {

    private char firstLetter;
    private char lastLetter;
    private char sortLetter1 = 'ь';
    private char sortLetter2 = 'ъ';
    private char sortLetter3 = 'ы';

    public char firstLetter (String word){

        char[] charWordArray = word.toLowerCase().toCharArray();
        firstLetter = charWordArray[0];

        return firstLetter;
    }

    public char lastLetter (String word){

        char[] charWordArray = word.toLowerCase().toCharArray();
        for (char s: charWordArray) {
            lastLetter = s;
        }

        if (sortLetter1 == lastLetter ||sortLetter2 == lastLetter ||
                sortLetter3 == lastLetter){
            int charArraySize = charWordArray.length;
            lastLetter = charWordArray[charArraySize -2];
        }

        return lastLetter;
    }

}
