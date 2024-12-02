package com.leetcode.solution.topic.graph;

import java.util.ArrayList;
import java.util.List;

//iterate the graph depth first and print all the elements in the graph
public class DepthFirstSearch {

    public List<Integer> dfsUndirected(int n, int[][] edges, int start) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> dfsList = new ArrayList<>();

        dfs(graph, start, visited, dfsList);
        System.out.println(dfsList);
        return dfsList;

    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> dfsList) {
        dfsList.add(node);
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited, dfsList);
            }
        }
    }


}
