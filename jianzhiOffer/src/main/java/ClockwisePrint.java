import java.util.ArrayList;
public class ClockwisePrint {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //确定4个顶点
        int row = matrix.length;
        int column = matrix[0].length;
        int top = 0;
        int right = column-1;
        int bottom = row-1;
        int left = 0;
        while(left<=right && top<=bottom){
            //从左到右添加第一行
            for(int i=left;i<=right;i++){
                arrayList.add(matrix[top][i]);
            }
            if(top<bottom){
                //从上到下添加第一列
                for(int i=top+1;i<=bottom;i++){
                    arrayList.add(matrix[i][right]);
                }
            }
            if(right>left&&top<bottom){
                //从右到左添加最后一行
                for(int i=right-1;i>=left;i--){
                    arrayList.add(matrix[bottom][i]);

                }
            }
            if(bottom>top&&right>left){
                //从下到上添加最后一列
                for(int i=bottom-1;i>top;i--){
                    arrayList.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;


        }

        return arrayList;
    }
}
