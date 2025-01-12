package com.leetcode.solution.topic.binarySearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class KokoEatingBanana875 {


    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length ==1) return (int) totalTimeTaken(piles, h);
        int left = 1;
        int right = 0;
        OptionalInt optionalInt = Arrays.stream(piles).max();
        if(optionalInt.isPresent()) {
            right = optionalInt.getAsInt();
        }
        int answer = 0;

        while(left <= right) {
            System.out.println("left is " + left + " right is " + right);
            int mid = left + (right - left)/2;
            long timeToEatBananas = totalTimeTaken(piles, mid);
            System.out.println("mid is " + mid + " timeToEatBananas is " + timeToEatBananas);
            if(timeToEatBananas <= h){
                answer = mid;
                right = mid- 1;
            }else {
                left = mid + 1;
            }

        }
        return answer;
    }

    public long totalTimeTaken(int[] piles , int denominator) {
        long hour = 0;
        for(int pile : piles) {
            if(pile < denominator) {
                hour++;
            } else {
                hour += Math.ceilDiv(pile , denominator);
            }
        }
        return hour;
    }
}
