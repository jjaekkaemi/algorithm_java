package programmers.stack_queue;
import java.util.*;
public class FunctionDevelopment {
    class Solution {
        public int calDeployDay(int progress, int speed){
            int remain_progress = 100-progress;
            int deploy_day = remain_progress/speed;
            if((remain_progress%speed)!=0) deploy_day++;
            return deploy_day;
        }
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> answer_list = new ArrayList<>();
            int idx = 1 ;
            int deploy_day = calDeployDay(progresses[0], speeds[0]);
            int deploy_idx = 0;
            answer_list.add(1);

            while(idx<progresses.length){
                int next_deploy_num = calDeployDay(progresses[idx], speeds[idx]);
                if(deploy_day<next_deploy_num){
                    answer_list.add(0);
                    deploy_idx++;
                    deploy_day = next_deploy_num;
                }
                answer_list.set(deploy_idx, answer_list.get(deploy_idx)+1);
                idx++;
            }
            int[] answer = new int[answer_list.size()];
            for(int i = 0 ; i<answer.length ; i++){
                answer[i] = answer_list.get(i);
            }
            return answer;
        }
    }
}
