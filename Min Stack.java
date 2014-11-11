/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

public class MinStack {

	private Point node = new Point(0, Integer.MAX_VALUE, null);

    private class Point {
        int val, minVal;
        Point next;
        Point(int val, int minVal, Point next) {
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }

    public void push(int x) {
        Point temp = new Point(x, Math.min(x, (null==node.next ? node.minVal : node.next.minVal)), node.next);
        node.next = temp;
    }

    public void pop() {
        node.next = node.next.next;
    }

    public int top() {
        return node.next.val;
    }

    public int getMin() {
        return node.next.minVal;
    }
}