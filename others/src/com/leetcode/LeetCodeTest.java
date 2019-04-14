package com.leetcode;

/**
 * LeetCode 测试类
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class LeetCodeTest {
    public static void main(String[] args) {

        shipWithinDays(null, 20);
    }

    static int shipWithinDays(int[] weights, int D) {
        String str = "";
        int NumChange;
        int re = 0;
        int[] num = null;
        for (Integer i = 1; i <= D; i++) {
            str = i.toString();
            num = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                Character ch = str.charAt(j);
                num[j] = Integer.parseInt(ch.toString());
            }
            for (int index = 0; index < num.length; index++) {
                while (num[index] != index) {
                    if (num[index] == num[num[index]]) {
                        re++;
                        break;
                    } else {
                        NumChange = num[num[index]];
                        num[num[index]] = num[index];
                        num[index] = NumChange;
                    }
                }
            }
        }

        return re;
    }

}
