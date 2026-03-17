package zjc.Study01.Stack;

import java.lang.reflect.Array;

public class Stack<T> {
    //设置栈大小
    private static final int DEFAULT_CAPACITY = 5;
    //设置存放数据
    private Object[] array;
    //这是栈顶针
    private int top;

    // 初始化栈
    public Stack() {
        array = new Object[DEFAULT_CAPACITY];
        top = -1;
    }
    // 入栈操作
    public void push(T item) {
        if(top == array.length - 1){
            System.out.println("栈满");
            /// 扩栈
            resize();
        }
        array[++top] = item;
    }
    // 出栈
    public void pop() {
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        array[top--] = null;
    }
    // 查看栈顶
    public void checkTop(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        System.out.println(array[top]);
    }
    // 查看栈大小
    public void size(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        System.out.println("栈大小为："+top+1);
    }

    // 查看栈
    public void display(){
        if(isEmpty()){
            return;
        }
        for(int i = top; i >= 0; i--) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
    //栈扩容
    public void resize(){
        if(isEmpty()){
            return;
        }
        Object[] newArray = new Object[array.length*2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
    //栈空
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }
    // 栈顶针
    public int top(){
        return top;
    }
    //查看栈顶值
    public T checkTopData(){
        return (T)array[top];
    }
    //请栈
    public void clearStack(){
        top = -1;
    }

    //出栈获取
    public int popnum() {
        if(isEmpty()){
            System.out.println("栈空");
            return 1;
        }
        array[top--] = null;
        return top;
    }
    //
    public int peek(){
        return top;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();
        stack.checkTop();

    }

}
