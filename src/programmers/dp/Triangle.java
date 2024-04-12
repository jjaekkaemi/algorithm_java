package programmers.dp;
public class Triangle {
    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int last = triangle.length;
            int[][] dp = new int[last][];
            for(int i = 0 ; i<last ; i++){
                dp[i] = new int[triangle[i].length];
            }

            dp[0][0] = triangle[0][0];
            for(int i = 1 ; i<last ; i++){
                for(int j = 0 ; j<triangle[i].length ; j++){
                    int left = j == 0 ? 0 : dp[i-1][j-1];
                    int right = j == i ? 0 : dp[i-1][j];

                    dp[i][j] = Math.max(left, right)+triangle[i][j];
                }
            }
            for(int i = 0 ; i<last ; i++){
                answer = Math.max(answer, dp[last-1][i]);
            }
            return answer;
        }
    }
}
