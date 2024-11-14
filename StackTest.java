interface StackOperations {
    void push(int value);
    int pop();
    void display();
    boolean isFull();
    boolean isEmpty();
}

class DoubleStack implements StackOperations {
    private int[] stack;
    private int top1, top2;
    private static final int MAX_SIZE = 6;

    public DoubleStack() {
        stack = new int[MAX_SIZE];
        top1 = -1;
        top2 = MAX_SIZE;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        if (top1 < top2 - 1) {
            stack[++top1] = value;
        } else if (top2 > top1 + 1) {
            stack[--top2] = value;
        } else {
            System.out.println("Stacks are full. Cannot push!");
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        if (top1 >= 0) {
            return stack[top1--];
        } else if (top2 < MAX_SIZE) {
            return stack[top2++];
        }
        return -1;
    }

    @Override
    public void display() {
        System.out.println("Stack 1: ");
        for (int i = 0; i <= top1; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();

        System.out.println("Stack 2: ");
        for (int i = MAX_SIZE - 1; i >= top2; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isFull() {
        return top1 + 1 == top2;
    }

    @Override
    public boolean isEmpty() {
        return top1 == -1 && top2 == MAX_SIZE;
    }
}

public class StackTest {
    public static void main(String[] args) {
        DoubleStack stack = new DoubleStack();

        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        stack.push(30);

        stack.display();

        System.out.println("Popped from Stack 1: " + stack.pop());
        System.out.println("Popped from Stack 2: " + stack.pop());

        stack.display();

        stack.push(35);
        stack.push(40);  

        stack.push(45);
        stack.push(50);
        stack.push(55); 

        stack.display();

        int[] newArray = new int[2];
        newArray[0] = stack.pop();
        newArray[1] = stack.pop();

        System.out.println("Elements popped and stored in new array:");
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}
