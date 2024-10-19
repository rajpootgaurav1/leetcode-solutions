package com.leetcode.solution.topic.heap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class RelativeRank506Test {

    @InjectMocks
    RelativeRank506 relativeRank506;
    @Test
    void testRank(){
        int[] input = new int[5];
        input[0] = 5;
        input[1]= 4;
        input[2]= 3;
        input[3] = 2;
        input[4] = 1;
        String[] ranks = relativeRank506.findRelativeRanks(input);

        assertEquals("Gold Medal", ranks[0]);
    }


}