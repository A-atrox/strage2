package study.algorithm;

public class Bisearch {
    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end-start)/2;
        while (start <= end)
        {
            if(nums[mid] == target)
                return mid;
            //如果中间值位于左边的升序序列里面
            if (nums[start]<=nums[mid])
            {
                //必须判定左边界和右边界
                //如果target在左边
                if (nums[start] <= target && nums[mid]>=target)
                    end = mid-1;
                    //如果target 在右边
                else start = mid+1;
            }
            //如果中间值位于右边的升序序列里面
            else
            {
                //如果target位于右边序列里面
                if ( nums[mid] <= target && nums[end] >= target)
                {
                    start = mid+1;
                }
                //如果target位于左边序列
                else end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }
}
