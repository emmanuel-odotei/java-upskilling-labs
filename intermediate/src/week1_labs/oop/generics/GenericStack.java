package intermediate.src.week1_labs.oop.generics;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<T> {
    private final ArrayList<T> elements;
    
    // Constructor to initialize the stack
    public GenericStack() {
        elements = new ArrayList<>();
    }
    
    // Pushes an element onto the stack
    public void push(T value) {
        elements.add(value);
    }
    
    // Pops an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.removeLast();
    }
    
    // Peeks at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.getLast();
    }
    
    // Checks if the stack is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    // Gets the current size of the stack
    public int size() {
        return elements.size();
    }
    
    public static void main(String[] args) {
        // Integer stack
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Integer Stack Top: " + intStack.peek()); // Output: 20
        System.out.println("Integer Stack Popped: " + intStack.pop()); // Output: 20
        
        // String stack
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("String Stack Top: " + stringStack.peek()); // Output: World
        System.out.println("String Stack Popped: " + stringStack.pop()); // Output: World
    }
}
