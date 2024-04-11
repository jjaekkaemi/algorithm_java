package programmers.dfs_bfs;
import java.util.*;
public class WordConversion {
    class WordChange {
        private String s;
        private int d;
        public WordChange(String s, int d){
            this.s = s;
            this.d = d;
        }
        public String getS() { return s; }
        public int getD() { return d; }
    }
    class Solution {
        public boolean one_char_differ_check(String begin, String word){
            boolean check = false;
            for(int i = 0 ; i<begin.length() ; i++){
                if(begin.charAt(i)!=word.charAt(i)){
                    if(!check) check=true;
                    else return false;
                }
            }
            return true;
        }
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            Queue<WordChange> queue = new LinkedList<>();
            queue.offer(new WordChange(begin, 0));
            boolean[] visited = new boolean[words.length];
            while(!queue.isEmpty()){
                WordChange b = queue.poll();
                String s = b.getS();
                int d = b.getD();
                if(s.equals(target)) return d;
                for(int i = 0; i<words.length ; i++){
                    if(!visited[i]){
                        if(one_char_differ_check(s, words[i])){
                            visited[i]=true;
                            queue.offer(new WordChange(words[i],d+1));
                        }
                    }
                }
            }
            return answer;
        }
    }
}
