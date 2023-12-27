package laba6;

import java.util.*;
class Stack<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
    }
}

public class task2Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}

