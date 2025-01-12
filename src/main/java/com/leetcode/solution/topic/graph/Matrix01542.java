package com.leetcode.solution.topic.graph;

import java.util.ArrayDeque;
import java.util.List;

public class Matrix01542 {

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(List.of(i, j));
                }
            }
        }
        bfs(mat, visited, queue, result);

        return result;
    }

    private void bfs(int[][] mat, boolean[][] visited, ArrayDeque<List<Integer>> queue, int[][] result) {
        while (!queue.isEmpty()) {
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            List<Integer> val = queue.pollFirst();
            int i = val.getFirst();
            int j = val.getLast();
            for (int[] step : directions) {
                int newI = i + step[0];
                int newJ = j + step[1];
                if (newI < mat.length && newI >= 0 && newJ >= 0 && newJ < mat[0].length && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    result[newI][newJ] = result[i][j] +1;
                    queue.add(List.of(newI, newJ));
                }
            }

        }

    }
}
