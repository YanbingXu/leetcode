package project03.com.atguigu.team.service;

/**
 * 自定义异常类
 * 1.继承exception或者runtimexception
 * 2.提供一个唯一的序列号
 * 3.空参和带参的构造函数
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387514229948L;

    public TeamException() {
    }

    public TeamException(String msg) {
        super(msg);
    }
}
