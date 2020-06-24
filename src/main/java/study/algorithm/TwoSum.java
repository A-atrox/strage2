package study.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import static java.lang.Math.max;

public class TwoSum {
    public static void main(String[] args) {
// 两数之和
//        int nums [] = new int[]{3,2,4,10,20};
//        int target = 24;
//        System.out.println(Arrays.toString(twoSum2(nums, target)));

//      两数相加
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(7);
//        ListNode l3 = addTwoNumbers(l1, l2);
//        System.out.print(l3);

        // 无重复最长子串
//        System.out.println(lengthOfLongestSubstring("abcadef"));

        // 求两个数组的中位数
//        int[] nums1 = new int[]{1, 4, 9, 10};
//        int[] nums2 = new int[]{2, 5, 11, 10};
//        System.out.println(findMedianSortedArrays(nums1, nums2));

        //最长回文子串
    }

    public static int[] twoSum(int[] nums, int target) { // 解法一 暴力
        int index[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (nums[i] + nums[k] == target && i != k) {
                    index = new int[]{i, k};
                    return index;
                }
            }
        }
        return index;
    }

    public static int[] twoSum2(int[] nums, int target) { // 解法2 hashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                int index[] = new int[]{hashMap.get(target - nums[i]), i};
                return index;
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { // 因为是基于l1来做加法的，所以如果l1没有了，就把l2剩余的加在l1的后面
            return l2;
        }
        if (l2 == null) {//如果 l2 为空了 l1的末尾大于10就必须做个进位使l2不为空放个0，才可以执行判断体下面的函数
            if (l1.val >= 10) {
                l2 = new ListNode(0);
                l2.next = null;
            } else {
                return l1;
            }
        }
        int x = l1.val + l2.val;
        l1.val = x % 10;
        if (x >= 10) {
            if (l1.next == null) {
                l1.next = new ListNode(1);

            } else {
                l1.next.val++;
            }
        }
        l1.next = addTwoNumbers(l1.next, l2.next); //重要部分 递归 用于重新连接携带着新的值的l1节点
        return l1;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxStr = 0;
        LinkedList<Character> Str = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            while (Str.contains(s.charAt(i))) {
                Str.remove();
            }
            Str.add(s.charAt(i));
            maxStr = max(maxStr, Str.size());
        }
        return maxStr;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return (double) (nums2[(nums2.length + 1) / 2 - 1] + nums2[(nums2.length + 2) / 2 - 1]) / 2;
        }
        if (nums2 == null) {
            return (double) (nums1[(nums1.length + 1) / 2 - 1] + nums1[(nums1.length + 2) / 2 - 1]) / 2;
        }
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums3.length; i++) {
            if (i < nums1.length) {
                nums3[i] = nums1[i];
            } else {
                nums3[i] = nums2[i - nums1.length];
            }
        }
        Arrays.sort(nums3);
        return (double) (nums3[(nums3.length + 1) / 2 - 1] + nums3[(nums3.length + 2) / 2 - 1]) / 2;
    }

    public static  String longestPalindrome(String s){

        return null;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = String.valueOf(val);
        ListNode temp = next;
        while (temp != null) {
            str += "->" + temp.val;
            temp = temp.next;
        }
        return str;
    }
}

