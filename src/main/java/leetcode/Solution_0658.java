package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_0658 {
    /**
     * 找到 K 个最接近的元素
     * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5], k=4, x=3
     * 输出: [1,2,3,4]
     *
     *
     * 示例 2:
     *
     * 输入: [1,2,3,4,5], k=4, x=-1
     * 输出: [1,2,3,4]
     *
     *
     * 说明:
     *
     * k 的值为正数，且总是小于给定排序数组的长度。
     * 数组不为空，且长度不超过 104
     * 数组里的每个元素与 x 的绝对值不超过 104
     *
     *
     * 更新(2017/9/19):
     * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
     */

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        if (arr[0] >= x) {
            return list.subList(0, k);
        }
        else if (arr[arr.length -1] < x) {
            return list.subList(arr.length - 1 - k, arr.length - 1);
        }
        else {
            /**
             * 二分查找比x大的第一个数下标m，则结果在[m - k, m + k]之间
             */
            int L = 0;
            int R = arr.length - 1;
            int idx = -1;
            while (L <= R) {
                int m = L + ((R - L) >> 1);
                if (arr[m] <= x) {
                    L = m + 1;
                } else {
                    R = m - 1;
                }
            }
            idx = L;

            int left = Math.max(idx - k, 0);
            int right = Math.min(idx + k, arr.length - 1);

            while (right - left > k - 1) {
                if (x - arr[left] > arr[right] - x) {
                    left++;
                }
                else if (x - arr[left] <= arr[right] - x) {
                    right--;
                }
            }
            return list.subList(left, right + 1);
        }
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int L = 0, R = arr.length - 1;
        int idx = -1;
        while (L <= R) {
            int m = L + ((R - L) >> 1);
            if (arr[m] == x) {
                idx = m;
                break;
            }
            else if ((arr[m] > x && m == 0) || (arr[m] < x && m == arr.length - 1)) {
                idx = m;
                break;
            }
            else if (m == 0) {
                L = m + 1;
            }
            else if (m == arr.length - 1) {
                R = m - 1;
            }
            else if (arr[m] > x && arr[m + 1] < x) {
                if (Math.abs(arr[m] - x) <= Math.abs(arr[m + 1] - x)) {
                    idx = m;
                } else {
                    idx = m + 1;
                }
                break;
            }
            else if (arr[m] > x) {
                R = m - 1;
            }
            else {
                L = m + 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        int left = idx - 1;
        int right = idx + 1;
        list.add(arr[idx]);
        while (count < k - 1) {
            if (left >= 0 && right <= arr.length - 1) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    list.add(arr[left]);
                    left--;
                } else {
                    list.add(arr[right]);
                    right++;
                }
                count++;
            }
            else if (left >= 0) {
                list.add(arr[left]);
                left--;
                count++;
            }
            else {
                list.add(arr[right]);
                right++;
                count++;
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        /**
         * [0,0,1,2,3,3,4,7,7,8]
         * 3
         * 5
         */
        System.out.println(new Solution_0658().findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5));
    }
}
