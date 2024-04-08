package programmers.dfs_bfs;

public class TargetNumber {
    public int dfs(int idx, int[] numbers, int sum, int target){
        if(idx==numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        return dfs(idx+1, numbers, sum+numbers[idx], target)+dfs(idx+1, numbers, sum-numbers[idx], target);
    }
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, 0, target);
    }
}
