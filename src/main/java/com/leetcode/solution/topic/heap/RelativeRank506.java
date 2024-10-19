package com.leetcode.solution.topic.heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRank506 {
    Logger log = LoggerFactory.getLogger(this.getClass());

    public String[] findRelativeRanks(int[] score) {
        String[] strArray = new String[score.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for( int n : score) {
            queue.add(n);
            map.put(n,i);
            i++;
            log.info("added number {} to the queue", n);
        }
        int k = 0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            k++;
           int index = map.get(poll);
            if(k>3){
                strArray[index] = String.valueOf(k);
            }
           if(k ==1){
               strArray[index] = "Gold Medal";
           }else if (k == 2){
               strArray[index] = "Silver Medal";
           } else if (k==3) {
               strArray[index] = "Bronze Medal";
           }
        }

        return strArray;

    }
}
