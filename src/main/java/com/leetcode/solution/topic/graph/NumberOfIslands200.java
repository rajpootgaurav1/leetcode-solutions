package com.leetcode.solution.topic.graph;

public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ('0' == grid[i][j]) {
                    visited[i][j] = true;
                    continue;
                }
                if (!visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }


    private boolean dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return false;
        }
        visited[i][j] = true;
        return dfs(grid, i + 1, j, visited) ||
                dfs(grid, i, j + 1, visited) ||
                dfs(grid, i - 1, j, visited) ||
                dfs(grid, i, j - 1, visited);
    }
}
