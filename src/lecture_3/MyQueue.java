package lecture_3;

/*
 * Leetcode232. Implement Queue using Stacks
 */

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> data;
    private Stack<Integer> help;
    
    public MyQueue() {
        data = new Stack<>();
        help = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
    }
    
    public int pop(){
        if (help.isEmpty()) {
            while (!data.isEmpty()) {
                help.push(data.pop());
            }
        }
        return help.pop();
    }
    
    public int peek() {
        if (help.isEmpty()) {
            while (!data.isEmpty()) {
                help.push(data.pop());
            }
        }
        return help.peek();
    }
    
    public boolean empty() {
        if (data.isEmpty() && help.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
