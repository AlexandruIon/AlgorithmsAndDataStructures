package stack;

public class StackImplementationFixedArray {

    private String stack[];
    private int size;

    public StackImplementationFixedArray(int size) {
        stack = new String[size];
        this.size = size;
    }

    public String pop() {
        if (size > 0) {
            return stack[--size];
        } else return null;
    }

    public void push(String item) {
        stack[size++] = item;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

}
