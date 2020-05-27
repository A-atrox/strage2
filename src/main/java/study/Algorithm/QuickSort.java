package study.Algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int arr []= new int[]{49,38,65,97,76,13,27,84};
        quickSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        for (int i = 1;i<=9;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(j +" * "+ i +" = "+ (i*j)+"  ");
            }
            System.out.println();
        }
    }
    /**

     *@描述

     *@参数  [array]

     *@返回值  void

     *@创建人  guoyf

     *@创建时间  2020/5/19

     *@修改人和其它信息
        gyfc快捷短语
     */
    public  static  void quickSort(int [] array){

        int len = array.length;
        if (len > 1) {
            // 这里调用核心代码
            sort(array,0,array.length-1);
        } else {
            return;
        }
    }
    public static void sort(int[] array, int left, int right){
        if(left > right){
            return;
        }
        int base = array[left];//base用作存放基数
        int i = left,j = right;
        while(i != j) {
            // 从右往左找，直到找到比base值小的数
            while (array[j] >= base && i < j){
                j--;
            }
            // 再从左往右找，直到找到比base大的数
            while(array[i] <= base && i < j){
                i++;
            }
            // 上面循环结束表示找到了位置或者 i>=j了,这个时候就应该交换两个数在数组中的位置
            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        System.out.println(java.util.Arrays.toString(array));
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;
        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    
}
