package leetcode.array;

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
}
