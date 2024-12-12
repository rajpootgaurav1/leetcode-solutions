package com.leetcode.solution.topic.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RottenOranges994Test {

    @Test
    void testAllRottenOranges() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        assertEquals(0, solution.orangesRotting(grid), "All oranges are already rotten.");
    }

    @Test
    void testAllFreshOranges() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid), "All oranges are fresh, so they will never rot.");
    }

    @Test
    void testMixedOranges() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        assertEquals(4, solution.orangesRotting(grid), "It takes 4 minutes for all oranges to rot.");
    }

    @Test
    void testIsolatedFreshOranges() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {2, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid), "Some fresh oranges are isolated and will never rot.");
    }

    @Test
    void testEmptyGrid() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {};
        assertEquals(-1, solution.orangesRotting(grid), "Empty grid should return -1.");
    }

    @Test
    void testSingleFreshOrange() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {1}
        };
        assertEquals(-1, solution.orangesRotting(grid), "A single fresh orange will never rot.");
    }

    @Test
    void testSingleRottenOrange() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {2}
        };
        assertEquals(0, solution.orangesRotting(grid), "A single rotten orange needs no time to rot.");
    }

    @Test
    void testMixedWithWalls() {
        RottenOranges994 solution = new RottenOranges994();
        int[][] grid = {
                {2, 1, 0, 1},
                {1, 0, 1, 1},
                {0, 1, 2, 1}
        };
        assertEquals(3, solution.orangesRotting(grid), "Walls prevent spreading, but all reachable oranges rot in 3 minutes.");
    }
}
