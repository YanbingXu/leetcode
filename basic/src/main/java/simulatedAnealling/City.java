package simulatedAnealling;

/**
 * Date : 2019/8/30
 *
 * @author: 00264992
 */
public class City {
    int x;
    int y;

    //随机放置一些city
    public City(){
        this.x = (int) (Math.random()*200);
        this.y = (int) (Math.random()*200);
    }

    //在一个特定想x,y坐标的city

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //get方法

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //得到一个city的给定距离
    public double distanceTo(City city){
        int xDistance = Math.abs(getX()-city.getX());
        int yDistance = Math.abs(getY()-city.getY());
        double distance = Math.sqrt((xDistance*xDistance)+(yDistance*yDistance));
        return distance;
    }

    @Override
    public String toString() {
        return getX()+", "+getY();
    }
}