package zjc.Study01.Stack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [1,1,4,2,1,1,0,0]
 */
public class Test {
    public static void main(String[] args) {
        {
            int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
            int n = temperatures.length;
            Stack<Integer> stack = new Stack<>();
            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    int preIndex = stack.peek();
                    stack.pop();
                    answer[preIndex] = i - preIndex;
                }
                stack.push(i);
            }
            for (int i = 0; i < n; i++) {
                System.out.print(answer[i] + " ,");
            }
        }
    }
}
