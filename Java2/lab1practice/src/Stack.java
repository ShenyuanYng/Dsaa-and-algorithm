public class Stack<T> {
    T[] element;
    int size;
    int CAPACITY = 10;

    public Stack(int capacity) {
        CAPACITY = capacity;
        this.element = (T[]) new Object[CAPACITY];

    }

    public void push(T t) {
        //TODO: complete the method, push an element into the stack if the stack is not full.
        if (size < CAPACITY) {
            element[size++] = t;
        } else {
            System.out.println("Stack is full. Cannot push more elements.");
        }
    }

    public T pop() {
        //TODO: complete the method, pop and return the top element from stack if it is not empty.
        if (!isEmpty()) {
            T poppedElement = element[--size];
            element[size] = null;  // Set the popped element to null to avoid memory leaks
            return poppedElement;
        } else {
            System.out.println("Stack is empty. Cannot pop an element.");
            return null;
        }
    }

    public void showElements() {
        //TODO: complete the method, print all elements from the bottom to top.
        for (int i = 0; i < size; i++) {
            System.out.println(element[i]);
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(10);
        stack.showElements();
    }
}