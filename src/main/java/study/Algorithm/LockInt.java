package study.Algorithm;

import java.util.*;

/**
 * @创建人 guoyf
 * @创建时间 2020/5/27
 * @描述
 */
//给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
//        说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
public class LockInt {
    public static  List<Integer> majorityElement(int[] nums) {
        int flag = nums.length/3;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
                if (hashMap.get(nums[i]) > flag) {
                    list.add(nums[i]);
                }
                continue;
            }
            hashMap.put(nums[i],1);
        }
        return list;
    }
}
