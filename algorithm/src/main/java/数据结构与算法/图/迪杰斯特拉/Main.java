package 数据结构与算法.图.迪杰斯特拉;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //把邻接矩阵 转换成 邻接表
        List<List<Pair>> graph = new ArrayList<List<Pair>>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Pair(succProb[i], e[1]));
            graph.get(e[1]).add(new Pair(succProb[i], e[0]));
        }
        //优先队列
        PriorityQueue<Pair> que = new PriorityQueue<>();
        double[] prob = new double[n];

        que.offer(new Pair(1, start));
        prob[start] = 1;
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            double pr = pair.probability;
            int node = pair.node;
            if (pr < prob[node]) {
                continue;
            }
            for (Pair pairNext : graph.get(node)) {
                double prNext = pairNext.probability;
                int nodeNext = pairNext.node;
                if (prob[nodeNext] < prob[node] * prNext) {
                    prob[nodeNext] = prob[node] * prNext;
                    que.offer(new Pair(prob[nodeNext], nodeNext));
                }
            }
        }
        return prob[end];
    }
}

//
class Pair implements Comparable<Pair> {
    double probability;//概率
    int node;//节点

    public Pair(double probability, int node) {
        this.probability = probability;
        this.node = node;
    }

    public int compareTo(Pair pair2) {
        if (this.probability == pair2.probability) {
            return this.node - pair2.node;
        } else {
            return this.probability - pair2.probability > 0 ? -1 : 1;
        }
    }
}
