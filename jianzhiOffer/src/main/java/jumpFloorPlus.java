public class jumpFloorPlus {
    public int JumpFloorII(int target) {
        //数学归纳法1,2,4,8,16
        return (int)Math.pow(2,(target-1));

    }
}
