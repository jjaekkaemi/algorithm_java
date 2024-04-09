package programmers.dfs_bfs;
import java.util.Queue;
import java.util.LinkedList;

public class GamemapShortestdistance {
    class Point {
        private int x;
        private int y;
        private int d;

        public Point(int x,int y,int d){
            this.x = x ;
            this.y = y ;
            this.d = d ;
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public int getD() { return d; }
    }
    class Solution {
        public int solution(int[][] maps) {
            int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            int N = maps.length;
            int M = maps[0].length;
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0,0,1));


            while(!queue.isEmpty()){
                Point point = queue.poll();
                int x = point.getX();
                int y = point.getY();
                int d = point.getD();
                if(x == N-1 && y == M-1){
                    return d;
                }
                for(int[] m : move){
                    int dx = m[0]+x;
                    int dy = m[1]+y;
                    if(0<=dx && dx<N && 0<=dy && dy<M && maps[dx][dy]==1) {
                        maps[dx][dy] = 0;
                        queue.offer(new Point(dx, dy, d+1));
                    }
                }
            }
            return -1;
        }
    }
}
