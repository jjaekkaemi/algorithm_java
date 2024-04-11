package programmers.hash;
import java.util.*;
public class PhoneNumber {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Set<String> set = new HashSet<>();
            for(String p : phone_book){
                set.add(p);
            }
            for(String m : set){
                String digit="";
                for(int i = 0 ; i<m.length() ; i++){
                    digit += m.charAt(i);
                    if(set.contains(digit) && !digit.equals(m)){
                        return false;
                    }
                }
            }
            return answer;
        }
    }
}
