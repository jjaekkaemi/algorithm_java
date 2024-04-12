package programmers.sort;
import java.util.*;
public class LargestNumber {
    class Solution {
        public String solution(int[] numbers) {
            int len = numbers.length;
            String[] numbers_str = new String[len];
            String answer = "";
            for(int i = 0 ; i<len ; i++){
                String str = "";
                for(int j = 0 ; j<3 ; j++){
                    str+=numbers[i];
                }
                numbers_str[i] = str;
            }
            Arrays.sort(numbers_str);
            for(int i = len-1 ; i>-1 ; i--){
                int ori_length = (int)(numbers_str[i].length()/3);
                answer+=numbers_str[i].substring(0,ori_length);
            }
            if(answer.charAt(0)=='0') return "0";
            return answer;
        }
    }
}
