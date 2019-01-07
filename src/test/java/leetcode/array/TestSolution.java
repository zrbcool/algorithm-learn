package leetcode.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class TestSolution {
    private Solution solution = new Solution();

    @Test
    public void missingNumber() {
        System.out.println(solution.missingNumber(new int[]{1,0}));
    }

    @Test
    public void findShortestSubArray() {
//        System.out.println(solution.findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(solution.findShortestSubArray(new int[]{2,1}));
    }

    @Test
    public void fairCandySwap() {
        System.out.println(JSON.toJSONString(solution.fairCandySwap(new int[]{2}, new int[]{1,3})));
    }

    @Test
    public void largeGroupPositions() {
        System.out.println(JSON.toJSONString(solution.largeGroupPositions("abcdddeeeeaabbbcd")));
    }

    @Test
    public void twoSum() {
        System.out.println(JSON.toJSONString(solution.twoSum(new int[]{2,3,4}, 6)));
    }
}
