import java.util.Arrays;
import java.util.EmptyStackException;

class MyStack implements StackADT {
    int size = 0;
    Square[]arr;
    int initSize;
    public MyStack() {
        this(7);
    }
    public void clear(){
        while(!isEmpty())
            pop().setExplored();
    }
    MyStack(int initSize){
        this.initSize = initSize;
        arr = new Square[initSize];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void push(Square val) {
         if(size == arr.length)
            doubleCapacity();
        arr[size] = val;
        size++;
    }
    public void doubleCapacity(){
        Square [] arr2 = new Square[arr.length*2];

        for(int x = 0; x < arr.length;x++)
            arr2[x] = arr[x];

        arr = arr2;
    }

    public Square pop() {
        if(size == 0)
            throw new EmptyStackException();

        Square x = arr[size-1];
        arr[size-1] = null;
        size--;
        return x;

    }
    public int size(){
        return size;
    }

    public Square peek() {
        return  arr[size-1];
    }

    public String toString() {
        return Arrays.toString(arr);}
}