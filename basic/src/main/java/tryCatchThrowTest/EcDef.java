package tryCatchThrowTest;

/**
 * 完成一个自定义异常类有三点
 * 继承现有的异常体系结构
 * 提供一个序列的版本号（自己特有的）
 * 提供重载的构造器
 */
public class EcDef extends Exception {
    static final long serialVersionUID = -33875124229948L;

    public EcDef() {
    }

    public EcDef(String msg) {
        super(msg);
    }
}
