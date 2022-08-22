package com.hackerrank.challenges.datastructures.stacks;

import java.io.*;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = BalancedBrackets.isBalanced(s);

            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

        bufferedReader.close();
//        bufferedWriter.close();
    }

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     * [()][{}[{}[{}]]][]{}[]{}[]{{}({}(){({{}{}[([[]][[]])()]})({}{{}})})}
     */

    public static String isBalanced(String s) {


        boolean isBalanced = true;

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (!stack.empty()) {
                if (c == '}' && '{' != stack.pop()) {
                    return "NO";
                } else if (c == ']' && '[' != stack.pop()) {
                    return "NO";
                } else if (c == ')' && '(' != stack.pop()) {
                    return "NO";
                }
            }
        }

        return "YES";

    }


}
