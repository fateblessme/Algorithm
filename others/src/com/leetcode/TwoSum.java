package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author YangBo
 * @date 2019/04/23
 */
public class TwoSum {

    public static int[] test1(int[] nums, int target) {

        int[] rst = new int[2];

        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
//            if (target-nums[i]==)

        }

        return rst;

    }

    /**
     * 优化版
     * 时间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] test2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 7, 11, 15};
        int target = 14;
        System.out.println(Arrays.toString(test2(nums, target)));
    }
}
