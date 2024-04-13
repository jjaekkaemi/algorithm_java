package programmers.stack_queue;
import java.util.*;
public class HateSameNumber {
    public class Solution {
        public int[] solution(int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();

            int num = -1 ;
            for(int a : arr){
                if(num!=a) list.add(a);
                num = a;
            }
            int[] answer = new int[list.size()];
            for(int i = 0 ; i<answer.length ; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
