/*
* References available in 'README.md'
*/

public class Stack {
    
    /**
     * Class for the stack used in the SRPN calculator.
     * 
     * Contains methods for stack operations, such as push, pop, peek and error handling.
     */
    
    private int[] stack; // Our stack represented as an array
    private int stackSize; // The size of our stack
    private int stackHead; // The current head / position in our stack

    // Constructor
    public Stack(int size) {
        // Create the stack on initialisation
        stackSize = size;
        stack = new int[stackSize];
        stackHead = -1;
    }

    // Getters
    public int getStackHead() {
        return stackHead;
    }

    // Class Methods
    public void push(int n) {
        // Push a number onto the stack
        if (stackHead == (stackSize - 1)) {
            handleError("overflow");
            return;
        }
        stackHead++;
        stack[stackHead] = n;
    }

    // Pops the top number off the stack
    public void pop() {
        if (stackHead < 0) {
            handleError("underflow");
            return;
        }
        stackHead--; // Decrease the stack head by 1, leaving the value in the array
        return;
    }
    
    // Handles errors such as stack overflow or underflow
    public void handleError(String error) {
        if ("overflow".equals(error)) {
            System.out.println("Stack overflow.");
        } else if ("underflow".equals(error)) {
            System.out.println("Stack underflow.");
        }
    }
    
    // Returns the top number on the stack
    public int peek() {
        
        if (stackHead == -1) {
            return Integer.MIN_VALUE; // We have fallen below the array. This seems to match our test SRPN behaviour
        }
        return stack[stackHead];
    }

    // Returns the number at the specified head
    public int peek(int head) {
        // Check for stack over or underflow
        if (head > stackHead) {
            return Integer.MAX_VALUE;
        }
        if (head < 0) {
            return Integer.MIN_VALUE;
        }
        // Return the value of our array
        return stack[head];
    }

    // Helper utility to return the top number on the stack and then pop it
    public int peekAndPop() {
        int a = this.peek();
        this.pop();
        return a;

    }

    // Returns the number of elements in the stack
    public int size() {
        return stackSize;
    }

    // Returns the stack as a string
    public String printStack() {
        if (stackHead == -1) {
            return Integer.toString(Integer.MIN_VALUE);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= stackHead; i++) {
            sb.append(stack[i]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
