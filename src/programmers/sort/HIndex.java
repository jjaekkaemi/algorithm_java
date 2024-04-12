package programmers.sort;
import java.util.*;
public class HIndex {

    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);
            for(int i = citations.length-1 ; i>-1 ; i--){
                int h = citations[i];
                if(h>answer) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
