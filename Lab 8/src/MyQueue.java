public class MyQueue<T> implements QueueADT <T>{
    MyLinkedList<T> queue;
    public MyQueue(){
        queue = new MyLinkedList<>();
    }
    public void offer(T item){
        queue.add(item);}
    public T poll(){
        return queue.remove(0);}
    public T peek(){return queue.get(0);}

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size(){return queue.size();}

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){return queue.isEmpty();}

    /**
     * Clear out the data structure
     */
    public void clear() {
        while (!queue.isEmpty()) {
           Square temp =  (Square) poll();
           temp.setExplored();
        }
    }

    @Override
    public String toString() {return queue.toString();}
}
