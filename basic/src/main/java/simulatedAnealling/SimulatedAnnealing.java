package simulatedAnealling;

/**
 * Date : 2019/8/30
 *
 * @author: 00264992
 */
public class SimulatedAnnealing {
    //计算acceptance的概率
    public static double acceptanceProbability(int energy,int newEnergy,double temperature){
        //如果新的solution更好就接受他
        if(newEnergy<energy){
            return 1.0;
        }
        //如果新的更差，计算一个acceptance probability
        return Math.exp((energy-newEnergy)/temperature);
    }

    public static void main(String[] args) {
        //创建和添加我们的城市
        City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20);

        //设置初始温度
        double temp = 10000;

        //冷却比率
        double coolingRate = 0.003;

        //初始化原始解
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();
        System.out.println("Initial solution distance:"+currentSolution.getDistance());

        //设置为当前最佳
        Tour best = new Tour(currentSolution.getTour());

        //循环直到系统冷却
        while(temp>1){
            //创造新的邻居tour
            Tour newSolution = new Tour(currentSolution.getTour());

            //得到一个tour中的随机位置
            int tourPos1 = (int) (newSolution.tourSize()* Math.random());
            int tourPos2 = (int) (newSolution.tourSize()* Math.random());

            //得到在指定位置的city
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            //交换他们
            newSolution.setCity(tourPos2,citySwap1);
            newSolution.setCity(tourPos1,citySwap2);

            //得到解的能量
            int currentEnergy = currentSolution.getDistance();
            int neighbourEnergy = newSolution.getDistance();

            //决定是否要接受新的邻居
            if(acceptanceProbability(currentEnergy,neighbourEnergy,temp)> Math.random()){
                currentSolution = new Tour(newSolution.getTour());
            }

            //跟踪找到最佳解决方案
            if(currentSolution.getDistance()<best.getDistance()){
                best = new Tour(currentSolution.getTour());
            }

            //冷却系统
            temp*=1-coolingRate;
        }
        System.out.println("Final solution distance:"+best.getDistance());
        System.out.println("tour:"+best);
    }
}