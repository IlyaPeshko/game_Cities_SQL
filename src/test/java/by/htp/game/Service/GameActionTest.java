package by.htp.game.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

/**
 * Created by ilyalees on 14/03/2017.
 */
public class GameActionTest {
    private GameAction game = new GameAction();
    private Set<String> gameSteps;
    @Before
    public void setUp() throws Exception {
        gameSteps =new TreeSet<String>();
        gameSteps.add("Минск");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void usedVefify() throws Exception {
        //assertTrue (game.usedVefify("Москва"));
        assertTrue (game.usedVefify("Минск"));

        System.out.println(game.usedVefify("Минск"));
        System.out.println(gameSteps);
    }


}