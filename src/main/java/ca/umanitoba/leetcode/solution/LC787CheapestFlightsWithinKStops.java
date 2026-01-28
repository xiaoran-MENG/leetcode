package ca.umanitoba.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LC787CheapestFlightsWithinKStops {
    private static class Node {
        private int key, cost;

        Node(int key, int cost) {
            this.key = key;
            this.cost = cost;
        }
    }

    private static class HeapNode implements Comparable<HeapNode> {
        private int key, cost, edges;

        HeapNode(int key, int cost, int edges) {
            this.key = key;
            this.cost = cost;
            this.edges = edges;
        }

        @Override
        public int compareTo(HeapNode o) {
            return cost - o.cost;
        }
    }
    
    private static final int MAX = Integer.MAX_VALUE / 2;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var graph = new HashMap<Integer, List<Node>>();
        // 存已知节点在指定状态下(edges)的最优目标状态(cost)
        // 行:节点索引 | 列:指定状态（可扩展）| [行][列]：目标状态
        // 存储的节点有两种：
        // 1. 出堆后被展开过的
        // 2. 在堆里即将被弹出的 
        // 每个值先初始化为目标状态的最差值，而在后续比较中逐渐被更新为最优值
        // k: 进入节点经过的节点数 | k + 1: 进入节点经过的边数 | k + 2: [0 ~ k + 1]
        var costs = new int[n][k + 2]; 
        // 存状态有效的节点（由入堆的剪枝逻辑保证），根据目标状态排序，优先弹出全局目标状态最优的节点
        // 若有key一样的节点同时存在，保证第一个被弹出的该节点的目标状态一定最优
        var heap = new PriorityQueue<HeapNode>();
        for (var flight : flights) 
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>())
                .add(new Node(flight[1], flight[2]));
        for (var cost : costs) Arrays.fill(cost, MAX);
        costs[src][0] = 0;
        heap.offer(new HeapNode(src, 0, 0));
        while (!heap.isEmpty()) {
            var node = heap.poll();
            // 保证：
            // 1. 节点的指定状态一定有效，因为只有有效节点能入堆
            // 2. 该节点的目标状态一定是最优
            if (node.key == dst) return node.cost;
            if (node.cost != costs[node.key][node.edges]) continue;
            var children = graph.getOrDefault(node.key, Collections.emptyList());
            for (var child : children) {
                // 状态传递包括：指定状态和目标状态
                int edges = node.edges + 1, cost = node.cost + child.cost;
                // 剪枝（性能优化）：
                // 1. 判断节点的指定状态是否有效
                // 2. 在指定状态有效的情况下，节点目标状态在该在指定状态下优于当前的值
                if (edges > k + 1 || cost >= costs[child.key][edges]) continue;
                costs[child.key][edges] = cost;
                heap.offer(new HeapNode(child.key, cost, edges));
            }
        }
        return -1;
    }

}
