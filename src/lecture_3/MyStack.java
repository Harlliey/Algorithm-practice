package lecture_3;

/*
 * Leetcode 225. Implement Stack using Queues
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	Queue<Integer> data;
	Queue<Integer> help;
	
	public MyStack() {
		data = new LinkedList<Integer>();
		help = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		data.add(x);
	}
	
	public int pop() {
		while (data.size() > 1) {
			help.add(data.poll());
		}
		
		int res = data.poll();
		reverse();
		return res;
	}
	
    public int top() {
    	while (data.size() > 1) {
    		help.add(data.poll());
    	}
    	
    	int res = data.poll();
    	help.add(res);
    	reverse();
        return res;
    }
    
    public boolean empty() {
    	
    	return data.isEmpty() && help.isEmpty();
    }
    
    public void reverse() {
    	Queue<Integer> tmp = data;
    	data = help;
    	help = tmp;
    }
}
