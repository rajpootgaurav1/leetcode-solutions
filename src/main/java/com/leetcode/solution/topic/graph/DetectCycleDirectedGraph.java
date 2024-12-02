package com.leetcode.solution.topic.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DetectCycleDirectedGraph {

    public boolean detectCycle(int n, int[][] edges){

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i =0; i <n; i++){//to test the disconnected component as well
            if(!visited[i] && isCycle(graph, i, visited, st)){
                return true;
            }
        }

        return false;

    }

    private boolean isCycle(List<List<Integer>> graph, int node, boolean[] visited, Stack<Integer> stack) {
        if(graph.get(node).contains(node)) return true; //self cycle case
        visited[node] = true;
        stack.push(node);
        for(int neighbour : graph.get(node)){
            if(stack.contains(neighbour)) return true;
            if(!visited[neighbour]){
                if(isCycle(graph, neighbour, visited, stack)){
                return true;}
            }
        }
        stack.pop();
        return false;
    }
}
