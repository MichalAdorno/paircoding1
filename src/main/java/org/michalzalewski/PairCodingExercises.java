package org.michalzalewski;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class PairCodingExercises {
    public static void main(String[] args) {
        System.out.println("Java 17");
    }

    //time O(n) space O(1)
    public static boolean validateIfAnagrams(final String input1, final String input2){
        //ABAA -> counter['A']=3,,
        if(input1 == null && input2 == null){
            return true;
        }
        if(input1 == null && input2 != null){
            return false;
        }
        if(input2 == null && input1 != null){
            return false;
        }
        if(input1.length() != input2.length()){
            return false;
        }
        final int[] counter = new int[256];//0..255
        HashMap<Character, Integer> counterMap = new HashMap<>();

        for(int i=0;i<input1.length();i++){
            final var s1 = input1.charAt(i);
            final var s2 = input2.charAt(i);

            counter[s1]++;
            counter[s2]--;
        }
        for(int i=0;i<counter.length;i++){
            if(counter[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static boolean validateParentheses(final String expression) {
        if (expression == null || expression.length() == 0){
            return true;
        }
        //
        final Deque<Character> stack = new LinkedList<>();
        //)
        for (final char ch : expression.toCharArray()){
            //([{
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch){
                return false;
            }
        }
        return stack.isEmpty() ;
    }
}
