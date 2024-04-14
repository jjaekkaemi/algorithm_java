package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DigitReducer {
    public ArrayList<int[]> makeNum(String s){
        int mid = (int)(s.length()/2);
        String str1 = s.substring(0, mid);
        String str2 = s.substring(mid);
        ArrayList<int[]> list = new ArrayList<>();
        if(str2.length()>1 && str2.charAt(0)=='0'){
            int mid1 = mid-1;
            int mid2 = mid+1;
            while(mid1>0){
                str1 = s.substring(0,mid1);
                str2 = s.substring(mid1);
                if(str2.length()>1 && str2.charAt(0)=='0'){
                    mid1--;
                } else {
                    list.add(new int[]{Integer.parseInt(str1), Integer.parseInt(str2)});
                    break;
                }
            }

            while(mid2<s.length()){
                str1 = s.substring(0,mid2);
                str2 = s.substring(mid2);
                if(str2.length()>1 && str2.charAt(0)=='0'){
                    mid2++;
                } else {
                    list.add(new int[]{Integer.parseInt(str1), Integer.parseInt(str2)});
                    break;
                }
            }
        }
        else{
            list.add(new int[]{Integer.parseInt(str1), Integer.parseInt(str2)});
        }
        return list;
    }
    public int[] solution(int s){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, s});
        int[] answer = new int[2];
        while(!queue.isEmpty()){
            int[] count_num = queue.poll();
            int count = count_num[0];
            int num = count_num[1];

            if(num<10) {
                answer[0] = count;
                answer[1] = num;
                break;
            }

            ArrayList<int[]> list = makeNum(String.valueOf(num));
            for(int i = 0 ; i<list.size() ; i++){
                int[] split_num = list.get(i);
                queue.offer(new int[]{count+1, split_num[0]+split_num[1]});

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DigitReducer digitReducer = new DigitReducer();
        int[] answer = digitReducer.solution(73425);
        for(int a : answer) System.out.println(a);

        answer = digitReducer.solution(10007);
        for(int a : answer) System.out.println(a);

        answer = digitReducer.solution(9);
        for(int a : answer) System.out.println(a);

    }
}
