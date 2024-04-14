package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Contests {
    final static int MAX = 21;
    public int[] solution(int[][] contests, int k, int p){
        PriorityQueue<Integer>[] list = new PriorityQueue[MAX]; // ArrayList -> PriorityQueue
        for(int i = 0 ; i<MAX ; i++){
            list[i] = new PriorityQueue<>();
        }

        for(int i = 0 ; i<contests.length ; i++){
            int num = 0 ;
            for(int c : contests[i]){
                if(p>=c){
                    num++;
                }
            }
            list[num].add(i);
        }

        ArrayList<Integer> answer_list = new ArrayList<>();
        int idx = MAX-1;
        do {
            if(!list[idx].isEmpty()){// list[idx].size()>0
                answer_list.add(list[idx].poll()); // list.get(0), list.remove(0)
            }
            else{
                idx--;
            }


        }while(k>answer_list.size());
        int[] answer = new int[answer_list.size()];
        for(int i = 0 ; i<answer.length ; i++){
            answer[i] = answer_list.get(i);
        }
        Arrays.sort(answer);
        return answer;

    }
    public static void main(String[] args) {
        Contests c = new Contests();
        int[][] contests = new int[30000][3];
        for(int i = 0 ; i<contests.length ; i++){
            contests[i] = new int[]{1,1,1};
        }
        int[] answer = c.solution(contests, 10000, 2);
        for(int i : answer) System.out.println(i);
    }
}
