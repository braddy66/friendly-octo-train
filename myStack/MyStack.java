import java.util.Arrays;
import java.util.EmptyStackException;

class MyStack {
    int size = 0;
    Integer[]arr;
    int initSize;
    
    public MyStack() {
        this(7);
    }
    
    public MyStack(int initSize){
        this.initSize = initSize;
        arr = new Integer[initSize];
    }
        public void clear(){
        arr = new Integer[initSize];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void push(Integer val) {
         if(size == arr.length)
            doubleCapacity();
        
        arr[size] = val;
        size++;
    }
    
    public void doubleCapacity(){
        Integer [] arr2 = new Integer[arr.length*2];
        for(int x = 0; x < arr.length;x++)
            arr2[x] = arr[x];
        arr = arr2;
    }
    
    public Integer pop() {
        if(size == 0)
            throw new EmptyStackException(); 
        size--;
        return arr[size];
    }
    
    public int size(){
        return size;
    }
    
    public Integer peek() {
        return  arr[size-1];
    }
    
    @Override
    public String toString() {
        String s = "top -> ";
        
        for(int x = size-1; x > -1;x--)
            s+=(arr[x] + "\n");
        
        return s;
    }
}
