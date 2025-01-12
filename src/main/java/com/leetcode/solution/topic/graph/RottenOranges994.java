package com.leetcode.solution.topic.graph;

import java.util.ArrayDeque;
import java.util.List;

public class RottenOranges994 {

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int freshOranges = 0;
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(List.of(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if(freshOranges ==0) return 0;

//        for (int[] ints : grid) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (ints[j] == 1) {
//                    return -1;
//                }
//            }
//        }
        return bfs(grid, visited, queue, freshOranges);
    }

    private int bfs(int[][] grid, boolean[][] visited, ArrayDeque<List<Integer>> queue, int freshOranges) {

        while (!queue.isEmpty()) {
            List<Integer> list = queue.pollFirst();
            int x = list.get(0);
            int y = list.get(1);
            int answer = list.get(2);
//            if (x >= grid.length || x < 0 || y < 0 || y >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
//                return 0;
//            }
//            visited[x][y] = true;
//            if(grid[x][y] ==1){
//                return -1;
//            }
            if (!visited[x][y] && grid[x][y] == 2) {
                visited[x][y] = true;
//                boolean increase = false;
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    freshOranges--;
                    queue.add(List.of(x + 1, y, answer + 1));
                }
                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    freshOranges--;
                    queue.add(List.of(x - 1, y, answer + 1));

                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    freshOranges--;
                    queue.add(List.of(x, y + 1, answer + 1));
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    freshOranges--;
                    queue.add(List.of(x, y - 1, answer + 1));
                }
                if(freshOranges==0) return answer+1;
            }
        }
        return -1;
    }
}
