

public class MyLinkedList {
    private class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }
}
    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        head = null;
        size = 0;
        tail = head;
    }
    public MyLinkedList(int val){
        this();
        addAtHead(val);
    }
    int size(){
        return size;
    }
   
    public int get(int index) {
        if(index < 0 || index >=size)
           throw new IndexOutOfBoundsException();
        ListNode temp = head;
        if(index == size-1)
            return tail.val;
        for(int x = 0; x < index;x++)
            temp = temp.next;
        return temp.val;
    }
    public boolean contains(int target){
        ListNode temp = head;
        while(temp!=null){
            if(temp.val == target)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void addAtHead(int val) {
        ListNode h = new ListNode(val);
        // tail = head;
        h.next = head;
        head = h;
        if(size == 0)
            tail = head;
        size++;
     }
    

    public void add(int val) {
        if(head == null)
            addAtHead(val);
    
    else{
       tail.next = new ListNode(val);
       tail = tail.next;  
       size++;
       
    }

    
}
public void add(int val, int index) {
    if(index < 0 || index > size)
        return;
    
    if(index == 0)
        addAtHead(val);
    
    else if(index == size)
        add(val);
    
    else{
        ListNode temp = head;
        for(int x = 0; x < index-1;x++)
            temp = temp.next;
        ListNode node =  new ListNode(val);
        node.next = temp.next;
        temp.next = node;
        size++;
}
}
    public int remove(int index) {
        int ans = 0;
        if(size <= index || index < 0)
            throw new IndexOutOfBoundsException();
        
        else if(index == 0){
        ans = head.val;
        head = head.next;
        size--;
        }
         
        else{
            ListNode temp = head;
            for(int x = 0; x < index-1;x++)
                temp = temp.next;
            ans = temp.next.val;
            if(index == size-1)
                tail = temp;
            temp.next = temp.next.next;
            size--;
        }
        
    return ans;
}
    @Override
    public String toString() {
        String ans = "[";
        ListNode temp = head;
        while(temp != null){
            ans+=temp.val;
            temp = temp.next;
            if(temp!= null)
            ans+=", ";
        }
        ans+="]";
        return ans;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int indexOf(int val){
        int i = 0;
        ListNode temp = head;
        if(val == tail.val)
            return size-1;
        while(temp!= null){
            if(temp.val == val)
                return i;
            i++;
            temp = temp.next;
        }
        return -1;
    }
    public void set(int val, int index){
        if(index < 0 || index >= size)
            return;
         if(index == size-1)
            tail.val = val;
        else{ 
        ListNode temp = head;    
        for(int x = 0; x < index;x++)
            temp = temp.next;
        temp.val = val;
        }
    }
}

// /**
//  * Your MyLinkedList object will be instantiated and called as such:
//  * MyLinkedList obj = new MyLinkedList();
//  * int param_1 = obj.get(index);
//  * obj.addAtHead(val);
//  * obj.addAtTail(val);
//  * obj.addAtIndex(index,val);
//  * obj.deleteAtIndex(index);
//  */
