package programmers.hash;
import java.util.*;
public class Phonekemon {
    class Solution {
        public int solution(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num,0);
            }
            if(map.size()>nums.length/2){
                return nums.length/2 ;
            }
            return map.size();
        }
    }
}
