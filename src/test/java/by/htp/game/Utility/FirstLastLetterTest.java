package by.htp.game.Utility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ilyalees on 14/03/2017.
 */
public class FirstLastLetterTest {
    private FirstLastLetter letter = null;

    @Before
    public void setUp() throws Exception {
        letter = new FirstLastLetter();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void firstLetter() throws Exception {
        assertTrue ("wrong first symbol",(letter.firstLetter("Москва")=='м'));

    }

    @Test
    public void lastLetter() throws Exception {
        assertTrue("wrong last symbol",(letter.lastLetter("Антополь")=='л'));

    }

}