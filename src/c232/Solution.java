package c232;

import java.util.Stack;

class MyQueue {

    private Stack stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(stack.size(), x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        return (int) stack.remove(0);

    }

    /** Get the front element. */
    public int peek() {

        return (int) stack.get(0);

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
