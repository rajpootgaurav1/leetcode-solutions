package com.leetcode.solution.topic.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FinalArray3564Test {

    @Test
    void testFinalArray() {
        FinalArray3564 solution = new FinalArray3564();
        int[] grid = {2,1,3,5,6};
        int[] expected = {8,4,6,5,6};
        assertArrayEquals(expected, solution.getFinalState(grid, 5, 2), "value not matching");
    }


}
