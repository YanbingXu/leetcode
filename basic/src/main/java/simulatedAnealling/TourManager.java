package simulatedAnealling;

import java.util.ArrayList;

/**
 * Date : 2019/8/30
 *
 * @author: 00264992
 */
public class TourManager {
    //存储我们要去的城市
    private static ArrayList destinationCities = new ArrayList<City>();

    //添加一个目的城市
    public static void addCity(City city){
        destinationCities.add(city);
    }

    //get方法

    public static City getCity(int index) {

        return (City) destinationCities.get(index);
    }

    //get 目的城市的数量
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
