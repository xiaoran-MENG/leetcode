package ca.umanitoba.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LC743NetworkDelayTime {

    private static final int MAX = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node> {
        private int key, cost;

        Node(int key, int cost) {
            this.key = key;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = new HashMap<Integer, List<Node>>();
        var heap = new PriorityQueue<Node>();
        var costs = new int[n + 1];

        for (var time : times)
            graph.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new Node(time[1], time[2]));

        Arrays.fill(costs, MAX);

        costs[k] = 0;
        heap.offer(new Node(k, 0));
        while (!heap.isEmpty()) {
            var node = heap.poll();
            if (node.cost != costs[node.key]) continue;
            var children = graph.getOrDefault(node.key, Collections.emptyList());
            for (var child : children) {
                int cost = node.cost + child.cost;
                if (cost >= costs[child.key]) continue;
                costs[child.key] = cost;
                heap.offer(new Node(child.key, cost));
            }
        }

        var result = Integer.MIN_VALUE;
        for (int i = 1; i < costs.length; i++) {
            if (costs[i] == MAX) return -1;
            result = Math.max(result, costs[i]);
        }

        return result;
    }
}
