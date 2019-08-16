public class FindIn2dArray {
    public boolean Find(int target,int[][] array){
        int row = array.length - 1;
        int column = array[0].length-1;
        int c_in = 0;
        while(row>=0 && c_in<=column){
            if(target>array[row][c_in]){
                c_in++;


            }else if(target<array[row][c_in]){
                row--;
            }else{
                return true;
            }

        }
        return false;
    }
}