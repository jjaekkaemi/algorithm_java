package programmers.heap;
import java.util.*;
public class MoreSpicy {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int s : scoville){
                queue.offer(s);
            }
            while(true){
                int first = queue.poll();
                if(first>=K) break;
                if(queue.size()==0) {
                    answer = -1;
                    break;
                }
                int second = queue.poll();
                int mix = first + second * 2;
                answer++;
                queue.offer(mix);
            }
            return answer;
        }
    }
}
