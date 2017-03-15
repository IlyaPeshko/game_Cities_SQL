package by.htp.game.Dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ilyalees on 14/03/2017.
 */
public class SqlQueryTest {
    private SqlQuery query = new SqlQuery();
    @Before
    public void setUp() throws Exception {
        query = new SqlQuery();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void arrayCityByLetter() throws Exception {
        assertFalse(query.arrayCityByLetter('ф').isEmpty());
        assertTrue(query.arrayCityByLetter('ь').isEmpty());
    }

    @Test
    public void varifyExist() throws Exception {
        assertTrue ("varifyExist", (query.varifyExist("Минск")));
    }

    @Test
    public void findById() throws Exception {

    }

}