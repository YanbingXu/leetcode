package simulatedAnealling;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date : 2019/8/30
 *
 * @author: 00264992
 */
public class Tour {
    //存储我们的旅行城市
    private ArrayList tour  = new ArrayList<City>();
    //缓存
    private int distance = 0;

    //构建一个空白的旅途
    public Tour(){
        for(int i=0;i<TourManager.numberOfCities();i++){
            tour.add(null);
        }
    }

    //构建一个来自另一个tour的tour
    public Tour(ArrayList tour ){
        this.tour = (ArrayList) tour.clone();
    }

    //返回tour的信息
    public ArrayList getTour(){
        return tour;
    }

    //随机创建一个个体
    public void generateIndividual(){
        //遍历我们所有目的地城市并将其添加到我们的旅游中
        for(int cityIndex = 0;cityIndex<TourManager.numberOfCities();cityIndex++){
            setCity(cityIndex,TourManager.getCity(cityIndex));
        }
        //随机重新排序tour
        Collections.shuffle(tour);
    }

    //get a city from the tour
    public City getCity(int tourPosition){
        return (City) tour.get(tourPosition);
    }

    //set a city in a certain postion within a tour
    public void setCity(int tourPosition,City city){
        tour.set(tourPosition,city);
        //如果这条路已经被使用我们就重设fitness和distance
        distance = 0;
    }

    //得到旅行的总距离
    public int getDistance(){
        if(distance == 0){
            int tourDistance = 0;
            //循环我们旅行的城市
            for(int cityIndex = 0;cityIndex<tourSize();cityIndex++){
                //得到我们从哪个城市开始旅行
                City fromCity = getCity(cityIndex);
                //我们去哪个城市
                City destinationCity;
                //检查我们不在我们旅行的最后一个城市，如果我们设置我们的旅行最后的目的城市为开始城市
                if(cityIndex+1<tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }else{
                    destinationCity = getCity(0);
                }
                //得到两个城市的距离
                tourDistance+=fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;

    }

    //得到我们旅行的城市数量
    public int tourSize(){
        return tour.size();
    }

    @Override
    public String toString() {
        String geneString = "|";
        for(int i=0;i<tourSize();i++){
            geneString +=getCity(i)+"|";
        }
        return geneString;
    }
}
