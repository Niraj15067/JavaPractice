package com.lamda;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // Push the element to an empty queue (either queue1 or queue2)
        if (queue1.isEmpty()) {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        } else {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // Pop from the non-empty queue (either queue1 or queue2)
        if (!queue1.isEmpty()) {
            return queue1.poll();
        } else {
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        // Return the front element of the non-empty queue (either queue1 or queue2)
        if (!queue1.isEmpty()) {
            return queue1.peek();
        } else {
            return queue2.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        // Check if both queues are empty
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        // Example usage:
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());  // Output: 2
        System.out.println(myStack.pop());  // Output: 2
        System.out.println(myStack.empty());  // Output: false
    }
}

