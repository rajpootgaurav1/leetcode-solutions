package com.leetcode.solution.topic.heap;

import java.util.PriorityQueue;

public class FinalArray3564 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int val = a[0] - b[0];
            if (val == 0) {
                return a[1] - b[1];
            }
            return val;
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            pq.offer(new int[]{poll[0] * multiplier, poll[1]});
        }
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            nums[poll[1]] = poll[0];
        }
        return nums;
    }
}
