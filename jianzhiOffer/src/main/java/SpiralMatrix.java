/**
 * Date : 2019/8/29  *  * @author: 00264992
 */



/**  * 题目 螺旋矩阵  * 7 8 9  * 6 1 2  * 5 4 3  * 以1为中心螺旋发散。  * 规律：变成为n的矩形右上角的数字为（2n+1）^2  * 输入：坐标  * 输出：坐标对应的值  */
public class SpiralMatrix {
    public static double spiralMatrix(int x, int y) {
        //1.如果x的绝对值等于y的绝对值，那么这个点一定是在四个顶点上
        // 定义一个临时的右上角的点

        int tempLength;
        double rightTopVertex;
        double leftTopVertex;
        double rightBotVertex;
        if (Math.abs(x) <= Math.abs(y)) {
            //这是在横边上
            tempLength = Math.abs(y) * 2;
            rightTopVertex = Math.pow((Math.abs(y) * 2 + 1), 2);
            rightBotVertex = rightTopVertex - 3 * tempLength;
            if (y > 0) {
                //这意味着它在右上顶点的邻边
                if (x >= 0) {
                    return rightTopVertex - (tempLength / 2 - x);
                } else {
                    return rightTopVertex - tempLength / 2 + x;
                }
            } else

            {
                //这意味着它在横下的边，从右下顶点开始++
                if (x >= 0) {
                    return rightBotVertex + (tempLength / 2 - x);
                } else

                {
                    return rightBotVertex + tempLength / 2 + Math.abs(x);
                }
            }
        } else { //这是在竖边上
            tempLength = Math.abs(x) * 2;
            rightTopVertex = Math.pow((Math.abs(x) * 2 + 1), 2);
            leftTopVertex = rightTopVertex - tempLength;
            rightBotVertex = rightTopVertex - 2 * tempLength;
            if (x > 0) {
                //这是在右上顶点的邻边上
                if (y >= 0) {
                    return rightBotVertex - tempLength / 2 - y;
                } else {
                    return rightBotVertex - (tempLength / 2 + y);
                }
            } else { //这是在右上顶点的对边上
                if (y > 0) {
                    return leftTopVertex - (tempLength / 2 - y);
                } else {
                    return leftTopVertex - tempLength / 2 + y;
                }
            }
        }

    }

    public static void main(String[] args) {
        double result = spiralMatrix(1, 1);
        double result2 = spiralMatrix(1, -2);
        double result3 = spiralMatrix(-2, 3);
        double result4 = spiralMatrix(-3, -2);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
