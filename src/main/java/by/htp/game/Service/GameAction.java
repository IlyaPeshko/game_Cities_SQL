package by.htp.game.Service;

import by.htp.game.Dao.SqlQuery;
import by.htp.game.Domain.City;
import by.htp.game.Utility.FirstLastLetter;
import by.htp.game.Utility.RandomNumber;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ilyalees on 09/03/2017.
 */
public class GameAction {
    private int round = 1;
    private Set<String> gameSteps = new TreeSet<String>();

    private City userStep () {
        City userCity = new City();

        SqlQuery query = new SqlQuery();
        Scanner scanner = new Scanner(System.in);
        FirstLastLetter findLetter = new FirstLastLetter();

        String userWord = scanner.nextLine().toLowerCase();

        boolean existCity = query.varifyExist(userWord);

        if (existCity == false){
            while (existCity != true){
                System.out.println("К сожалению, такого города нет в базе данных...");
                userWord = scanner.nextLine().toLowerCase();
                existCity = query.varifyExist(userWord);
            }
        }

        userCity.setName(userWord);
        userCity.setFirstLetter(findLetter.firstLetter(userWord));
        userCity.setLastLetter(findLetter.lastLetter(userWord));

        return userCity;
    }

    private City compStep (char lastLetterUserCity) {
        City compCity = new City();

        SqlQuery query = new SqlQuery();
        RandomNumber randomNumber = new RandomNumber();
        FirstLastLetter findLetter = new FirstLastLetter();

        ArrayList <City> cityArrayList = query.arrayCityByLetter(lastLetterUserCity);
        compCity = cityArrayList.get(randomNumber.random(cityArrayList.size()));

        gameSteps.add(compCity.getName());

        return compCity;
    }
    
    public boolean usedVefify (String city) {
        
        boolean alreadyUsed = gameSteps.add(city);

        return alreadyUsed;
    } 

    public void game (int NumberOfRounds) {
        SqlQuery query = new SqlQuery();

        System.out.println("Раунд " + round);
        System.out.println("Введите город: ");
        City userCity = userStep();
        System.out.println("Игрок: " + userCity);

        while (round<NumberOfRounds){
            City compCity = compStep(userCity.getLastLetter());
            System.out.println("Компьютер: " + compCity);

            System.out.println("Раунд " + ++round);

            System.out.println("Введите город: ");
            userCity = userStep();

            int comparator = compCity.compareTo(userCity);
            boolean alreadyUser = usedVefify(userCity.getName());
            
            if (comparator != 0 || alreadyUser == false) {
                while (comparator != 0 || alreadyUser != true) {

                    if (alreadyUser == false) {
                        System.out.println("Нельзя повторять города...");
                    }
                    if (comparator != 0) {
                        System.out.println("Город должен начинаться на букву '"+ compCity.getLastLetter() +  "', попробуйте еще раз..." );
                    }

                    userCity = userStep();
                    comparator = compCity.compareTo(userCity);
                    alreadyUser = usedVefify(userCity.getName());
                }
            }
            gameSteps.add(compCity.getName());
        }

        gameSteps.add(userCity.getName());
        System.out.println("Города" + gameSteps);
    }
}
