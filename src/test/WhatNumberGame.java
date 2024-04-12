package test;

public class WhatNumberGame {
    class Solution {
        public int solution(int n, int a, int b){
            int answer = 0 ;
            int left = a, right = b;
            do {
                if(left%2!=0) left++;
                if(right%2!=0) right++;
                left/=2;
                right/=2;
                answer++;
            }while(left!=right);
            return answer;
        }
    }
}
