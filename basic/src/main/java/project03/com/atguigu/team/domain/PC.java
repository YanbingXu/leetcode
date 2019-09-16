package project03.com.atguigu.team.domain;

public class PC implements Equipment {
    private String model; //机器型号
    private String display; //显示器的名称

    //提供构造器，空参的和带参数的
    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    //提供getset方法


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
