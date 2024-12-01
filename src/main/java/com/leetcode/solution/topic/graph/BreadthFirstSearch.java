package com.leetcode.solution.topic.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BreadthFirstSearch {


    public List<Integer> bfsUndirected(int n, int[][] edges, int start) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        List<Integer> bfsList = new ArrayList<>();
        bfs(graph, start, visited, bfsList);
        System.out.println(bfsList);
        return bfsList;

    }
    private void bfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> bfsList) {
        Deque<Integer> deque = new ArrayDeque<>();
        bfsList.add(node);
        deque.add(node);
        visited[node] = true;
        while (!deque.isEmpty()) {
            int val = deque.pollFirst();
            for (int neighbour : graph.get(val)) {
                if (!visited[neighbour]) {
                    bfsList.add(neighbour);
                    visited[neighbour] = true;
                    deque.add(neighbour);
                }
            }
        }
    }
}
