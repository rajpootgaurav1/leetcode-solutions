package com.leetcode.solution.topic.stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class Calculator2_227Test {

    @InjectMocks
    Calculator2_227 leetcode;

    @Test
    void testCalculator(){
        assertEquals(4,leetcode.calculate( "5/2*2"));
        assertEquals(5,leetcode.calculate( "5*2/2"));
        assertEquals(7,leetcode.calculate( "3+2*2"));
        assertEquals(1,leetcode.calculate( " 3/2 "));
        assertEquals(-24,leetcode.calculate( "1*2-3/4+5*6-7*8+9/10"));
    }


}