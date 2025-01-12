package com.leetcode.solution.topic.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeat3Test {

    @Test
    void lengthOfLongestSubstring() {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeat_3 leetcode = new LongestSubstringWithoutRepeat_3();
        int output = leetcode.lengthOfLongestSubstring(s);
        assertEquals(3, output);
    }

    @Test
    void lengthOfLongestSubstringSpace() {
        String s = " ";
        LongestSubstringWithoutRepeat_3 leetcode = new LongestSubstringWithoutRepeat_3();
        int output = leetcode.lengthOfLongestSubstring(s);
        assertEquals(1, output);
    }

}
