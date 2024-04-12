package test;

import java.util.Arrays;

public class ScoreWinner {
    class Solution{
        public int solution(int[] A, int[] B){
            int answer = 0 ;
            Arrays.sort(A);
            Arrays.sort(B);
            int start = 0, end = (B.length)-1;
            for(int i = A.length-1 ;i>-1 ; i--){
                int a = A[i], b = 0;
                if(A[i]>=B[end]) b = B[start++];
                else b = B[end--];
                if(a<b) answer++;
            }
            return answer;
        }
    }
}
