package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TownLoad {
    class Edge {
        int n;
        int d;

        public Edge(int n, int d){
            this.n = n;
            this.d = d;
        }
    }

    class Solution {
        public int solution(int N, int[][] road, int K){
            int answer = 0;
            ArrayList<Edge>[] graph = new ArrayList[N+1];
            boolean[] visited = new boolean[N+1];
            for(int i = 1 ; i<=N ; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] r : road) {
                int town = r[0];
                int neig = r[1];
                int distance = r[2];

                graph[town].add(new Edge(neig, distance));
                graph[neig].add(new Edge(town, distance));
            }

            Queue<Edge> queue = new LinkedList<>();
            queue.offer(new Edge(1,0));

            while(!queue.isEmpty()){
                Edge edge = queue.poll();
                int node = edge.n;
                int distance = edge.d;
                if(distance<K+1) visited[node] = true;
                for(Edge e : graph[node]){
                    int new_d = distance+e.d;
                    if(new_d<K+1) queue.offer(new Edge(e.n, new_d));
                }
            }
            for(boolean b : visited){
                if(b) answer++;
            }
            return answer;
        }
    }
}
