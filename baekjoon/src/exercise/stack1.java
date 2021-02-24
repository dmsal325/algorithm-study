package exercise;

import java.util.Stack;

/** 2021.02.24 codility : Brackets
 *  소요시간 : 1시간
 */
public class stack1 {
    public static int solution(String S) {
        // write your code in Java SE 8
        if(S.length()%2 != 0){
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for(int k=0;k<S.length();k++){
            char c = S.charAt(k);

            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return 0;
                }
                char temp = stack.pop();

                if(c==')' && temp !='('){
                    return 0;
                }else if(c=='}' && temp !='{'){
                    return 0;
                }else if(c==']' && temp !='['){
                    return 0;
                }

            }
        }

        if(!stack.isEmpty()){
            return 0;
        }

        return 1;




    }

    public static void main(String[] args){
        String S = "{[()()]}";
        int result = solution(S);
        System.out.println(result);

    }
}
