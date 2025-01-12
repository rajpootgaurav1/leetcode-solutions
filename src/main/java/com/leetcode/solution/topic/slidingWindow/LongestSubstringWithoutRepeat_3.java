package com.leetcode.solution.topic.slidingWindow;

public class LongestSubstringWithoutRepeat_3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int ans = 1;
        int right = 1;
        int count = 1;
        while(right < s.length()) {
            if(s.substring(left, right).contains(String.valueOf(s.charAt(right)))) {
                ans = Math.max(ans, count);
                left = s.substring(left, right).indexOf(s.charAt(right)) + left +1;
                count = right - left + 1;
            }else {
                count++;
            }
            right++;
        }
        return Math.max(ans, count);
    }
}
