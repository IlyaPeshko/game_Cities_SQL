package by.htp.game.Domain;

/**
 * Created by ilyalees on 05/03/2017.
 */
public class City implements Comparable <City>{
    private int city_id;
    private String name;
    private char firstLetter;
    private char lastLetter;


    public City(){}

    public City(int city_id, String name) {
        this.city_id = city_id;
        this.name = name;
    }

    public City(int city_id, String name, char firstLetter, char lastLetter) {
        this.city_id = city_id;
        this.name = name;
        this.firstLetter = firstLetter;
        this.lastLetter = lastLetter;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    public char getLastLetter() {
        return lastLetter;
    }

    public void setLastLetter(char lastLetter) {
        this.lastLetter = lastLetter;
    }

    @Override
    public String toString() {
        return "город "+ name;
    }

    @Override
    public int compareTo(City o) {
        //return name.hashCode()-o.name.hashCode();
        return lastLetter-o.firstLetter;
    }
}
