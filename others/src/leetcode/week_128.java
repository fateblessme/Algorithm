package leetcode;

public class week_128 {

    /**
     * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。
     * 注意，除 N = 0 外，任何二进制表示中都不含前导零。
     * <p>
     * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
     * <p>
     * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
     */
    static int bitwiseComplement(int n) {
        int i;
        for (i = 2; i <= n; i <<= 1) ;
        return i - 1 - n;
    }

    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * <p>
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
     * 形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
     */
    static boolean can(int[] weights, int D, int cap) {
        int cd = 0;
        int ans = 1;
        for (int i = 0; i < weights.length; i++) {
            if (cd + weights[i] > cap) {
                ans++;
                cd = 0;
            }
            cd += weights[i];
        }
        return ans <= D;
    }

    static int shipWithinDays(int[] weights, int D) {
        int lo = weights[0], hi = 0;
        for (int i = 0; i < weights.length; i++) {
            lo = Math.max(weights[i], lo);
            hi += weights[i];
        }
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (can(weights, D, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    /**
     * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
     */
    public static int N;

    static int count(int mask, long num) {
        if (num > N) return 0;

        int ret = 1;
        for (int nd = num == 0 ? 1 : 0; nd < 10; nd++) {
            if (((mask >> nd) & 1) == 0) {
                ret += count(mask | (1 << nd), num * 10 + nd);
            }
        }
        return ret;
    }

    public int numDupDigitsAtMostN(int _N) {
        N = _N;
        return N + 1 - count(0, 0);
    }
}
