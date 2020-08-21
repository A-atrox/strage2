package study.SORT;

import com.alibaba.fastjson.JSONObject;

/**
 * @author guoyf
 * @Date 2020/8/17
 * @describe
 */
public class BiSearch {
    public static void main(String[] args) {
        String json = "{\"a\":\"123\",\"b\":\"456\"}";
        Test test = JSONObject.parseObject(json, Test.class);
        System.out.println(test);

        int []a = {1,2,3,4,5,6,7,8};
        int target = 4;
        System.out.println(biSearch(a,target));
    }

    /***
     *
     * @param a
     * @param target
     * @return target in a index  or  insert index
     */
    public static int biSearch(int[] a, int target) {
        if(target<a[0]){
            return 0;
        }
        if(target>a[a.length-1]){
            return a.length;
        }
        int lo = 0;
        int hi = a.length - 1;
        int mid;
        while(lo<=hi){
            mid = (lo+hi)/2;
            if(a[mid]==target){
                return mid;
            }else if(a[mid]<target){
                // 向左查找
                lo = mid+1;
            } else {
                // 向右查找
                hi = mid-1;
            }
        }
        return lo;
    }

}
