package old.c155;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private List<Integer> list;
    private int size = 0;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.list = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
        size ++;

    }

    public void pop() {
        stack.pop();
        list.remove(size - 1);
        size --;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Collections.sort(this.list);
        return this.list.get(0);
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        int min = s.getMin();
        s.pop();
        int top = s.top();
        int min2 = s.getMin();
    }
}
