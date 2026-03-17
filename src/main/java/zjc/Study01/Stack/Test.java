package zjc.Study01.Stack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [1,1,4,2,1,1,0,0]
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] temperatures = {30,60,90};
        int[] answer= Arrays.copyOf(temperatures, temperatures.length);
        // 初始最高温度
        int sumtempare =0;
        // 入栈
        for(int i = 0; i < answer.length; i++){
            sumtempare = temperatures[i];
            for(int j = i; j < temperatures.length;j++){
                if(sumtempare >= temperatures[j]){
                    stack.push(temperatures[i]);
                }else{
                    answer[i] = stack.top()+1;
                    stack.clearStack();
                    break;
                }
                if(j==temperatures.length-1){
                    answer[i] = 0;
                }
            }
        }
        for(int i = 0; i < answer.length;i++){
            System.out.print(answer[i]+",");
        }
    }
}
