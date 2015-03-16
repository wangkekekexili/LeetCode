import java.util.Stack;


/**
 * min stack
 * https://oj.leetcode.com/problems/min-stack/
 * 
 * @author Ke Wang
 *
 */
class MinStack {
	
	Stack<Integer> stack;
	Stack<Integer> min;
	
	public MinStack() {
		stack = new Stack<>();
		min = new Stack<>();
	}
	
    public void push(int x) {
        if (stack.isEmpty() == false) {
        	int currentMin = this.min.peek().intValue();
        	if (x < currentMin) {
        		this.min.add(x);
        	} else {
        		this.min.add(currentMin);
        	}
        } else {
        	this.min.add(x);
        }
        this.stack.add(x);
    }

    public void pop() {
        if (this.stack.isEmpty() == false) {
        	this.stack.pop();
        	this.min.pop();
        }
    }

    public int top() {
        if (this.stack.empty() == false) {
        	return this.stack.peek();
        } else {
        	return 0;
        }
    }

    public int getMin() {
        if (this.min.empty() == false) {
        	return this.min.peek();
        } else {
        	return 0;
        }
    }
}
