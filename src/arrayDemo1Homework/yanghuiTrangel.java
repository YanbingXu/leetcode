package arrayDemo1Homework;

/**
 * 使用二维数组打印一个10行杨辉三角
 * 除第一个和最后一个元素，yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j]
 */
public class yanghuiTrangel {
    public static void main(String[] args) {
        //1 申明并初始化数组
        int[][] YangHui = new int[10][];
        //2 给数组元素赋值
        for (int i = 0; i < YangHui.length; i++) {
            YangHui[i]=new int[i+1];
            //给首尾位置赋值
            YangHui[i][0]=YangHui[i][i]=1;
            if(i>=2){
                for(int j=1;j<YangHui[i].length-1;j++){   //给零赋值

                    YangHui[i][j]=YangHui[i-1][j-1]+YangHui[i-1][j];


                }
            }

        }
        //3 遍历二维数组
        for (int i = 0; i < YangHui.length; i++) {
            for(int j=0;j<YangHui[i].length;j++){
                System.out.print(YangHui[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
