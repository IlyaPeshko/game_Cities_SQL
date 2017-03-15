package by.htp.game.Utility;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ilyalees on 14/03/2017.
 */
public class FirstLastLetterTestNG {

    @DataProvider (name = "first")
    public Object[][] firstLetter (){
        return new Object [][] {
            {"Москва", 'м'},
            {"Минск", 'м'},
        };
    }

    @Test (dataProvider = "first")
    public void testFirstLetter(String firstParam, char secondParam) throws Exception {
        FirstLastLetter letter = new FirstLastLetter();
        assert (letter.firstLetter(firstParam) == secondParam);
    }

    @DataProvider (name = "last")
    public Object [][] lastLetter () {
        return new Object[][]{
                {"Москва", 'а'},
                {"Октябрь", 'р'}
        };
    }

    @Test (dataProvider = "last")
    public void testLastLetter(String firstParam, char secondParam) throws Exception {
        FirstLastLetter letter = new FirstLastLetter();
        assert (letter.lastLetter(firstParam) == secondParam);
    }

}