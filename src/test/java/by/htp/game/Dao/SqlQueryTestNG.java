package by.htp.game.Dao;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ilyalees on 15/03/2017.
 */
public class SqlQueryTestNG {

    @DataProvider (name = "letterForArray")
    public Object [][] ArrayCityByLetter () {
        return new Object[][] {
                {'а'},
                {'в'}
        };
    }

    @Test (dataProvider = "letterForArray")
    public void testArrayCityByLetter(char letter) throws Exception {
        SqlQuery query = new SqlQuery();
        assert (query.arrayCityByLetter(letter).isEmpty()==false);
    }

    @DataProvider (name = "cityForVarifyExist")
    public Object[][] VarifyExist (){
        return new Object[][]{
                {"Минск"},
                {"Москва"}
        };
    }

    @Test (dataProvider = "cityForVarifyExist")
    public void testVarifyExist(String city) throws Exception {
        SqlQuery query = new SqlQuery();
        assert (query.varifyExist(city));
    }

}