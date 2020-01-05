package lecture_3;

/*
 * Leetcode155. MinStack
 */

import java.util.Stack;

public class MinStack {

	private Stack<Integer> data;
	private Stack<Integer> help;
	
	public MinStack() {
		data = new Stack<>();
		help = new Stack<>();
	}
	
	public void push(int x) {
		if (help.isEmpty()) {
			help.push(x);
		} else {
			int top = help.peek();
			if (x < top) {
				help.push(x);
			} else {
				help.push(top);
			}
		}
		data.push(x);
	}
	
    public void pop() {
        data.pop();
        help.pop();
    }
    
    public int top() {
    	return data.peek();
    }
    
    public int getMin() {
        return help.peek();
    }
}
