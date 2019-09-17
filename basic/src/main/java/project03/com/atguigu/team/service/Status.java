package project03.com.atguigu.team.service;

/**
 * 表示员工的状态
 */
public class Status {
    private final String NAME;
    /**
     * 构造器私有化一下，因为只有三个对象
     */
    private Status(String name){
        this.NAME = name;

    }
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }
}
