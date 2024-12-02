package com.leetcode.solution.topic.graph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DetectCycleDirectedGraphTest {

    @InjectMocks
    DetectCycleDirectedGraph leetcode;

    @Test
    void testGraphAcyclic() {
        int[][] array = {{0, 1}, {0, 2}, {1, 2}};
        assertFalse(leetcode.detectCycle(3, array));
    }

    @Test
    void testGraphCyclic() {
        int[][] array = {{1, 0}, {0, 1}};
        assertTrue(leetcode.detectCycle(2, array));
    }

    @Test
    void testGraphSelfCyclic() {
        int[][] array = {{1, 0}, {0, 0}};
        assertTrue(leetcode.detectCycle(2, array));
    }


    @Test
    public void testSimpleGraphWithoutCycle() {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}
        };
        assertFalse(leetcode.detectCycle(n, edges), "Graph with no cycle should return false.");
    }

    @Test
    public void testGraphWithCycle() {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 1}
        };
        assertTrue(leetcode.detectCycle(n, edges), "Graph with a cycle should return true.");
    }

    @Test
    public void testDisconnectedGraphWithoutCycle() {
        int n = 5;
        int[][] edges = {
                {0, 1}, {2, 3}
        };
        assertFalse(leetcode.detectCycle(n, edges), "Disconnected graph with no cycle should return false.");
    }

    @Test
    public void testDisconnectedGraphWithCycle() {
        int n = 6;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}, {3, 4}
        };
        assertTrue(leetcode.detectCycle(n, edges), "Disconnected graph with a cycle should return true.");
    }

    @Test
    public void testGraphWithSelfLoop() {
        int n = 3;
        int[][] edges = {
                {0, 1}, {1, 1}
        };
        assertTrue(leetcode.detectCycle(n, edges), "Graph with a self-loop should return true.");
    }

    @Test
    public void testGraphWithIsolatedNodes() {

        int n = 3;
        int[][] edges = {};
        assertFalse(leetcode.detectCycle(n, edges), "Graph with isolated nodes should return false.");
    }

    @Test
    public void testGraphWithMultipleComponentsAndCycle() {
        int n = 8;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}, // First component with a cycle
                {3, 4}, {4, 5}, {6, 7}  // Other components without cycles
        };
        assertTrue(leetcode.detectCycle(n, edges), "Graph with a cycle in one component should return true.");
    }

    @Test
    public void testGraphWithNoEdges() {
        int n = 5;
        int[][] edges = {};
        assertFalse(leetcode.detectCycle(n, edges), "Graph with no edges should return false.");
    }

}