package by.htp.game.Dao;

import by.htp.game.Domain.City;
import by.htp.game.Utility.FirstLastLetter;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by ilyalees on 05/03/2017.
 */
public class SqlQuery {
    static final String URL = "jdbc:mysql://localhost:" + "3306/Cities?&characterEncoding=utf-8&...";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public ArrayList<City> arrayCityByLetter(char letter) {
        ArrayList <City> list = new ArrayList<City>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        FirstLastLetter findLetter = new FirstLastLetter();

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM city WHERE name LIKE + '"+letter+"%'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City();
                city.setCity_id(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("name"));
                city.setFirstLetter(findLetter.firstLetter(resultSet.getString("name")));
                city.setLastLetter(findLetter.lastLetter(resultSet.getString("name")));
                list.add(city);
            }
        } catch (SQLException e) {
            System.out.println("error arrayCityByLetter");
            e.printStackTrace();
        }
        return list;
    }


    public boolean varifyExist (String nameCity) {
        ArrayList <City> listVarifyExist = new ArrayList<City>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM city WHERE name LIKE + '"+nameCity+"%'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next() && listVarifyExist.size()<1) {
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCity_id(resultSet.getInt("city_id"));
                listVarifyExist.add(city);
            }
            if (listVarifyExist.size()>0){
                result = true;
                listVarifyExist.remove(0);
            }
        } catch (SQLException e) {
            System.out.println("error varifyExist");
            e.printStackTrace();
        }
        return result;
    }


    public City findById(int id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int idFind = id;
        City city = new City();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM city where city_id = '" + idFind + "' ;");
            while (resultSet.next()) {
                city.setCity_id(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("error findById");
            e.printStackTrace();
        }
        System.out.println(city);
        return city;
    }
}
