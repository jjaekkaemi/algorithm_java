package programmers.sort;

public class KthNum {

    class Solution {
        public void merge(int[] array, int left, int mid, int right){
            int l = mid-left+1;
            int r = right-mid;

            int[] la = new int[l];
            int[] ra = new int[r];
            for(int i = 0 ; i<l ; i++) la[i] = array[left+i];
            for(int i = 0 ; i<r ; i++) ra[i] = array[mid+1+i];

            int i = 0, j = 0 ;
            int k = left;
            while(i<l && j<r){
                if(la[i]<ra[j]) array[k++] = la[i++];
                else array[k++] = ra[j++];
            }
            while(i<l) array[k++] = la[i++];
            while(j<r) array[k++] = ra[j++];


        }
        public void sort(int[] array, int left, int right){
            if(left<right){
                int mid = (int)((left+right)/2);
                sort(array, left, mid);
                sort(array, mid+1, right);
                merge(array, left, mid, right);
            }
            int mid = (int)(array.length/2);
        }
        public int[] createArray(int[] orignals, int start, int end){
            int[] news = new int[end-start+1];
            for(int i = 0 ; i < news.length ; i++) {
                news[i] = orignals[start-1+i];
            }
            return news;
        }
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int idx = 0 ;
            for(int[] command : commands){
                int i = command[0], j = command[1], k = command[2];
                int[] new_array = createArray(array, i, j);
                sort(new_array, 0, new_array.length-1);
                answer[idx++] = new_array[k-1];
            }
            return answer;
        }
    }
}
