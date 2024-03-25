/*
import java.util.ArrayList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class PrimAlgorithm {
    private int V; // 图中顶点的数量
    private List<List<Edge>> adjacencyList;

    public PrimAlgorithm(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge1 = new Edge(source, destination, weight);
        Edge edge2 = new Edge(destination, source, weight);
        adjacencyList.get(source - 1).add(edge1);
        adjacencyList.get(destination - 1).add(edge2);
    }

    public int calculateMinimumSpanningTree() {
        boolean[] visited = new boolean[V]; // 记录顶点是否已经加入最小生成树

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(); // 存储边的优先队列
        int minimumCost = 0; // 最小生成树的权值

        // 将第一个顶点标记为已访问
        visited[0] = true;

        // 将第一个顶点的所有边加入优先队列
        for (Edge edge : adjacencyList.get(0)) {
            priorityQueue.offer(edge);
        }

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            int currentVertex = currentEdge.destination;

            // 如果顶点已经访问过，则继续下一次循环
            if (visited[currentVertex - 1]) {
                continue;
            }

            // 将顶点标记为已访问
            visited[currentVertex - 1] = true;

            // 将边的权值加入最小生成树的权值
            minimumCost += currentEdge.weight;

            // 将当前顶点的所有边加入优先队列
            for (Edge edge : adjacencyList.get(currentVertex - 1)) {
                if (!visited[edge.destination - 1]) {
                    priorityQueue.offer(edge);
                }
            }
        }

        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int V = input.nextInt(); // 顶点的数量
        int m=input.nextInt();
        PrimAlgorithm prim = new PrimAlgorithm(V);
        for (int i = 0; i <m ; i++) {
            int a=input.nextInt();
            int b=input.nextInt();
            int c=input.nextInt();
            prim.addEdge(a,b,c);
        }
        int minimumCost = prim.calculateMinimumSpanningTree();
        System.out.println( minimumCost);
    }
}*/
