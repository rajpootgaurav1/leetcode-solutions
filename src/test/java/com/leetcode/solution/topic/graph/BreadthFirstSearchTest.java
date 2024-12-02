package com.leetcode.solution.topic.graph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class BreadthFirstSearchTest {
    @InjectMocks
    BreadthFirstSearch leetcode;


    @Test
    void testDFSSmallVal() {
        int[][] array = {{0, 1}, {1,2}, {3, 2}};
        List<Integer> undirectedList = leetcode.bfsUndirected(4, array, 0);
        assertEquals(4, undirectedList.size());
        assertEquals(0, undirectedList.get(0));
    }

    @Test
    void testUndirectedDFS() {
        int[][] array = {{0, 1}, {1, 4}, {1, 5}, {0, 2}, {2, 3}, {2, 6}, {6, 7}, {3, 7}};
        List<Integer> undirectedList = leetcode.bfsUndirected(8, array, 0);
        assertEquals(8, undirectedList.size());
        assertEquals(0, undirectedList.get(0));
    }

    @Test
    void testUndirected() {
        int[][] array = {{0, 1}, {1, 4}, {1, 5}, {0, 2}, {2, 3}, {2, 6}, {6, 7}, {3, 7}};
        List<Integer> undirectedList = leetcode.bfsUndirected(8, array, 1);
        assertEquals(8, undirectedList.size());
        assertEquals(1, undirectedList.get(0));
    }
}