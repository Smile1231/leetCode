//给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
//
// 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。 
//
// 
// 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。 
// 再例如，[1, 1, 2, 5, 7] 不是等差序列。 
// 
//
// 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。 
//
// 
// 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。 
// 
//
// 题目数据保证答案是一个 32-bit 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,4,6,8,10]
//输出：7
//解释：所有的等差子序列为：
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// 示例 2： 
//
// 
//输入：nums = [7,7,7,7,7]
//输出：16
//解释：数组中的任意子序列都是等差子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 动态规划 
// 👍 127 👎 0


package com.cy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlicesIiSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            // 每个 f[i] 均为哈希表，哈希表键值对为 {d : cnt}
            // d : 子序列差值
            // cnt : 以 nums[i] 为结尾，且差值为 d 的子序列数量
            List<Map<Long, Integer>> f = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Map<Long, Integer> cur = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    Long d = nums[i] * 1L - nums[j];
                    Map<Long, Integer> prev = f.get(j);
                    int cnt = cur.getOrDefault(d, 0);
                    cnt += prev.getOrDefault(d, 0);
                    cnt++;
                    cur.put(d, cnt);
                }
                f.add(cur);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                Map<Long, Integer> cur = f.get(i);
                for (Long key : cur.keySet()) ans += cur.get(key);
            }
            int a1 = 0, an = n - 1;
            int cnt = (a1 + an) * n / 2;
            return ans - cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
