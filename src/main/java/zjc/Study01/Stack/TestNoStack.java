package zjc.Study01.Stack;

import java.util.Arrays;
/// [3,1,1,2,1,1,0,1,1,0]
public class TestNoStack {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1; // 栈顶指针

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int prevIndex = stack[top--];
                answer[prevIndex] = i - prevIndex;
            }
            stack[++top] = i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ,");
        }
    }
}
