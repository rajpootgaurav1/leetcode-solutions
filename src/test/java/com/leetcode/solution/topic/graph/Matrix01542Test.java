package com.leetcode.solution.topic.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix01542Test {


    @Test
    void testAllRottenOranges() {
        Matrix01542 solution = new Matrix01542();
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
     assertArrayEquals(grid ,solution.updateMatrix(grid));
    }


    @Test
    void testAllRottenOranges2() {
        Matrix01542 solution = new Matrix01542();
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        // Define the updated expected result
        int[][] expected = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };

        assertArrayEquals(expected ,solution.updateMatrix(grid));
    }


}
